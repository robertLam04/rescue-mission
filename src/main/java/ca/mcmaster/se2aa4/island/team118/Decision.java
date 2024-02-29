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

    public JSONObject echo() {
        JSONObject echo = new JSONObject();
        echo.put("action","echo");
        return echo;
    }

    public JSONObject scan() {
        JSONObject scan = new JSONObject();
        scan.put("action","scan");
        return scan;
    }

    public JSONObject heading() {
        JSONObject heading = new JSONObject();
        heading.put("action","echo");
        return heading;
    }

}