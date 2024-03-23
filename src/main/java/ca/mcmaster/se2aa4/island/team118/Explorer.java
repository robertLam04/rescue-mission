package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;

import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team118.Acknowledgers.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Controllers.Controller;
import ca.mcmaster.se2aa4.island.team118.Controllers.GridSearchController;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    Controller midController;
    Acknowledger acknowledger;
    Drone drone;
    GameMap map;
    ActionFactory factory;
    String previous_decision;
    Reader json_reader;

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

        factory = new JsonFactory();
        drone = new Drone(batteryLevel, initial_heading);
        midController = new GridSearchController(drone, factory);
        map = new GameMap();

    }

    @Override
    public String takeDecision() {
        previous_decision = midController.makeDecision();
        return previous_decision;
    }

    @Override
    public void acknowledgeResults(String s) {
        json_reader = new JsonReader(previous_decision, s);
        switch (json_reader.getDecision()) {
            case "fly":
                acknowledger = new FlyAcknowledger(drone, json_reader);
                break;
            case "heading": 
                acknowledger = new HeadingAcknowledger(drone, json_reader);
                break;
            case "echo":
                acknowledger = new EchoAcknowledger(drone, map, json_reader);
                break;
            case "scan":
                acknowledger = new ScanAcknowledger(drone, map, json_reader);
                break;
            case "stop":
                break;
            default:
                throw new IllegalArgumentException();
        }
        acknowledger.acknowledgeResults();
        midController.processDecision(json_reader);
    }

    @Override
    public String deliverFinalReport() {
        return map.closestCreek();
    }

}
