package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONObject;
import java.util.Queue;
import java.util.LinkedList;   

public class Maneuver {

    Decision decisionMaker = new Decision();
    Queue<JSONObject> decisionQueue = new LinkedList<>();

    public Queue<JSONObject> uturnLeft(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        return decisionQueue;
    }

    public Queue<JSONObject> uturnRight(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        return decisionQueue;
    }

    public Queue<JSONObject> sharpTurnRight(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        return decisionQueue;
    }

    public Queue<JSONObject> sharpTurnLeft(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftLeft(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftLeft2(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right().right()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftRight(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }

    public Queue<JSONObject> shiftRight2(Direction droneHeading) {
        decisionQueue.add(decisionMaker.heading(droneHeading.left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.left().left()));
        decisionQueue.add(decisionMaker.heading(droneHeading.right()));
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.fly());
        decisionQueue.add(decisionMaker.heading(droneHeading));
        return decisionQueue;
    }
}


