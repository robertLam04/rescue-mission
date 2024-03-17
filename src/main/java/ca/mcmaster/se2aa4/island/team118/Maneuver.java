package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import java.util.Queue;
import java.util.LinkedList;   

public class Maneuver {

    private final Logger logger = LogManager.getLogger();
    Decision decisionMaker = new Decision();

    public Queue<JSONObject> uturnLeft(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        return decisionQueue;
    }

    public Queue<JSONObject> uturnRight(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        return decisionQueue;
    }

    public Queue<JSONObject> sharpTurnRight(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        return decisionQueue;
    }

    public Queue<JSONObject> sharpTurnLeft(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftLeft(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftLeft2(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftRight(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftRight2(Direction droneHeading) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    //Spiral size contols the 'step' of the spiral
    public Queue<JSONObject> spiral(Direction droneHeading, int spiral_size) {
        Queue<JSONObject> decisionQueue = new LinkedList<>();
        logger.info("WTF");
        Queue<JSONObject> sharpRight = sharpTurnRight(droneHeading);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < spiral_size; j++) {
                decisionQueue.add(decisionMaker.fly());
            }
            while (!sharpRight.isEmpty()) {
                JSONObject decision = sharpRight.remove();
                decisionQueue.add(decision);
            }
            sharpRight = sharpTurnRight(droneHeading);
        }
    
        return decisionQueue;
    }

}


