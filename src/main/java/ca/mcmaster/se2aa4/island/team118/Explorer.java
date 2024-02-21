package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    Controller stupid = new StupidController();
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
        String decision = stupid.makeDecision();
        logger.info(decision);
        return decision;
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        translator = new JsonAcknowledger(response);
        translator.updateBattery(drone);
        translator.updateStatus(drone);
        //Technical debt: should check to see if the echo and scan calls are necessary, potentially
        //keeping track of past decisions.
        translator.echo();
        translator.scan();
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
