package ca.mcmaster.se2aa4.island.team118;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameMap {

    private final Logger logger = LogManager.getLogger();
    private Map<Position, Tile> tileMap;
  
    public GameMap() {
        this.tileMap = new HashMap<>();
    }

    /**
    @return the tile at position pos
    @throws IllegalAccessError if the key
            position is not in the map
    */
    public Tile getTile(Position pos) {
        
        if (tileMap.containsKey(pos)) {
            return tileMap.get(pos);
        }
        throw new IllegalAccessError();
    }

    /**
    Place the tile at the position, unless the
    position already has a tile.

    @param position of the tile
    @param tile to be placed
    
    */
    public void putTile(Position position, Tile tile) {
        if (tileMap.containsKey(position)) {
            return;
        }
        tileMap.put(position, tile);
    }

    /**
    Iterates over all elements of the map
    @return position of the emergency site
    @throws NoSuchElementException if the emergency site
            is not in the map
    */
    public Position sitePosition() {
        for (Map.Entry<Position, Tile> entry : tileMap.entrySet()) {
            Position position = entry.getKey();
            Tile tile = entry.getValue();
            if (tile.isSite()) { 
                return position;
            }
        }
        throw new NoSuchElementException("Emergency site not found");
    }

    /**
    Iterates over all elements of the map
    @return Map<Position, String> of creek positions
            and creek ID's. Empty map if none are found
    */
    public Map<Position, String> creekPositions() {
        Map<Position, String> creeksMap = new HashMap<>();
        for (Map.Entry<Position, Tile> entry : tileMap.entrySet()) {
            Position position = entry.getKey();
            Tile tile = entry.getValue();
            if (tile.isCreek()) {
                for (int i = 0; i < tile.getCreeks().size(); i++) {
                    creeksMap.put(position, tile.getCreeks().get(i));
                }
            }
        }
        return creeksMap;
    }

    /**
    Iterates over all creeks in the creek sub map obtained from 
    calling creekPositions(). Calculates the creek that is closest to
    the emergency site. 
    @return creek ID of the closest creek. If the
            emergency is not found, it returns a random
            creek ID from the list of creeks. If no creeks
            are found it returns "No creeks found"
    */
    public String closestCreek() {
    try {
        Map<Position, String> creeksMap = this.creekPositions();
        Position sitePosition = this.sitePosition();
        double closestDistance = Double.MAX_VALUE;
        String closestCreek = "";
        if (creeksMap.isEmpty()) {
            return "No creeks found";
        } else {
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position creekPosition = entry.getKey();
                String creekId = entry.getValue();
                double currentDistance = sitePosition.distanceFrom(creekPosition);
                if (currentDistance < closestDistance) {
                    closestDistance = currentDistance;
                    closestCreek = creekId;
                }
            }
        }
        logger.info("Closest creek: " + closestCreek);
        return closestCreek;
        } catch (NoSuchElementException e) {
            String randomCreek = getRandomCreekId();
            logger.info(randomCreek);
            return randomCreek;
        }
    }

    private String getRandomCreekId() {
        Map<Position, String> creeksMap = this.creekPositions();
        List<String> creekIds = new ArrayList<>(creeksMap.values());
        Random random = new Random();
        if (creeksMap.isEmpty()) {return "No creeks found";}
        return creekIds.get(random.nextInt(creekIds.size()));
    }

    //Helper for debugging
    public void printMap() {
        for (Map.Entry<Position, Tile> entry : tileMap.entrySet()) {
            Position position = entry.getKey();
            Tile tile = entry.getValue();
            logger.info("Position: " + position.toString() + ", Tile: " + tile.toString());
        }
    }

    //Helper for debugging
    public void printPOIS() {
        try {
            Map<Position, String> creeksMap = this.creekPositions();
            Position sitePosition = this.sitePosition();
            logger.info(creeksMap.size());
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String creekID = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + creekID);
            }
            logger.info("Site Position: " + sitePosition.toString());
        } catch (NoSuchElementException e) {
            Map<Position, String> creeksMap = this.creekPositions();
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String creekID = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + creekID);
            }
            logger.info("No emergency site found");
        }
        
    }

}
