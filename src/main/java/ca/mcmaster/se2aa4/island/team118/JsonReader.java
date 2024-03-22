package ca.mcmaster.se2aa4.island.team118;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonReader implements Reader{

    private final Logger logger = LogManager.getLogger();
    private JSONObject json_response;
    private JSONObject previous_decision;
    private Integer cost;
    private JSONObject extraInfo;

    public JsonReader(String previous_decision, String response) {
        this.json_response = new JSONObject(new JSONTokener(new StringReader(response)));
        this.previous_decision = new JSONObject(new JSONTokener(new StringReader(previous_decision)));
        this.cost = json_response.getInt("cost");
        this.extraInfo = json_response.getJSONObject("extras");
    }

    public String getDecision() {
        return previous_decision.getString("action");
    }

    public boolean isGround() {
        if (extraInfo.has("biomes")) {
            JSONArray biomes = extraInfo.getJSONArray("biomes");
            if (biomes.length() == 1 && biomes.getString(0).equals("OCEAN")) {
                return false;
            }
        } else if (extraInfo.has("found")) {
            if (extraInfo.getString("found").equals("OUT_OF_RANGE"))
            //Create a tile range - 1 tiles away in the direction that is a border
            return false;
        }
        return true;
    }
    
    public List<String> getCreeks() {
        JSONArray creeks;
        if (extraInfo.has("creeks")) {
            creeks = extraInfo.getJSONArray("creeks");
        } else {
            return new ArrayList<>();
        }

        List<String> creekList = new ArrayList<>();
        
        for (int i = 0; i < creeks.length(); i++) {
            creekList.add(creeks.getString(i));
        }

        return creekList;
    }

    public List<String> getBiomes() {
        JSONArray biomes;
        if (extraInfo.has("biomes")) {
            biomes = extraInfo.getJSONArray("biomes");
        } else {
            return new ArrayList<>();
        }

        List<String> biomeList = new ArrayList<>();
        
        for (int i = 0; i < biomes.length(); i++) {
            biomeList.add(biomes.getString(i));
        }

        return biomeList;
    }

    public boolean isSite() {
        JSONArray site;
        if (extraInfo.has("sites")) {
            site = extraInfo.getJSONArray("sites");
        } else {
            return false;
        }
        return site.isEmpty();
    }

    public Direction getDirection() {
        JSONObject params = previous_decision.getJSONObject("parameters");
        String direction = params.getString("direction");
        return Direction.fromString(direction);
    }

    public Integer range(){
        if (extraInfo.has("found")){
            Integer range = extraInfo.getInt("range");
            logger.info(range);
            return range;
        }
        throw new IllegalStateException();
    }

    public Integer getCost() {
        //update battery
        return cost;
    }
}

