package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonReader implements Reader{

    private final Logger logger = LogManager.getLogger();
    private JSONObject response;
    private Integer cost;
    private String status;
    private JSONObject extraInfo;

    public JsonReader(JSONObject response) {
        this.response = response;
        this.cost = response.getInt("cost");
        this.extraInfo = response.getJSONObject("extras");
        this.status = response.getString("status");
        logger.info("** Response received:\n"+response.toString(2));
        logger.info("The cost of the action was {}", cost);
        logger.info("The status of the drone is {}", status);
        logger.info("Additional information received: {}", extraInfo);
    }

    public void updateBattery(Drone drone) {
        //update battery
        drone.updateBattery(cost);
    }

    public void updateStatus(Drone drone) {
        //record MIA status
        if (status == "MIA") {
            drone.updateStatus(Condition.MIA);
        }
    }

    public Tile echo() {
        //record radars
        if (extraInfo.has("found")) {
            Tile tile = new Tile();
            if ("OUT_OF_RANGE".equals(extraInfo.getString("found"))) {
                //Create a tile range - 1 tiles away in the direction that is a border
                tile.addIsBorder(true);
                return tile;
            } else if (extraInfo.getString("found") == "GROUND")  { 
                //Create a tile range tiles away in the direction that is ground
                tile.addIsGround(true);
            }
            return tile;
        } 
        throw new IllegalStateException();
    }
    
    public Tile scan() {
        //record scanning (technical debt: how are we going to know if we are scanning while on a border)
        JSONArray site = extraInfo.getJSONArray("sites");
        JSONArray creek = extraInfo.getJSONArray("creeks");
        JSONArray biomes = extraInfo.getJSONArray("biomes");

        logger.info(site.length());
        
        Tile tile = new Tile();
        tile.addIsSite(!(site.isEmpty()));
        tile.addIsCreek(!(creek.isEmpty()));
        tile.addbiomes(biomes);
        return tile;   
    }

    public Integer range(){
        if (extraInfo.has("found")){
            Integer range = extraInfo.getInt("range");
            logger.info(range);
            return range;
        }
        throw new IllegalStateException();
    }
}

