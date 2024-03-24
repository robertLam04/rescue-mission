package ca.mcmaster.se2aa4.island.team118;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.JsonActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.HeadingAction;
import ca.mcmaster.se2aa4.island.team118.Actions.JsonHeadingAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Queue;


class ManeuverTest {

    private final Logger logger = LogManager.getLogger();
    JsonActionFactory testFactory;
    @BeforeEach
    void setup(){
        this.testFactory = new JsonActionFactory();
    }
    @Test
    void uturnLeft() {
        logger.info("Starting uturnLeft test");
        Maneuver testManeuver = new Maneuver(testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.E;
        Queue<String> decisionsQueue = testManeuver.uturnLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        HeadingAction headingExpected = new JsonHeadingAction();
        assertEquals(headingExpected.getString(Direction.W),decision);
    }

    @Test
    void uturnRight() {
        logger.info("Starting uturnRight test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.uturnRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        HeadingAction headingExpected = new JsonHeadingAction();
        assertEquals(headingExpected.getString(Direction.S),decision);
    }

    @Test
    void sharpTurnRight() {
        logger.info("Starting sharpRightTurn test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.sharpTurnRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        HeadingAction headingExpected = new JsonHeadingAction();
        assertEquals(headingExpected.getString(Direction.E),decision);
    }

    @Test
    void sharpTurnLeft() {
        logger.info("Starting sharpTurnLeft test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.sharpTurnLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        HeadingAction headingExpected = new JsonHeadingAction();
        assertEquals(headingExpected.getString(Direction.W),decision);
    }

  @Test
    void shiftLeft() {
        logger.info("Starting shiftLeft test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.shiftLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
      HeadingAction headingExpected = new JsonHeadingAction();
      assertEquals(headingExpected.getString(Direction.N),decision);
    }

      @Test
    void shiftLeft2() {
        logger.info("Starting shiftLeft2  test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.shiftLeft2(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
          HeadingAction headingExpected = new JsonHeadingAction();
          assertEquals(headingExpected.getString(Direction.N),decision);
    }

    @Test
    void shiftRight() {
        logger.info("Starting shiftRight test");
        Maneuver testManeuver = new Maneuver(this.testFactory);
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<String> decisionsQueue = testManeuver.shiftRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        String decision = "";
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        HeadingAction headingExpected = new JsonHeadingAction();
        assertEquals(headingExpected.getString(Direction.N),decision);
    }

 @Test
    void shiftRight2() {
     logger.info("Starting shiftRight2 test");
     Maneuver testManeuver = new Maneuver(this.testFactory);
     //Initialize decision queue for testing
     Direction heading = Direction.N;
     Queue<String> decisionsQueue = testManeuver.shiftRight2(heading);
     //Go through decisions in queue to reach final state of Maneuver
     String decision = "";
     while(!decisionsQueue.isEmpty()){
         decision = decisionsQueue.remove();
     }
     //Test that the final state is in correct direction.
     HeadingAction headingExpected = new JsonHeadingAction();
     assertEquals(headingExpected.getString(Direction.N),decision);
    }
}