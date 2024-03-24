package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonStopAction;
import ca.mcmaster.se2aa4.island.team118.Actions.StopAction;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.ReturnHome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReturnHomeTest {
    private ActionFactory testfactory;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.testfactory = new JsonFactory();
    }

    @Test
    void getCurrentPhase() {
        logger.info("Starting ReturnHome getCurrentPhase Test");
        Phase testHome = new ReturnHome(this.testfactory);
        assertEquals("ReturnHome", testHome.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting ReturnHome getNextDecision Test");
        Phase testHome = new ReturnHome(this.testfactory);
        StopAction expectedStop = new JsonStopAction();
        //Ensure next decision is to return home
        assertEquals(expectedStop.getString(), testHome.getNextDecision());
    }

}