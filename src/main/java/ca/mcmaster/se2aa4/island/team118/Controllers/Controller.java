package ca.mcmaster.se2aa4.island.team118.Controllers;

import org.json.JSONObject;

public interface Controller {

    public String makeDecision();
    
    public void acknowledge(JSONObject object);

    public String closestCreek();

} 
