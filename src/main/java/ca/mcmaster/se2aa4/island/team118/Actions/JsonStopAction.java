package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

public class JsonStopAction implements StopAction{

    public String getString() {
        JSONObject stop = new JSONObject();
        stop.put("action","stop");
        return stop.toString();
    }

}
