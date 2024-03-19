package ca.mcmaster.se2aa4.island.team118;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameMap {

    private final Logger logger = LogManager.getLogger();
    private HashMap<Position, Tile> tileMap;
  
    public GameMap() {
        this.tileMap = new HashMap<>();
    }

    public Tile getTile(Position pos) {
        /* Returns the Tile at a position*/
        return tileMap.get(pos);
    }

    //make seperate tile update method
    public void putTile(Position position, Tile tile) {
        /*
         * if (this.tileMap.get(position) == null){
            tileMap.put(position, tile);
        } else {
            tileMap.remove(position);
            tileMap.put(position, tile);
        }
         */
        tileMap.put(position, tile);
    }

    public void printMap() {
        for (Map.Entry<Position, Tile> entry : tileMap.entrySet()) {
            Position position = entry.getKey();
            Tile tile = entry.getValue();
            logger.info("Position: " + position.toString() + ", Tile: " + tile.toString());
        }
    }

    //Returns the position of the emergency site, we don't care about the ID
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

    public Map<Position, String> creekPositions() {
        Map<Position, String> creeksMap = new HashMap<>();
        for (Map.Entry<Position, Tile> entry : tileMap.entrySet()) {
            Position position = entry.getKey();
            Tile tile = entry.getValue();
            if (tile.isCreek()) {
                creeksMap.put(position, tile.getCreek());
            }
        }
        return creeksMap;
    }
}
