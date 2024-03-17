package ca.mcmaster.se2aa4.island.team118.MissionPhases;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Decision;

public class EchoAfterExplore implements Phase {

    private Drone drone;
    private Decision decision = new Decision();

    public EchoAfterExplore(Drone drone){
        this.drone = drone;
    }
    
    @Override
    public String getCurrentPhase() {
        return "EchoAfterExplore";
    }

    @Override
    public JSONObject getNextDecision() {
        return decision.echo(drone.getDroneHeading());
    }

    @Override
    public boolean isFinal() {
        return false;
    }
    
}
