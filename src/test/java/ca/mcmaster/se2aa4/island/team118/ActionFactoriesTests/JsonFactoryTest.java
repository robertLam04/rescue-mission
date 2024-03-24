package ca.mcmaster.se2aa4.island.team118.ActionFactoriesTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.Direction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonActionFactoryTest {
    private final Logger logger = LogManager.getLogger();
    @Test
    void createFlyAction() {
        logger.info("Starting createFlyAction Test");
        JsonActionFactory testFactory = new JsonActionFactory();
        JsonFlyAction fly = new JsonFlyAction();
        assertEquals(fly.getString(),testFactory.createFlyAction().getString());
    }

    @Test
    void createHeadingAction() {
        logger.info("Starting createHeadingAction Test");
        JsonActionFactory testFactory = new JsonActionFactory();
        JsonHeadingAction action = new JsonHeadingAction();
        assertEquals(action.getString(Direction.E),testFactory.createHeadingAction().getString(Direction.E));
    }

    @Test
    void createScanAction() {
        logger.info("Starting createScanAction Test");
        JsonActionFactory testFactory = new JsonActionFactory();
        JsonScanAction action = new JsonScanAction();
        assertEquals(action.getString(),testFactory.createScanAction().getString());
    }

    @Test
    void createEchoAction() {
        logger.info("Starting createEchoAction Test");
        JsonActionFactory testFactory = new JsonActionFactory();
        JsonEchoAction action = new JsonEchoAction();
        assertEquals(action.getString(Direction.E),testFactory.createEchoAction().getString(Direction.E));
    }

    @Test
    void createStopAction() {
        logger.info("Starting createStopAction Test");
        JsonActionFactory testFactory = new JsonActionFactory();
        JsonStopAction action = new JsonStopAction();
        assertEquals(action.getString(),testFactory.createStopAction().getString());
    }
}