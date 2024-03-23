package ca.mcmaster.se2aa4.island.team118.ActionTests;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonScanAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonScanActionTest {

    private final Logger logger = LogManager.getLogger();
    @Test
    void getString() {
        logger.info("Starting JsonScanActionTest");
        JsonScanAction testScan = new JsonScanAction();
        String scan= testScan.getString();
        //Test whether heading generates string with correct components
        assertTrue(scan.contains("action"));
        assertTrue(scan.contains("scan"));
    }
}