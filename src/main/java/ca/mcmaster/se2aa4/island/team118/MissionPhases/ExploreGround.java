package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import java.util.LinkedList;
import java.util.Queue;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.FlyAction;
import ca.mcmaster.se2aa4.island.team118.Actions.ScanAction;

public class ExploreGround implements Phase {

    private Queue<String> decision_queue = new LinkedList<>();
    private FlyAction fly;
    private ScanAction scan;

    public ExploreGround(ActionFactory factory) {
        this.fly = factory.createFlyAction();
        this.scan = factory.createScanAction();
        this.decision_queue = ExploreGroundQ();
    }

    public String getCurrentPhase() {
        return "ExploreGround";
    }

    @Override
    public String getNextDecision() {
        if (decision_queue.isEmpty()) {
            decision_queue = ExploreGroundQ();
        }
        
        return decision_queue.remove();
    }

    private Queue<String> ExploreGroundQ() {
        decision_queue.add(fly.getString());
        decision_queue.add(scan.getString());

        return decision_queue;
    }
    
}
