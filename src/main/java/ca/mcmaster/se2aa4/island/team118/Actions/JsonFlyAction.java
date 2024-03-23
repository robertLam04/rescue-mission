package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

public class JsonFlyAction implements FlyAction{

    /**
    Create a new JSONObject, put the keys and values
    to call a 'fly' action

    @return string     the string representing the
                       corresponding JSON Object
    */
    public String getString() {
        JSONObject fly = new JSONObject();
        fly.put("action","fly");
        return fly.toString();
    }

}
