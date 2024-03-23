package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.*;
import ca.mcmaster.se2aa4.island.team118.Actions.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;

import java.util.LinkedList;
import java.util.Queue;

public class FindGround implements Phase {

    private Queue<String> decision_queue = new LinkedList<>();
    private Drone drone;
    private FlyAction fly;
    private EchoAction echo;

    public FindGround(Drone drone, ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.echo = factory.createEchoAction();
        this.drone = drone;
        this.decision_queue = FindGroundQ();
    }

    public String getCurrentPhase() {
        return "FindGround";
    }

    @Override
    public String getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = FindGroundQ();
        }
        
        return decision_queue.remove();
    }

    private Queue<String> FindGroundQ() {
        //DO THESE ACTIONS IN SEQUENCE UNTIL GROUND IS FOUND ON RADAR
        decision_queue.add(echo.getString(drone.getHeading()));
        decision_queue.add(echo.getString(drone.getHeading().left()));
        decision_queue.add(echo.getString(drone.getHeading().right()));
        decision_queue.add(fly.getString());
        decision_queue.add(fly.getString());
        decision_queue.add(fly.getString());
        decision_queue.add(fly.getString());
    
        return decision_queue;
    }

}
