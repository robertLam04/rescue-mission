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
    private Queue<String> fly_queue = new LinkedList<>();

    public FlyToGround(Drone drone, Direction direction_to_ground, int distance_to_ground, ActionFactory factory) {
        this.distance_to_ground = distance_to_ground;
        this.drone = drone;
        this.direction_to_ground = direction_to_ground;
        this.fly = factory.createFlyAction();
        this.scan = factory.createScanAction();
        this.heading = factory.createHeadingAction();
        this.fly_queue = flyQ();
    }

    @Override
    public String getCurrentPhase() {
        return "FlyToGround";
    }

    //Change so it just turns towards ground (EASY FIX JUST PUT direction_to_ground to turn)
    @Override
    public String getNextDecision() {
        /* //If drone is not facing ground turn right
        if (!drone.getHeading().equals(direction_to_ground)) {
            return decision.heading(drone.getHeading().right());
        }*/

        //if drone is not facing ground turn towards it
        if (!drone.getHeading().equals(direction_to_ground)) {
            return heading.getString(direction_to_ground);
        }
        
        //If queue is empty scan
        if (fly_queue.isEmpty()) {
            return scan.getString();
        }

        return fly_queue.remove();
    }

    private Queue<String> flyQ() {
        for (int i = 0; i < distance_to_ground; i++) {
            fly_queue.add(fly.getString());
        }
        return fly_queue;
    }
    
}
