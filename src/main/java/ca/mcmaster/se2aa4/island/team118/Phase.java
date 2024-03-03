package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONObject;

public interface Phase {

    public String getCurrentPhase();

    public JSONObject getNextDecision();

    public boolean isFinal();

}
