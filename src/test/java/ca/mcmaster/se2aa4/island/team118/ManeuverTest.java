package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Queue;
/*
*

class ManeuverTest {

    private final Logger logger = LogManager.getLogger();
    @Test
    void uturnLeft() {
        logger.info("Starting uturnLeft test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.E;
        Queue<JSONObject> decisionsQueue = testManeuver.uturnLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.W.toString(),direction.get("direction"));
    }

    @Test
    void uturnRight() {
        logger.info("Starting uturnRight test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.uturnRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.S.toString(),direction.get("direction"));
    }

    @Test
    void sharpTurnRight() {
        logger.info("Starting sharpRightTurn test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.sharpTurnRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.E.toString(),direction.get("direction"));
    }

    @Test
    void sharpTurnLeft() {
        logger.info("Starting sharpTurnLeft test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.sharpTurnLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.W.toString(),direction.get("direction"));
    }

    @Test
    void shiftLeft() {
        logger.info("Starting shiftLeft test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.shiftLeft(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.N.toString(),direction.get("direction"));
    }

    @Test
    void shiftLeft2() {
        logger.info("Starting shiftLeft2  test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.shiftLeft2(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.N.toString(),direction.get("direction"));
    }

    @Test
    void shiftRight() {
        logger.info("Starting shiftRight test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.shiftRight(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.N.toString(),direction.get("direction"));
    }

    @Test
    void shiftRight2() {
        logger.info("Starting shiftRight2 test");
        Maneuver testManeuver = new Maneuver();
        //Initialize decision queue for testing
        Direction heading = Direction.N;
        Queue<JSONObject> decisionsQueue = testManeuver.shiftRight2(heading);
        //Go through decisions in queue to reach final state of Maneuver
        JSONObject decision = new JSONObject();
        while(!decisionsQueue.isEmpty()){
            decision = decisionsQueue.remove();
        }
        //Test that the final state is in correct direction.
        JSONObject direction = decision.getJSONObject("parameters");
        assertEquals(Direction.N.toString(),direction.get("direction"));
    }

   /* @Test

    void spiral() {
    }
}*/