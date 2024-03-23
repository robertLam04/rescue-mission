package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;

public class Uturn implements Phase {

    private Queue<String> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver;
    private ScanAction scan;
    private EchoAction echo;

    public Uturn(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.scan = factory.createScanAction();
        this.echo = factory.createEchoAction();
        this.maneuver = new Maneuver(factory);
        this.decision_queue = UturnQ();
    }
    
    @Override
    public String getCurrentPhase() {
        return "Uturn";
    }

    @Override
    public String getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = UturnQ();
        }
        
        return decision_queue.remove();
    }

    public Queue<String> UturnQ(){
        Queue<String> uturnQueue;
        if (isLeft){
            uturnQueue = maneuver.uturnLeft(drone.getHeading());

        } else {
            uturnQueue = maneuver.uturnRight(drone.getHeading());
        }
        while (!uturnQueue.isEmpty()){
            decision_queue.add(uturnQueue.remove());
        }
        decision_queue.add(scan.getString());
        decision_queue.add(echo.getString(drone.getHeading().right().right()));

        return decision_queue;
    }
    
}
