package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;

public class Uturn implements Phase {

    private Queue<String> decisionQueue = new LinkedList<>();
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
        this.decisionQueue = UturnQ();
    }
    
    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "Uturn";
    }

    /**
    Gets the next decision in the phase by popping
    from the queue of decisions. If the queue is empty
    refill it.

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {
        if (decisionQueue.isEmpty()) {
            decisionQueue = UturnQ();
        }
        
        return decisionQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    public Queue<String> UturnQ(){
        Queue<String> uturnQueue;
        if (isLeft){
            uturnQueue = maneuver.uturnLeft(drone.getHeading());

        } else {
            uturnQueue = maneuver.uturnRight(drone.getHeading());
        }
        while (!uturnQueue.isEmpty()){
            decisionQueue.add(uturnQueue.remove());
        }
        decisionQueue.add(scan.getString());
        decisionQueue.add(echo.getString(drone.getHeading().right().right()));

        return decisionQueue;
    }
    
}
