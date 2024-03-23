package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class JsonEchoAction implements EchoAction{
    
    /**
    Create a new JSONObject, put the keys and values
    to call an 'echo' action in the given direction

    @param  direction  the direction of the echo
    @return string     the string representing the
                       corresponding JSON Object
    */
    public String getString(Direction direction) {
        JSONObject echo = new JSONObject();
        echo.put("action","echo");
        echo.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return echo.toString();
    }

}
