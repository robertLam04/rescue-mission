package ca.mcmaster.se2aa4.island.team118.ActionsTests;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class JsonEchoAction implements EchoAction{

    public String getString(Direction direction) {
        JSONObject echo = new JSONObject();
        echo.put("action","echo");
        echo.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return echo.toString();
    }

}
