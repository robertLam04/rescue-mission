package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.*;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;

public class FlyToGround implements Phase {

    private Drone drone;
    private int distance_to_ground;
    private Direction direction_to_ground;
    private Decision decision = new Decision();
    private Queue<JSONObject> fly_queue = new LinkedList<>();

    public FlyToGround(Drone drone, Direction direction_to_ground, int distance_to_ground) {
        this.distance_to_ground = distance_to_ground;
        this.drone = drone;
        this.direction_to_ground = direction_to_ground;
        this.fly_queue = flyQ();
    }

    @Override
    public String getCurrentPhase() {
        return "FlyToGround";
    }

    //Change so it just turns towards ground (EASY FIX JUST PUT direction_to_ground to turn)
    @Override
    public JSONObject getNextDecision() {
        //If drone is not facing ground turn right
        if (!drone.getHeading().equals(direction_to_ground)) {
            return decision.heading(drone.getHeading().right());
        }
        //If queue is empty scan
        if (fly_queue.isEmpty()) {
            return decision.scan();
        }
        return fly_queue.remove();
    }

    private Queue<JSONObject> flyQ() {
        for (int i = 0; i < distance_to_ground; i++) {
            fly_queue.add(decision.fly());
        }
        return fly_queue;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
    
    
}
