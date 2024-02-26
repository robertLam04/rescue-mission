package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class StupidController implements Controller {

    private final Logger logger = LogManager.getLogger();
    int counter = 1;


    public String makeDecision(){
        JSONObject decision = new JSONObject();
        if (counter == 1) {
            //decision.put( "action", "scan");
            //decision.put("action", "echo");
            //decision.put("parameters", (new JSONObject()).put("direction", "N"));
            decision.put("action", "heading");
            decision.put("parameters", (new JSONObject()).put("direction", "S"));
        } else {
            decision.put("action", "stop");
        }
        counter++;
        logger.info("** Decision: {}",decision.toString());
        return decision.toString();
    }

    public JSONObject previousDecision(){
        JSONObject decision = new JSONObject();
        if (counter == 2){
            decision.put("action", "heading");
            decision.put("parameters", (new JSONObject()).put("direction", "S")); 
        } else {
            decision.put("action", "stop");
        }
        return decision;
    }
}
