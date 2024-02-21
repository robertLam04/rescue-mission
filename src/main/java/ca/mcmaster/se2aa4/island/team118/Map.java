package ca.mcmaster.se2aa4.island.team118;
import java.util.HashMap;

import ca.mcmaster.se2aa4.island.team118.Explorer.Biome;

public class Map {
    private HashMap<Position, Tile> TileMap;
    private Position position;

    public Map() {
        this.TileMap = new HashMap<>();
        this.position = new Position(0,0);
    }

    public Tile getTile() {
        /* Returns the current Tile */
        return TileMap.get(position);
    }

    public void updateFly(Direction direction) {
        /* Update the position */
    }

    public void updateRadar(boolean isGround, Integer distance, Direction direction) {
        /* Access the most recent radar and create the Tile */

    }

    public void updateScan(Biome biome, boolean isPOI, boolean isCreek) {
        /* Need to access the most recent scan and update the current Tile */

    }
}
