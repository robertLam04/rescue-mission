package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;

public class FlyToUturn implements Phase {

    private Queue<String> decision_queue = new LinkedList<>();
    private Drone drone;
    private boolean isLeft;
    private EchoAction echo;
    private FlyAction fly;

    public FlyToUturn(Drone drone, boolean isLeft, ActionFactory factory) {
        this.drone = drone;
        this.isLeft = isLeft;
        this.fly = factory.createFlyAction();
        this.echo = factory.createEchoAction();
        this.decision_queue = FlyToUturnQ();
    }

    @Override
    public String getCurrentPhase() {
        return "FlyToUturn";
    }

    @Override
    public String getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = FlyToUturnQ();
        }
        
        return decision_queue.remove();
    }

    public Queue<String> FlyToUturnQ(){
        if (isLeft){
            decision_queue.add(echo.getString(drone.getHeading().left()));
            decision_queue.add(fly.getString());
        } else {
            decision_queue.add(echo.getString(drone.getHeading().right()));
            decision_queue.add(fly.getString());
        }
        return decision_queue;
    }
     
}
