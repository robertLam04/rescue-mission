package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Decision;
import ca.mcmaster.se2aa4.island.team118.Drone;

public class Danger implements Phase{

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;

    public Danger(Drone drone) {
        this.drone = drone;
        this.decision_queue = dangerQ();
    }

    @Override
    public String getCurrentPhase() {
        return "Danger";
    }

    @Override
    public JSONObject getNextDecision() {
        
        return decision_queue.remove();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    private Queue<JSONObject> dangerQ() {
        decision_queue.add(decision.heading(drone.getDroneHeading().right()));
        //make getHeading.180
        decision_queue.add(decision.heading(drone.getDroneHeading().right().right()));
        decision_queue.add(decision.echo(drone.getDroneHeading().right().right()));


        return decision_queue;
    }
    
}
