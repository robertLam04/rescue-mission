package ca.mcmaster.se2aa4.island.team118.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.MissionPhases.*;
import ca.mcmaster.se2aa4.island.team118.*;

/* *
public class MidController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public JSONObject previous_decision;

    private Drone drone;
    public GameMap map;
    private Reader reader;
    private Phase phase;
    private Decision decision = new Decision();
    private int POICount = 0;

    public MidController(Integer battery, Direction initial_direction) {
        drone = new Drone(battery, initial_direction);
        map = new GameMap();
        phase = new FindGround(drone);
    }

    @Override
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
        
        /*
         * try{
            if (map.getTile(drone.potentialFly()).getIsBorder()&& !phase.getCurrentPhase().equals("Danger")){
                phase = new Danger(drone);
            }
            if (map.getTile(drone.potentialDoubleFly()).getIsBorder()){
                phase = new Danger(drone);
            }
        }catch (NullPointerException e){
            logger.info(e);
        }

         *
        
        //If phase is final stop
        if (phase.isFinal()) {
            previous_decision = decision.stop();
            return decision.stop().toString();
        }

        previous_decision = phase.getNextDecision();
        return previous_decision.toString();
    }
    
    @Override
    public void acknowledge(JSONObject response) {
        reader = new JsonReader(response);
        logger.info(drone.getBattery());
        reader.updateBattery(drone);
        logger.info(drone.getBattery());

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
                Position tile_position = new Position(drone.getLocation().getX(),drone.getLocation().getY());
                tile_position.move(range, echo_dir);
                map.putTile(tile_position, tile);
                //Update the phase if the tile is ground
                if (tile.isGround() && phase.getCurrentPhase().equals("FindGround")) {
                    phase = new FlyToGround(drone, echo_dir, range + 1);
                }
                        
                break;
            case "scan":
                tile = reader.scan();
                map.putTile(drone.getLocation(),tile);
                
                //Switch to Explore ground phase if scan is called in FlyToGround phase
                if (phase.getCurrentPhase().equals("FlyToGround")) {phase = new ExploreGround(drone);}
                
                //Switch to FindGround phase if scan is not a land tile
                if (!tile.isGround()) {phase = new FindGround(drone);}

                //Return home if a POI is found
                if (tile.isPOI()) {POICount++;}
                if (POICount == Integer.MAX_VALUE) {phase = new ReturnHome();}

                break;
            case "fly":
                //Update the drones position
                drone.fly();
                break;
            case "heading":
                //Get the direction of the turn
                Direction turn_heading = Direction.fromString(previous_decision.getJSONObject("parameters").getString("direction"));
                //Update the drones position
                drone.heading(turn_heading);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String closestCreek() {
        try {
            Map<Position, String> creeksMap = map.creekPositions();
            Position sitePosition = map.sitePosition();
            double closest_distance = Double.MAX_VALUE;
            String closest_creek = "";
            if (creeksMap.isEmpty()) {
                return "No creeks found";
            } else {
                for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                    Position creekPosition = entry.getKey();
                    String creekId = entry.getValue();
                    double current_distance = sitePosition.distanceFrom(creekPosition);
                    if (current_distance < closest_distance) {
                        closest_distance = current_distance;
                        closest_creek = creekId;
                    }
                }
            }
            logger.info("Closest creek: " + closest_creek);
            return closest_creek;
        } catch (NoSuchElementException e) {
            String random_creek = getRandomCreekId();
            logger.info(random_creek);
            return random_creek;
        }
    }

    private String getRandomCreekId() {
        Map<Position, String> creeksMap = map.creekPositions();
        List<String> creekIds = new ArrayList<>(creeksMap.values());
        Random random = new Random();
        if (creeksMap.isEmpty()) {return "No creeks found";}
        return creekIds.get(random.nextInt(creekIds.size()));
    }

    //Helper for testing (delete later)
    public void printPOIS() {
        try {
            Map<Position, String> creeksMap = map.creekPositions();
            Position sitePosition = map.sitePosition();
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String Id = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + Id);
            }
            logger.info("Site Position: " + sitePosition.toString());
        } catch (NoSuchElementException e) {
            Map<Position, String> creeksMap = map.creekPositions();
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String Id = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + Id);
            }
            logger.info("No emergency site found");
        }
        
    }

}
*/