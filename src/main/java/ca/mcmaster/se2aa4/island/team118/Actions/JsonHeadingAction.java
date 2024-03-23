package ca.mcmaster.se2aa4.island.team118.ActionsTests;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class JsonHeadingAction implements HeadingAction{

    public String getString(Direction direction) {
        JSONObject heading = new JSONObject();
        heading.put("action","heading");
        heading.put("parameters", (new JSONObject()).put("direction", direction.toString()));
        return heading.toString();
    }

}
