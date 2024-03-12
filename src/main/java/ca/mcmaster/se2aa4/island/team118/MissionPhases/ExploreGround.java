package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.*;

public class ExploreGround implements Phase {

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;

    public ExploreGround(Drone drone) {
        this.drone = drone;
        this.decision_queue = ExploreGroundQ();
    }

    public String getCurrentPhase() {
        return "ExploreGround";
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = ExploreGroundQ();
        }
        
        return decision_queue.remove();
    }

    private Queue<JSONObject> ExploreGroundQ() {
        decision_queue.add(decision.fly());
        decision_queue.add(decision.scan());


        return decision_queue;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
    
}
