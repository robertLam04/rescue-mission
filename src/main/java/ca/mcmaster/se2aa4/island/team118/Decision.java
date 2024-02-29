package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONObject;

public class Decision {

    public JSONObject fly() {
        JSONObject fly = new JSONObject();
        fly.put("action","fly");
        return fly;
    }

    public JSONObject stop() {
        JSONObject stop = new JSONObject();
        stop.put("action","stop");
        return stop;
    }

    public JSONObject echo(Direction direction) {
        JSONObject echo = new JSONObject();
        echo.put("action","heading");
        echo.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return echo;
    }

    public JSONObject scan() {
        JSONObject scan = new JSONObject();
        scan.put("action","scan");
        return scan;
    }

    public JSONObject heading(Direction direction) {
        JSONObject heading = new JSONObject();
        heading.put("action","echo");
        heading.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return heading;
    }

}