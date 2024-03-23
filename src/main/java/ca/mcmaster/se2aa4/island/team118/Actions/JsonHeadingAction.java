package ca.mcmaster.se2aa4.island.team118.Actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class JsonHeadingAction implements HeadingAction{

    /**
    Create a new JSONObject, put the keys and values
    to call a 'heading' action in the given direction

    @param  direction  the direction of the turn
    @return string     the string representing the
                       corresponding JSON Object
    */
    public String getString(Direction direction) {
        JSONObject heading = new JSONObject();
        heading.put("action","heading");
        heading.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return heading.toString();
    }

}
