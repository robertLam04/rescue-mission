package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import java.util.Queue;
import java.util.LinkedList;

public class MidController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public JSONObject previous_decision;
    private Drone drone;
    private GameMap map;
    private Reader reader;
    private Phase phase;
    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue;

    public MidController(Integer battery, Direction initial_direction) {
        drone = new Drone(battery,initial_direction);
        map = new GameMap();
        phase = Phase.FINDGROUND;
        decision_queue = new LinkedList<>();
    }

    public String makeDecision() {
       
        //if (battery == low) { return decision.stop().toString() }

        if (Phase.FINDGROUND.equals(phase)) {
            decision_queue.add(decision.echo(drone.getDroneHeading()));
            decision_queue.add(decision.echo(drone.getDroneHeading().left()));
            decision_queue.add(decision.echo(drone.getDroneHeading().right()));

        } 
        
        previous_decision = decision.stop();
        return decision.stop().toString();

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
                    case n:
                        map.putTile(new Position(drone.getLocation().moveY(range)), tile);
                        break;
                    case e:
                        map.putTile(new Position(drone.getLocation().moveX(range)), tile);
                        break;
                    case s:
                        logger.info("Placing tile");
                        map.putTile(new Position(drone.getLocation().moveY(-range)), tile);
                        logger.info("Tile placed");
                        break;
                    case w:
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
        map.printMap();
    }
}
