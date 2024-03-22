package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;

public class DoubleShift implements Phase {
    private Queue<String> decision_queue = new LinkedList<>();
    private EchoAction echo;
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver;

    public DoubleShift(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.echo = factory.createEchoAction();
        this.isLeft = isLeft;
        this.maneuver = new Maneuver(factory);
        this.decision_queue = DoubleShiftQ();
    }

    @Override
    public String getCurrentPhase() {
        return "DoubleShift";
    }

    @Override
    public String getNextDecision() {
        /*if (decision_queue.isEmpty()) {
            decision_queue = DoubleShiftQ();
        }*/
        return decision_queue.remove();
    }

    public Queue<String> DoubleShiftQ(){
        Queue<String> doubleShiftQueue; 
        if (isLeft){
            doubleShiftQueue = maneuver.shiftLeft2(drone.getHeading());
        } else {
            doubleShiftQueue = maneuver.shiftRight2(drone.getHeading());
        }
        while (!doubleShiftQueue.isEmpty()){
            decision_queue.add(doubleShiftQueue.remove());
        }
        decision_queue.add(echo.getString(drone.getHeading()));
        return decision_queue;

    }
}
