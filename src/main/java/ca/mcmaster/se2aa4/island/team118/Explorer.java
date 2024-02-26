package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    Controller memController = new MemoryController();
    private Map map;
    private Drone drone;
    private Acknowledger translator;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading").toLowerCase();
        Integer batteryLevel = info.getInt("budget");
        Direction initial_heading = new Direction(direction);

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        drone = new Drone(batteryLevel, initial_heading);
        map = new Map();

    }

    @Override
    public String takeDecision() {
        String decision = memController.makeDecision();
        logger.info(decision);
        logger.info(memController.previousDecision());
        return decision;
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));

        translator = new JsonAcknowledger(response);

        translator.updateBattery(drone);

        translator.updateStatus(drone);

        Tile tile;
       
        //Check what the previous decision was and call translator methods based on this
        JSONObject previous = memController.previousDecision();
        switch (previous.getString("action")) {
            case "stop": 
                break;
            case "echo":
                tile = translator.echo();
                Integer range = translator.range();
                //Check direction of echo and place tile
                JSONObject params = previous.getJSONObject("Direction");
                String direction = params.getString("Direction");
                Direction echo_dir = new Direction(direction);
                //Technical Debt - Violates Law of demeter, digging into drone object to get Position
                switch(echo_dir.getHeading()) {
                    case NORTH:
                        map.putTile(drone.getLocation().moveY(range), tile);
                        break;
                    case EAST:
                        map.putTile(drone.getLocation().moveX(range), tile);
                        break;
                    case SOUTH:
                        map.putTile(drone.getLocation().moveY(-range), tile);
                        break;
                    case WEST:
                        map.putTile(drone.getLocation().moveX(-range), tile);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                break;
            case "scan":
                tile = translator.scan();
                map.putTile(drone.getLocation(),tile);
                break;
            case "fly":
                
                break;
            case "heading":
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

    public enum Biome {
        UNKNOWN,
        LAKE;
    }

}
