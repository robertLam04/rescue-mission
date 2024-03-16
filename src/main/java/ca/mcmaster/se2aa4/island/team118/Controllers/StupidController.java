package ca.mcmaster.se2aa4.island.team118.Controllers;

import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Position;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.GameMap;
import ca.mcmaster.se2aa4.island.team118.JsonReader;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.Reader;
import ca.mcmaster.se2aa4.island.team118.Tile;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.ExploreGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.FindGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.FlyToGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.ReturnHome;

public class StupidController implements Controller {

    private final Logger logger = LogManager.getLogger();
    private Maneuver maneuvers = new Maneuver();
    private Drone drone;
    public JSONObject previous_decision;
    public GameMap map;
    private Reader reader;
    private Phase phase;
    private int POICount = 0;
    private Queue<JSONObject> decisionQueue;

    public StupidController(Integer battery, Direction initial_direction) {
        drone = new Drone(battery, initial_direction);
        map = new GameMap();
        phase = new FindGround(drone);
        decisionQueue = maneuvers.shiftLeft(drone.getDroneHeading());
    }

    public String makeDecision() {
        JSONObject decision = new JSONObject();
        if (!decisionQueue.isEmpty()) {
            previous_decision = decisionQueue.remove();
        } else {
            previous_decision = decision.put("action", "stop");
        }
        logger.info("** Decision: {}",decision.toString());
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
                if (phase.getCurrentPhase().equals("Danger")){
                    phase = new FindGround(drone);
                }
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
                if (POICount == Integer.MAX_VALUE) {phase = new ReturnHome();}

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
        logger.info(drone.getLocation().toString());
        logger.info(drone.getDroneHeading().toString());
    }
    
}
