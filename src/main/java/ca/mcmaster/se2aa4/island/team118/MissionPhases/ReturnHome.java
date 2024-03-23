package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.StopAction;

public class ReturnHome implements Phase {

    private StopAction stop;

    public ReturnHome(ActionFactory factory) {
        this.stop = factory.createStopAction();
    }

    /**
    Gets the current phase in string format

    @return string     the string representing the
                       phase
    */
    @Override
    public String getCurrentPhase() {
        return "ReturnHome";
    }

    /**
    Gets the next decision in the phase; stop.

    @return string     the string representing the
                       decision
    */
    @Override
    public String getNextDecision() {
        return stop.getString();
    }

}
