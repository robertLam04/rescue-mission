package ca.mcmaster.se2aa4.island.team118.ActionsTests;

import org.json.JSONObject;

public class JsonFlyAction implements FlyAction{

    public String getString() {
        JSONObject fly = new JSONObject();
        fly.put("action","fly");
        return fly.toString();
    }

}
