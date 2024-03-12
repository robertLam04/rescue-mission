package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;

import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team118.Controllers.Controller;
import ca.mcmaster.se2aa4.island.team118.Controllers.MidController;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    Controller midController;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading").toLowerCase();
        Integer batteryLevel = info.getInt("budget");
        Direction initial_heading = Direction.fromString(direction);

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        midController = new MidController(batteryLevel, initial_heading);

    }

    @Override
    public String takeDecision() {
        String decision = midController.makeDecision();
        return decision;
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s))); 
        midController.acknowledge(response);
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
