package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

public class JsonStopAction implements StopAction{

    /**
    Create a new JSONObject, put the keys and values
    to call an 'stop' action.

    @return string     the string representing the
                       corresponding JSON Object
    */
    public String getString() {
        JSONObject stop = new JSONObject();
        stop.put("action","stop");
        return stop.toString();
    }

}
