package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.HeadingAction;

import java.util.Queue;
import java.util.LinkedList;   

public class Maneuver {

    private final Logger logger = LogManager.getLogger();
    private FlyAction fly;
    private HeadingAction heading;

    public Maneuver(ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.heading = factory.createHeadingAction();
    }
    
    public Queue<String> uturnLeft(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(heading.getString(droneHeading.left().left()));
        return decisionQueue;
    }

    public Queue<String> uturnRight(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(heading.getString(droneHeading.right().right()));
        return decisionQueue;
    }

    public Queue<String> sharpTurnRight(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading));
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(heading.getString(droneHeading.right().right()));
        decisionQueue.add(heading.getString(droneHeading.right()));
        return decisionQueue;
    }

    public Queue<String> sharpTurnLeft(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading));
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(heading.getString(droneHeading.left().left()));
        decisionQueue.add(heading.getString(droneHeading.left()));
        return decisionQueue;
    }

    public Queue<String> shiftLeft(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading.left().left()));
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(heading.getString(droneHeading));
        return decisionQueue;
    }

    public Queue<String> shiftLeft2(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading.left().left()));
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(heading.getString(droneHeading));
        return decisionQueue;
    }

    public Queue<String> shiftRight(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading.right().right()));
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(heading.getString(droneHeading));
        return decisionQueue;
    }

    public Queue<String> shiftRight2(Direction droneHeading) {
        Queue<String> decisionQueue = new LinkedList<>();
        decisionQueue.add(heading.getString(droneHeading.right()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(fly.getString());
        decisionQueue.add(heading.getString(droneHeading.right().right()));
        decisionQueue.add(heading.getString(droneHeading.left()));
        decisionQueue.add(heading.getString(droneHeading));
        return decisionQueue;
    }

    //Spiral size contols the 'step' of the spiral
    public Queue<String> spiral(Direction droneHeading, int spiral_size) {
        Queue<String> decisionQueue = new LinkedList<>();
        logger.info("WTF");
        Queue<String> sharpRight = sharpTurnRight(droneHeading);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < spiral_size; j++) {
                decisionQueue.add(fly.getString());
            }
            while (!sharpRight.isEmpty()) {
                String decision = sharpRight.remove();
                decisionQueue.add(decision);
            }
            sharpRight = sharpTurnRight(droneHeading);
        }
        return decisionQueue;
    }

}


