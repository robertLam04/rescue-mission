package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Decision;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;

public class DoubleShift implements Phase {
    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver = new Maneuver();

    public DoubleShift(Drone drone, boolean isLeft) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.decision_queue = DoubleShiftQ();
    }

    @Override
    public String getCurrentPhase() {
        return "DoubleShift";
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = DoubleShiftQ();
        }
        return decision_queue.remove();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    public Queue<JSONObject> DoubleShiftQ(){
        Queue<JSONObject> doubleShiftQueue; 
        if (isLeft){
            doubleShiftQueue = maneuver.shiftLeft2(drone.getHeading());
        } else {
            doubleShiftQueue = maneuver.shiftRight2(drone.getHeading());
        }
        while (!doubleShiftQueue.isEmpty()){
            decision_queue.add(doubleShiftQueue.remove());
        }
        decision_queue.add(decision.echo(drone.getHeading()));
        return decision_queue;

    }
}
