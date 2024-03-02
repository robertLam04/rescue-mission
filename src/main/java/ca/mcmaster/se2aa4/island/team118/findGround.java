package ca.mcmaster.se2aa4.island.team118;

import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;

public class findGround implements Phase {

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;

    public findGround(Drone drone) {
        this.drone = drone;
        this.decision_queue = FindGroundQ();
    }

    public String getCurrentPhase() {
        return "FindGround";
    }

    @Override
    public Phase NextPhase() {
        return new ReturnHome();
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = FindGroundQ();
        }
        
        return decision_queue.remove();
    }

    private Queue<JSONObject> FindGroundQ() {
        //DO THESE ACTIONS IN SEQUENCE UNTIL GROUND IS FOUND ON RADAR
        decision_queue.add(decision.echo(drone.getDroneHeading()));
        decision_queue.add(decision.echo(drone.getDroneHeading().left()));
        decision_queue.add(decision.echo(drone.getDroneHeading().right()));
        decision_queue.add(decision.fly());
        decision_queue.add(decision.fly());
        decision_queue.add(decision.fly());
        decision_queue.add(decision.fly());
    
        return decision_queue;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
    
}
