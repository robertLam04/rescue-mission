package ca.mcmaster.se2aa4.island.team118.ActionFactoriesTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.Direction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonFactoryTest {
    private final Logger logger = LogManager.getLogger();
    @Test
    void createFlyAction() {
        logger.info("Starting createFlyAction Test");
        JsonFactory testFactory = new JsonFactory();
        JsonFlyAction fly = new JsonFlyAction();
        assertEquals(fly.getString(),testFactory.createFlyAction().getString());
    }

    @Test
    void createHeadingAction() {
        logger.info("Starting createHeadingAction Test");
        JsonFactory testFactory = new JsonFactory();
        JsonHeadingAction action = new JsonHeadingAction();
        assertEquals(action.getString(Direction.E),testFactory.createHeadingAction().getString(Direction.E));
    }

    @Test
    void createScanAction() {
        logger.info("Starting createScanAction Test");
        JsonFactory testFactory = new JsonFactory();
        JsonScanAction action = new JsonScanAction();
        assertEquals(action.getString(),testFactory.createScanAction().getString());
    }

    @Test
    void createEchoAction() {
        logger.info("Starting createEchoAction Test");
        JsonFactory testFactory = new JsonFactory();
        JsonEchoAction action = new JsonEchoAction();
        assertEquals(action.getString(Direction.E),testFactory.createEchoAction().getString(Direction.E));
    }

    @Test
    void createStopAction() {
        logger.info("Starting createStopAction Test");
        JsonFactory testFactory = new JsonFactory();
        JsonStopAction action = new JsonStopAction();
        assertEquals(action.getString(),testFactory.createStopAction().getString());
    }
}