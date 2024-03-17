package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Decision;
import ca.mcmaster.se2aa4.island.team118.Drone;

public class FlyToUturn implements Phase {

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;

    public FlyToUturn(Drone drone, boolean isLeft) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.decision_queue = FlyToUturnQ();
    }

    @Override
    public String getCurrentPhase() {
        return "FlyToUturn";
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = FlyToUturnQ();
        }
        
        return decision_queue.remove();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    public Queue<JSONObject> FlyToUturnQ(){
        if (isLeft){
            decision_queue.add(decision.echo(drone.getDroneHeading().left()));
            decision_queue.add(decision.fly());
        }else {
            decision_queue.add(decision.echo(drone.getDroneHeading().right()));
            decision_queue.add(decision.fly());
        }
        return decision_queue;
    }
     
}
