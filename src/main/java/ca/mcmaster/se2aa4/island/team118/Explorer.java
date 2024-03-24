package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;

import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team118.Acknowledgers.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonActionFactory;
import ca.mcmaster.se2aa4.island.team118.Controllers.Controller;
import ca.mcmaster.se2aa4.island.team118.Controllers.GridSearchController;
import ca.mcmaster.se2aa4.island.team118.Readers.JsonReader;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private Controller controller;
    private String previousDecision;
    private Drone drone;
    private GameMap map;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading").toLowerCase();
        Integer batteryLevel = info.getInt("budget");
        Direction initialHeading = Direction.fromString(direction);

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);

        ActionFactory factory = new JsonActionFactory();
        drone = new Drone(batteryLevel, initialHeading);
        controller = new GridSearchController(drone, factory);
        map = new GameMap();

    }

    @Override
    public String takeDecision() {
        previousDecision = controller.makeDecision();
        return previousDecision;
    }

    @Override
    public void acknowledgeResults(String s) {
        Acknowledger acknowledger;
        Reader jsonReader = new JsonReader(previousDecision, s);
        switch (jsonReader.getDecision()) {
            case "fly":
                acknowledger = new FlyAcknowledger(drone);
                break;
            case "heading": 
                acknowledger = new HeadingAcknowledger(drone);
                break;
            case "echo":
                acknowledger = new EchoAcknowledger(drone, map);
                break;
            case "scan":
                acknowledger = new ScanAcknowledger(drone, map);
                break;
            case "stop":
                acknowledger = new StopAcknowledger();
                break;
            default:
                throw new IllegalArgumentException();
        }
        acknowledger.acknowledgeResults(jsonReader);
        controller.updatePhase(jsonReader);
    }

    @Override
    public String deliverFinalReport() {
        return map.closestCreek();
    }

}
