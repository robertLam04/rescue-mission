package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class StupidController implements Controller {
    private final Logger logger = LogManager.getLogger();
    public String makeDecision(Drone drone){
        JSONObject decision = new JSONObject();
        decision.put("action", "fly"); 
        logger.info("** Decision: {}",decision.toString());
        return decision.toString();
    }
}
