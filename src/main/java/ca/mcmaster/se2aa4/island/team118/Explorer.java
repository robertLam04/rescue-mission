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
    private Drone drone;
    private Acknowledger translator;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading").toLowerCase();
        Integer batteryLevel = info.getInt("budget");
        Direction initial_heading;
        switch (direction) {
            case "n":
                initial_heading = Direction.NORTH;
                break;
            case "e":
                initial_heading = Direction.EAST;
                break;
            case "s":
                initial_heading = Direction.SOUTH;
                break;
            case "w":
                initial_heading = Direction.WEST;
                break;
            default:
                throw new IllegalArgumentException();
            }

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        drone = new Drone(batteryLevel, initial_heading);

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
        
        //Check what the previous decision was and call translator methods based on this
        switch (memController.previousDecision()) {
            case "stop": 
                break;
            case "echo":
                translator.echo();
                break;
            case "scan":
                translator.scan();
                break;
            case "fly":
                translator.fly();
                break;
            case "heading":
                //translator.heading();
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
