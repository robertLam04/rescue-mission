package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.*;

public class Danger implements Phase{

    private Queue<String> decision_queue = new LinkedList<>();
    private Drone drone;
    private HeadingAction heading;
    private EchoAction echo;

    public Danger(Drone drone, ActionFactory factory) {
        this.drone = drone;
        this.echo = factory.createEchoAction();
        this.heading = factory.createHeadingAction();
        this.decision_queue = dangerQ();
    }

    @Override
    public String getCurrentPhase() {
        return "Danger";
    }

    @Override
    public String getNextDecision() {
        return decision_queue.remove();
    }

    private Queue<String> dangerQ() {
        decision_queue.add(heading.getString(drone.getHeading().right()));
        decision_queue.add(heading.getString(drone.getHeading().right().right()));
        decision_queue.add(echo.getString(drone.getHeading().right().right()));

        return decision_queue;
    }
    
}
