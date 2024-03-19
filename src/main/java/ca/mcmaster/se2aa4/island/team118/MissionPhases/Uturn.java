package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Decision;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;

public class Uturn implements Phase {

    private Decision decision = new Decision();
    private Queue<JSONObject> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver = new Maneuver();

    public Uturn(Drone drone, boolean isLeft) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.decision_queue = UturnQ();
    }
    
    @Override
    public String getCurrentPhase() {
        return "Uturn";
    }

    @Override
    public JSONObject getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = UturnQ();
        }
        
        return decision_queue.remove();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    public Queue<JSONObject> UturnQ(){
        Queue<JSONObject> uturnQueue;
        if (isLeft){
            uturnQueue = maneuver.uturnLeft(drone.getHeading());

        } else {
            uturnQueue = maneuver.uturnRight(drone.getHeading());
        }
        while (!uturnQueue.isEmpty()){
            decision_queue.add(uturnQueue.remove());
        }
        decision_queue.add(decision.scan());
        decision_queue.add(decision.echo(drone.getHeading().right().right()));

        return decision_queue;
    }
    
}
