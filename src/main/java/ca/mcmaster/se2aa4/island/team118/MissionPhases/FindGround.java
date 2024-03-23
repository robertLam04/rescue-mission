package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.*;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;

import java.util.LinkedList;
import java.util.Queue;

public class FindGround implements Phase {

    private Queue<String> decisionQueue = new LinkedList<>();
    private Drone drone;
    private FlyAction fly;
    private EchoAction echo;

    public FindGround(Drone drone, ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.echo = factory.createEchoAction();
        this.drone = drone;
        this.decisionQueue = FindGroundQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "FindGround";
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
            decisionQueue = FindGroundQ();
        }
        
        return decisionQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    private Queue<String> FindGroundQ() {
        decisionQueue.add(echo.getString(drone.getHeading()));
        decisionQueue.add(echo.getString(drone.getHeading().left()));
        decisionQueue.add(echo.getString(drone.getHeading().right()));
        decisionQueue.add(fly.getString());
        decisionQueue.add(fly.getString());
        decisionQueue.add(fly.getString());
        decisionQueue.add(fly.getString());
    
        return decisionQueue;
    }

}
