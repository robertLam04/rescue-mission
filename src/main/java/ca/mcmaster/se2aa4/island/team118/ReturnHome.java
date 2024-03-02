package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONObject;

public class ReturnHome implements Phase {

    private Decision decision = new Decision();

    @Override
    public Phase NextPhase() {
        return new ReturnHome();
    }

    @Override
    public String getCurrentPhase() {
        return "ReturnHome";
    }

    @Override
    public JSONObject getNextDecision() {
        return decision.stop();
    }

    @Override
    public boolean isFinal() {
        return true;
    }
    
}
