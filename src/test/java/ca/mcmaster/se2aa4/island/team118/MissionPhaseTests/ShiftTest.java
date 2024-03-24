package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Shift;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {
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
        logger.info("Starting Shift getCurrentPhase Test");
        Phase testShift = new Shift(this.drone,Boolean.TRUE,this.testfactory);
        assertEquals("Shift", testShift.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting UTurn getNextDecision Test");
        Phase testShift = new Shift(this.drone,Boolean.TRUE,this.testfactory);
        HeadingAction expectedHeading = new JsonHeadingAction();
        FlyAction expectedflight = new JsonFlyAction();
        //Test for Left Shift
        assertEquals(expectedHeading.getString(Direction.N), testShift.getNextDecision());
        assertEquals(expectedflight.getString(),testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.W), testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.S), testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.E), testShift.getNextDecision());
        //Test for Right Shift
        testShift = new Shift(this.drone,Boolean.FALSE,this.testfactory);
        assertEquals(expectedHeading.getString(Direction.S), testShift.getNextDecision());
        assertEquals(expectedflight.getString(),testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.W), testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.N), testShift.getNextDecision());
        assertEquals(expectedHeading.getString(Direction.E), testShift.getNextDecision());
    }

}