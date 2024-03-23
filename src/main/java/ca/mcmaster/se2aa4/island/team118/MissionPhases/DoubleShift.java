package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Maneuver;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;

public class DoubleShift implements Phase {
    private Queue<String> decisionQueue = new LinkedList<>();
    private EchoAction echo;
    private Drone drone;
    private boolean isLeft;
    private Maneuver maneuver;

    public DoubleShift(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.echo = factory.createEchoAction();
        this.isLeft = isLeft;
        this.maneuver = new Maneuver(factory);
        this.decisionQueue = DoubleShiftQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "DoubleShift";
    }

    /**
    Gets the next decision in the phase by popping
    from the queue of decisions

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {
        return decisionQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    public Queue<String> DoubleShiftQ(){
        Queue<String> doubleShiftQueue; 
        if (isLeft){
            doubleShiftQueue = maneuver.shiftLeft2(drone.getHeading());
        } else {
            doubleShiftQueue = maneuver.shiftRight2(drone.getHeading());
        }
        while (!doubleShiftQueue.isEmpty()){
            decisionQueue.add(doubleShiftQueue.remove());
        }
        decisionQueue.add(echo.getString(drone.getHeading()));
        return decisionQueue;

    }
}
