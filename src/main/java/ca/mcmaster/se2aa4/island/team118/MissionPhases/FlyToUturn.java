package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;

public class FlyToUturn implements Phase {

    private Queue<String> decisionQueue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private EchoAction echo;
    private FlyAction fly;

    public FlyToUturn(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.fly = factory.createFlyAction();
        this.echo = factory.createEchoAction();
        this.decisionQueue = FlyToUturnQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "FlyToUturn";
    }

    /**
    Gets the next decision in the phase by popping
    from the queue of decisions. If the queue is
    empty, refill it.

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {
        if (decisionQueue.isEmpty()) {
            decisionQueue = FlyToUturnQ();
        }
        
        return decisionQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    public Queue<String> FlyToUturnQ(){
        if (isLeft){
            decisionQueue.add(echo.getString(drone.getHeading().left()));
            decisionQueue.add(fly.getString());
        } else {
            decisionQueue.add(echo.getString(drone.getHeading().right()));
            decisionQueue.add(fly.getString());
        }
        return decisionQueue;
    }
     
}
