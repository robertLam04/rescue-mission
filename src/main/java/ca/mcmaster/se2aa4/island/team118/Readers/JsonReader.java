package ca.mcmaster.se2aa4.island.team118.Readers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class JsonReader implements Reader{

    private final Logger logger = LogManager.getLogger();
    private JSONObject previousDecision;
    private Integer cost;
    private JSONObject extraInfo;

    public JsonReader(String previousDecision, String response) {
        JSONObject jsonResponse = new JSONObject(new JSONTokener(new StringReader(response)));
        this.previousDecision = new JSONObject(new JSONTokener(new StringReader(previousDecision)));
        this.cost = jsonResponse.getInt("cost");
        this.extraInfo = jsonResponse.getJSONObject("extras");
    }

    /**
    Gets the distinct last decision taken (eg. stop, echo, scan)
    from the JsonObject.

    @return string       (stop, echo, scan, heading, fly)
    */
    public String getDecision() {
        return previousDecision.getString("action");
    }

    /**
    Checks if the response JSONObject has biomes or if 
    it was an echo that found ground. If it has biomes it
    ensure that it isn't ocean.

    @return boolean     if its ground or not 
    */
    public boolean isGround() {
        if (extraInfo.has("biomes")) {
            JSONArray biomes = extraInfo.getJSONArray("biomes");
            if (biomes.length() == 1 && biomes.getString(0).equals("OCEAN")) {
                return false;
            }
        } else if (extraInfo.has("found")) {
            if (extraInfo.getString("found").equals("OUT_OF_RANGE")) {
                 //Create a tile range - 1 tiles away in the direction that is a border
            return false;
            }
        }
        return true;
    }
    
    /**
    Checks if the response contains creeks. Converts
    the JSONArray of creeks to a List<String>.

    @return List<String> of creek ID's
    */
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

    /**
    Checks if the response contains biomes. Converts
    the JSONArray of biomes to a List<String>.

    @return List<String> of biomes
    */
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

    /**
    Checks if the response contains a site. 

    @return boolean isSite
    */
    public boolean isSite() {
        JSONArray site;
        if (extraInfo.has("sites")) {
            site = extraInfo.getJSONArray("sites");
        } else {
            return false;
        }
        return !site.isEmpty();
    }

    /**
    Checks the direction of the 'parameters' key
    of the last taken decision. Ex. if last decision
    was echo North, it returns North.

    @return direction of last decision
    @throws IllegalStateException if last decision does not
                                  contain parameters
    */
    public Direction getDirection() {
        if (previousDecision.has("parameters")) {
            JSONObject params = previousDecision.getJSONObject("parameters");
            String direction = params.getString("direction");
            return Direction.fromString(direction);
        }
        throw new IllegalStateException();
    }

    /**
    Checks the range of the echo.

    @return direction of last decision
    @throws IllegalStateException if echo was not the 
                                  last decision.
    */
    public Integer getRange(){
        if (extraInfo.has("found")){
            Integer range = extraInfo.getInt("range");
            logger.info(range);
            return range;
        }
        throw new IllegalStateException();
    }

    /**
    @return cost of last decision
    */
    public Integer getCost() {
        return cost;
    }
}

