package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.core.config.json.JsonConfiguration;
import org.json.JSONObject;

public interface Controller {

    public String makeDecision();
    
    public JSONObject previousDecision();
} 
