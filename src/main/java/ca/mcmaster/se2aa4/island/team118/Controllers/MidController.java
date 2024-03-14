package ca.mcmaster.se2aa4.island.team118.Controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.MissionPhases.*;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.ReturnHome;
import ca.mcmaster.se2aa4.island.team118.*;

public class MidController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public JSONObject previous_decision;

    private Drone drone;
    private GameMap map;
    private Reader reader;
    private Phase phase;
    private Decision decision = new Decision();
    private int POICount = 0;

    public MidController(Integer battery, Direction initial_direction) {
        drone = new Drone(battery, initial_direction);
        map = new GameMap();
        phase = new FindGround(drone);
    }

    public String makeDecision() {
       
        if (((int)drone.distanceToStop() == 0)&&(drone.getBattery()<=7)){
            previous_decision = decision.stop();
            return previous_decision.toString();
        } else if ((drone.distanceToStop() <= 10)&&(drone.getBattery() <= 15)) { 
            previous_decision = decision.stop();
            return previous_decision.toString();
        } else if ((drone.distanceToStop() > 10)&&(drone.getBattery() <= 25)) {
            previous_decision = decision.stop();
            return previous_decision.toString();
        }

        //If phase is final stop
        if (phase.isFinal()) {
            previous_decision = decision.stop();
            return decision.stop().toString();
        }

        previous_decision = phase.getNextDecision();
        return previous_decision.toString();

    }
    
    public void acknowledge(JSONObject response) {
        reader = new JsonReader(response);
        logger.info(drone.getBattery());
        reader.updateBattery(drone);
        logger.info(drone.getBattery());
        reader.updateStatus(drone);

        Tile tile;

        switch (previous_decision.getString("action")) {
            case "stop": 
                break;
            case "echo":
                tile = reader.echo();
                Integer range = reader.range();
                //Check direction of echo and place tile
                JSONObject params = previous_decision.getJSONObject("parameters");
                String direction = params.getString("direction");
                Direction echo_dir = Direction.fromString(direction);
                //Technical Debt - Violates Law of demeter, digging into drone object to get Position
                switch(echo_dir.getHeading()) {
                    case N:
                        map.putTile(new Position(drone.getLocation().moveY(range)), tile);
                        //Update the phase if the tile is ground
                        if (tile.isGround() && phase.getCurrentPhase().equals("FindGround")) {
                            phase = new FlyToGround(drone, echo_dir, range + 1);
                        }
                        break;
                    case E:
                        map.putTile(new Position(drone.getLocation().moveX(range)), tile);
                        //Update the phase if the tile is ground
                        if (tile.isGround() && phase.getCurrentPhase().equals("FindGround")) {
                            phase = new FlyToGround(drone, echo_dir, range + 1);
                        }
                        break;
                    case S:
                        map.putTile(new Position(drone.getLocation().moveY(-range)), tile);
                        //Update the phase if the tile is ground
                        if (tile.isGround() && phase.getCurrentPhase().equals("FindGround")) {
                            phase = new FlyToGround(drone, echo_dir, range + 1);
                        }
                        break;
                    case W:
                        map.putTile(new Position(drone.getLocation().moveX(-range)), tile);
                        //Update the phase if the tile is ground
                        if (tile.isGround() && phase.getCurrentPhase().equals("FindGround")) {
                            phase = new FlyToGround(drone, echo_dir, range + 1);
                        }
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                break;
            case "scan":
                tile = reader.scan();
                map.putTile(drone.getLocation(),tile);
                
                //Switch to Explore ground phase if scan is called in FlyToGround phase
                if (phase.getCurrentPhase().equals("FlyToGround")) {phase = new ExploreGround(drone);}
                
                //Switch to FindGround phase if scan is not a land tile
                if (!tile.isLand()) {phase = new FindGround(drone);}

                //Return home if a POI is found
                if (tile.isPOI()) {POICount++;}
                if (POICount == 10) {phase = new ReturnHome();}

                break;
            case "fly":
                //Update the drones position
                drone.fly();
                //Create an unknown (empty) tile
                tile = new Tile();
                //Add the tile to the map at the drones position
                map.putTile(drone.getLocation(), tile);
                break;
            case "heading":
                //Get the direction of the turn
                Direction turn_heading = Direction.fromString(previous_decision.getJSONObject("parameters").getString("direction"));
                //Update the drones position
                drone.heading(turn_heading);
                //Create an unknown (empty) tile
                tile = new Tile();
                //Add the tile to the map at the drone position
                map.putTile(drone.getLocation(), tile);
                break;
            default:
                throw new IllegalArgumentException();
        }
        logger.info(phase.getCurrentPhase());
        logger.info(POICount);
        map.printCreeks();
    }
}
