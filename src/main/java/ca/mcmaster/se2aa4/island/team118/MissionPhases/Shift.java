package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Decision;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;

public class Shift implements Phase {

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver = new Maneuver();

    public Shift(Drone drone, boolean isLeft) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.decision_queue = ShiftQ();
    }

    @Override
    public String getCurrentPhase() {
        return "Shift";
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = ShiftQ();
        }
        return decision_queue.remove();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    public Queue<JSONObject> ShiftQ(){
        Queue<JSONObject> shiftQueue;
        if (isLeft){
            shiftQueue = maneuver.shiftLeft(drone.getHeading());
        } else {
            shiftQueue = maneuver.shiftRight(drone.getHeading());
        }
        while (!shiftQueue.isEmpty()){
            decision_queue.add(shiftQueue.remove());
        }
        decision_queue.add(decision.echo(drone.getHeading()));
        return decision_queue;

    }
}
