package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonFlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonScanAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.ExploreGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExploreGroundTest {

    private ActionFactory testfactory;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.testfactory = new JsonFactory();
    }

    @Test
    void getCurrentPhase() {
        logger.info("Starting ExploreGround getCurrentPhase Test");
        Phase testGround = new ExploreGround(this.testfactory);
        assertEquals("ExploreGround", testGround.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting ExploreGround getNextDecision Test");
        Phase testGround = new ExploreGround(this.testfactory);
        FlyAction expectedFlight = new JsonFlyAction();
        ScanAction expectedScan = new JsonScanAction();
        //Ensure proper order of Phase decisions is maintained
        assertEquals(expectedFlight.getString(), testGround.getNextDecision());
        assertEquals(expectedScan.getString(),testGround.getNextDecision());
    }
}