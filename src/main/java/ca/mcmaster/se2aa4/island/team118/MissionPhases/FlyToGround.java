package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.HeadingAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;

import java.util.LinkedList;
import java.util.Queue;

public class FlyToGround implements Phase {

    private Drone drone;
    private int distance_to_ground;
    private Direction direction_to_ground;
    private ScanAction scan;
    private FlyAction fly;
    private HeadingAction heading;
    private Queue<String> flyQueue = new LinkedList<>();

    public FlyToGround(Drone drone, Direction direction_to_ground, int distance_to_ground, ActionFactory factory) {
        this.distance_to_ground = distance_to_ground;
        this.drone = drone;
        this.direction_to_ground = direction_to_ground;
        this.fly = factory.createFlyAction();
        this.scan = factory.createScanAction();
        this.heading = factory.createHeadingAction();
        this.flyQueue = flyQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "FlyToGround";
    }

    /**
    Gets the next decision in the phase by popping
    from the queue of decisions. If the drone is not
    facing ground, turn towards ground. If the queue 
    is empty return a 'scan'.

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {

        if (!drone.getHeading().equals(direction_to_ground)) {
            return heading.getString(direction_to_ground);
        }

        if (flyQueue.isEmpty()) {
            return scan.getString();
        }

        return flyQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    private Queue<String> flyQ() {
        for (int i = 0; i < distance_to_ground; i++) {
            flyQueue.add(fly.getString());
        }
        return flyQueue;
    }
    
}
