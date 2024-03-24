package ca.mcmaster.se2aa4.island.team118.ActionTests;

import ca.mcmaster.se2aa4.island.team118.Actions.JsonHeadingAction;
import ca.mcmaster.se2aa4.island.team118.Direction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class JsonHeadingActionTest {
    private final Logger logger = LogManager.getLogger();
    @Test
    void getString() {
        logger.info("Starting JsonHeadingActionTest");
        JsonHeadingAction testHeading = new JsonHeadingAction();
        String heading = testHeading.getString(Direction.E);
        //Test whether heading generates string with correct components
        assertTrue(heading.contains("action"));
        assertTrue(heading.contains("heading"));
        assertTrue(heading.contains("parameters"));
        assertTrue(heading.contains("direction"));
        assertTrue(heading.contains("E"));

    }
}