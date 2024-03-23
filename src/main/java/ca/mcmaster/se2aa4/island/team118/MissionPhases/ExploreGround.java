package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;

public class ExploreGround implements Phase {

    private Queue<String> decisionQueue = new LinkedList<>();
    private FlyAction fly;
    private ScanAction scan;

    public ExploreGround(ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.scan = factory.createScanAction();
        this.decisionQueue = ExploreGroundQ();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "ExploreGround";
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
            decisionQueue = ExploreGroundQ();
        }
        
        return decisionQueue.remove();
    }

    /**
    Creates a queue of decisions representing the
    sequence of actions to be executed in the current phase.

    @return decisionQueue       the queue of decisions
    */
    private Queue<String> ExploreGroundQ() {
        decisionQueue.add(fly.getString());
        decisionQueue.add(scan.getString());

        return decisionQueue;
    }
    
}
