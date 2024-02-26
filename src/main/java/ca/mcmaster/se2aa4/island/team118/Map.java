package ca.mcmaster.se2aa4.island.team118;
import java.util.HashMap;

import org.json.JSONArray;

public class Map {
    private HashMap<Position, Tile> TileMap;
    private Position position;

    public Map() {
        this.TileMap = new HashMap<>();
    }

    public Tile getTile() {
        /* Returns the Tile at a position*/
        return TileMap.get(position);
    }

    public void putTile(Position position, Tile tile) {
        TileMap.put(position, tile);
    }

}
