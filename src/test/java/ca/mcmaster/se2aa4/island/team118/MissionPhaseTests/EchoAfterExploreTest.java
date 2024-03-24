package ca.mcmaster.se2aa4.island.team118.MissionPhaseTests;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonEchoAction;
import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.EchoAfterExplore;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoAfterExploreTest {
    private Drone drone;
    private ActionFactory testfactory;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.drone = new Drone(3000, Direction.E);
        this.testfactory = new JsonActionFactory();
    }

    @Test
    void getCurrentPhase() {
        logger.info("Starting EchoAfterExplore  getCurrentPhase Test");
        Phase testEcho = new EchoAfterExplore(this.drone,this.testfactory);
        assertEquals("EchoAfterExplore", testEcho.getCurrentPhase());
    }

    @Test
    void getNextDecision() {
        logger.info("Starting EchoAfterExplore getNextDecision Test");
        Phase testEcho = new EchoAfterExplore(this.drone,this.testfactory);
        //Confirm the echo direction is correct for next decision
        EchoAction expectedEcho = new JsonEchoAction();
        assertEquals(expectedEcho.getString(Direction.E),testEcho.getNextDecision());
    }

}