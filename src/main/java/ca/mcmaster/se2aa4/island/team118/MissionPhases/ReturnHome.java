package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.StopAction;

public class ReturnHome implements Phase {

    private StopAction stop;

    public ReturnHome(ActionFactory factory) {
        this.stop = factory.createStopAction();
    }

    @Override
    public String getCurrentPhase() {
        return "ReturnHome";
    }

    @Override
    public String getNextDecision() {
        return stop.getString();
    }

}
