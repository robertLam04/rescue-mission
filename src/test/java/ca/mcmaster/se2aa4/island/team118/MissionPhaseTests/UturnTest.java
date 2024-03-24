package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Uturn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UturnTest {

    private Drone drone;
    private ActionFactory testfactory;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.drone = new Drone(3000, Direction.E);
        this.testfactory = new JsonFactory();
    }

    @Test
    void getCurrentPhase() {
        logger.info("Starting UTurn getCurrentPhase Test");
        Phase testTurn = new Uturn(this.drone,Boolean.TRUE,this.testfactory);
        assertEquals("Uturn", testTurn.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting UTurn getNextDecision Test");
        Phase testTurn = new Uturn(this.drone,Boolean.TRUE,this.testfactory);
        HeadingAction expectedHeading = new JsonHeadingAction();
        ScanAction expectedScan = new JsonScanAction();
        EchoAction expectedEcho = new JsonEchoAction();
        //Test for Left U-turn
        assertEquals(expectedHeading.getString(Direction.N),testTurn.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.W),testTurn.getNextDecision());
        assertEquals(expectedScan.getString(),testTurn.getNextDecision());
        assertEquals(expectedEcho.getString(Direction.W),testTurn.getNextDecision());
        //Test for Right U-turn
        testTurn = new Uturn(this.drone,Boolean.FALSE,this.testfactory);
        assertEquals(expectedHeading.getString(Direction.S),testTurn.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.W),testTurn.getNextDecision());
        assertEquals(expectedScan.getString(),testTurn.getNextDecision());
        assertEquals(expectedEcho.getString(Direction.W),testTurn.getNextDecision());
    }
}