package ca.mcmaster.se2aa4.island.team118;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.HeadingAction;

import java.util.Queue;
import java.util.LinkedList;   

public class Maneuver {

    private FlyAction fly;
    private HeadingAction heading;

    public Maneuver(ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.heading = factory.createHeadingAction();
    }
    
    /**
    The following methods each define a complex 'maneuver'
    that can be executed by the drone. These maneuvers are
    just sequences of 'fly' and 'heading' calls in a specific
    order.
     
    @param direction of the drone at start of maneuver
    @return Queue<String> representing the sequence of 
            decisions needed to perfrom the maneuver
    */
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
}


