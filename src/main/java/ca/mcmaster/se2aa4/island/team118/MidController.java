package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class MidController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public JSONObject previous_decision;
    private Drone drone;
    private GameMap map;
    private Reader reader;
    private int count = 1;
    private Phase phase;

    public MidController(Integer battery, Direction initial_direction) {
        drone = new Drone(battery,initial_direction);
        map = new GameMap();
        phase = Phase.FINDGROUND;
    }

    public String makeDecision() {
        /*if (count == 1) {
            JSONObject decision = new JSONObject();
            logger.info(drone.getLocation().toString());
            decision.put("action", "heading");
            decision.put("parameters", (new JSONObject()).put("direction", "S"));
            previous_decision = decision;
            count++;
            return decision.toString();
        } else {
            JSONObject decision = new JSONObject();
            decision.put("action", "stop");
            previous_decision = decision;
            return decision.toString();
        }

        JSONObject decision = new JSONObject();

        if (phase == Phase.FINDGROUND) {

        } else if (phase == Phase.FLYGROUND) {

        }*/

        return previous_decision.toString(); // place holder to make method work delete later
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
                Direction echo_dir = new Direction(direction);
                //Technical Debt - Violates Law of demeter, digging into drone object to get Position
                switch(echo_dir.getHeading()) {
                    case NORTH:
                        map.putTile(new Position(drone.getLocation().moveY(range)), tile);
                        break;
                    case EAST:
                        map.putTile(new Position(drone.getLocation().moveX(range)), tile);
                        break;
                    case SOUTH:
                        logger.info("Placing tile");
                        map.putTile(new Position(drone.getLocation().moveY(-range)), tile);
                        logger.info("Tile placed");
                        break;
                    case WEST:
                        map.putTile(new Position(drone.getLocation().moveX(-range)), tile);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                break;
            case "scan":
                tile = reader.scan();
                map.putTile(drone.getLocation(),tile);
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
                Direction turn_heading = new Direction(previous_decision.getJSONObject("parameters").getString("direction"));
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
        map.printMap();
    }
}
