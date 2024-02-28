package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class MemoryController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public JSONObject previous_decision;

    public String makeDecision(){
        JSONObject decision = new JSONObject();
        decision.put("action", "stop");
        logger.info("** Decision: {}",decision.toString());
        previous_decision = decision;
        return decision.toString();
    }

    public void acknowledge(JSONObject response) {
        
    }

    public JSONObject previousDecision(){
        return previous_decision;
    }
}
