package ca.mcmaster.se2aa4.island.team118.ActionTests;

import ca.mcmaster.se2aa4.island.team118.Actions.JsonFlyAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonFlyActionTest {

    private final Logger logger = LogManager.getLogger();
    @Test
    void getString() {
        logger.info("Starting JsonFlyActionTest");
        JsonFlyAction testFly = new JsonFlyAction();
        String heading = testFly.getString();
        //Test whether heading generates string with correct components
        assertTrue(heading.contains("action"));
        assertTrue(heading.contains("fly"));
    }
}