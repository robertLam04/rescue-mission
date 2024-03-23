package ca.mcmaster.se2aa4.island.team118.ActionTests;

import ca.mcmaster.se2aa4.island.team118.Actions.JsonStopAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonStopActionTest {

    private final Logger logger = LogManager.getLogger();
    @Test
    void getString() {
        logger.info("Starting JsonStopActionTest");
        JsonStopAction testStop = new JsonStopAction();
        String stop = testStop.getString();
        //Test whether heading generates string with correct components
        assertTrue(stop.contains("action"));
        assertTrue(stop.contains("stop"));
    }
}