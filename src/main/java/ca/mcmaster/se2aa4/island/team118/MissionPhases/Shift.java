package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;

public class Shift implements Phase {

    private Queue<String> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver;
    private EchoAction echo;
    

    public Shift(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.echo = factory.createEchoAction();
        this.maneuver = new Maneuver(factory);
        this.decision_queue = ShiftQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "Shift";
    }

    /**
    Gets the next decision in the phase by popping
    from the queue of decisions. If the queue is empty,
    refill it.

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = ShiftQ();
        }
        return decision_queue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    public Queue<String> ShiftQ(){
        Queue<String> shiftQueue;
        if (isLeft){
            shiftQueue = maneuver.shiftLeft(drone.getHeading());
        } else {
            shiftQueue = maneuver.shiftRight(drone.getHeading());
        }
        while (!shiftQueue.isEmpty()){
            decision_queue.add(shiftQueue.remove());
        }
        decision_queue.add(echo.getString(drone.getHeading()));
        return decision_queue;

    }
}
