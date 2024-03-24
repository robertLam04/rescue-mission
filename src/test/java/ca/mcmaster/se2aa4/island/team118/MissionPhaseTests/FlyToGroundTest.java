package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.HeadingAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonFlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonHeadingAction;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.FlyToGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyToGroundTest {
    private ActionFactory testfactory;
    private Drone drone;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.drone = new Drone(3000, Direction.E);
        this.testfactory = new JsonFactory();
    }

    @Test
    void getCurrentPhase() {
        logger.info("Starting FlyToGround getCurrentPhase Test");
        Phase testGround = new FlyToGround(this.drone,Direction.E,2,this.testfactory);
        assertEquals("FlyToGround", testGround.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting FlyToGround getNextDecision Test");
        Phase testGround = new FlyToGround(this.drone,Direction.E,2,this.testfactory);
        FlyAction expectedFlight = new JsonFlyAction();
        //Check decision order when drone is already in Ground direction
        assertEquals(expectedFlight.getString(), testGround.getNextDecision());
        assertEquals(expectedFlight.getString(), testGround.getNextDecision());
        //Check decision order when drone is faced away from ground
        testGround =  new FlyToGround(this.drone,Direction.N,2,this.testfactory);
        HeadingAction expectedHeading = new JsonHeadingAction();
        assertEquals(expectedHeading.getString(Direction.N), testGround.getNextDecision());
    }

}