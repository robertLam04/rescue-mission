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
    private HashMap<Position, Tile> tileMap;
    //might not be needed
    private HashMap<Direction, Integer> borders;
  
    public GameMap() {
        this.tileMap = new HashMap<>();
        this.borders = new HashMap<>();
    }

    public Tile getTile(Position pos) {
        /* Returns the Tile at a position*/
        return tileMap.get(pos);
    }

    //make seperate tile update method
    public void putTile(Position position, Tile tile) {
        tileMap.put(position, tile);
    }

    //might not be needed
    public void setBorders(Direction direction, Position position, Integer range){
        position.move(range, direction);
        if (direction == Direction.N||direction == Direction.S){
            borders.put(direction, position.getY());
        } else if (direction == Direction.E||direction == Direction.W){
            borders.put(direction, position.getX());
        }
    }

    //might not be needed
    public boolean outOfBounds(Position position){
        if (position.getY() > borders.get(Direction.N)){
            return true;
        } else if (position.getX() > borders.get(Direction.E)){
            return true;
        } else if (position.getY() < borders.get(Direction.S)){
            return true;
        } else if (position.getX() < borders.get(Direction.W)){
            return true;
        } else {
            return false;
        }
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
                creeksMap.put(position, tile.getCreeks().get(0));
            }
        }
        return creeksMap;
    }

        public String closestCreek() {
        try {
            Map<Position, String> creeksMap = this.creekPositions();
            Position sitePosition = this.sitePosition();
            double closest_distance = Double.MAX_VALUE;
            String closest_creek = "";
            if (creeksMap.isEmpty()) {
                return "No creeks found";
            } else {
                for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                    Position creekPosition = entry.getKey();
                    String creekId = entry.getValue();
                    double current_distance = sitePosition.distanceFrom(creekPosition);
                    if (current_distance < closest_distance) {
                        closest_distance = current_distance;
                        closest_creek = creekId;
                    }
                }
            }
            logger.info("Closest creek: " + closest_creek);
            return closest_creek;
        } catch (NoSuchElementException e) {
            String random_creek = getRandomCreekId();
            logger.info(random_creek);
            return random_creek;
        }
    }

    private String getRandomCreekId() {
        Map<Position, String> creeksMap = this.creekPositions();
        List<String> creekIds = new ArrayList<>(creeksMap.values());
        Random random = new Random();
        if (creeksMap.isEmpty()) {return "No creeks found";}
        return creekIds.get(random.nextInt(creekIds.size()));
    }

    //Helper for testing (delete later)
    public void printPOIS() {
        try {
            Map<Position, String> creeksMap = this.creekPositions();
            Position sitePosition = this.sitePosition();
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String Id = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + Id);
            }
            logger.info("Site Position: " + sitePosition.toString());
        } catch (NoSuchElementException e) {
            Map<Position, String> creeksMap = this.creekPositions();
            for (Map.Entry<Position, String> entry : creeksMap.entrySet()) {
                Position position = entry.getKey();
                String Id = entry.getValue();
                logger.info("Creek Position: " + position.toString() + ", Creek ID: " + Id);
            }
            logger.info("No emergency site found");
        }
        
    }

}
