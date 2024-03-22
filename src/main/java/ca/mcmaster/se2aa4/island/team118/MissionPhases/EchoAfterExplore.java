package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.Actions.EchoAction;

public class EchoAfterExplore implements Phase {

    private Drone drone;
    private EchoAction echo;

    public EchoAfterExplore(Drone drone, ActionFactory factory){
        this.drone = drone;
        this.echo = factory.createEchoAction();
    }
    
    @Override
    public String getCurrentPhase() {
        return "EchoAfterExplore";
    }

    @Override
    public String getNextDecision() {
        return echo.getString(drone.getHeading());
    }
    
}
