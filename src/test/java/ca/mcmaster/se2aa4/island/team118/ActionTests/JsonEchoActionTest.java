package ca.mcmaster.se2aa4.island.team118.ActionTests;

import ca.mcmaster.se2aa4.island.team118.Actions.JsonEchoAction;
import ca.mcmaster.se2aa4.island.team118.Direction;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonEchoActionTest {
    private final Logger logger = LogManager.getLogger();
    @Test
    void getString() {
        logger.info("Starting JsonEchoActionTest");
        JsonEchoAction testEcho = new JsonEchoAction();
        String heading = testEcho.getString(Direction.E);
        //Test whether heading generates string with correct components
        assertTrue(heading.contains("action"));
        assertTrue(heading.contains("echo"));
        assertTrue(heading.contains("parameters"));
        assertTrue(heading.contains("direction"));
        assertTrue(heading.contains("E"));
    }
}