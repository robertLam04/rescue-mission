package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonEchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonFlyAction;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.FindGround;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindGroundTest {
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
        logger.info("Starting FindGround getCurrentPhase Test");
        Phase testGround = new FindGround(this.drone,this.testfactory);
        assertEquals("FindGround",testGround.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting FindGround getNextDecision Test");
        Phase testGround = new FindGround(this.drone,this.testfactory);
        EchoAction expectedEcho = new JsonEchoAction();
        FlyAction expectedFlight = new JsonFlyAction();
        //Ensure the decision order for Phase is maintained
        assertEquals(expectedEcho.getString(Direction.E),testGround.getNextDecision());
        assertEquals(expectedEcho.getString(Direction.N),testGround.getNextDecision());
        assertEquals(expectedEcho.getString(Direction.S),testGround.getNextDecision());
        assertEquals(expectedFlight.getString(),testGround.getNextDecision());
    }

}