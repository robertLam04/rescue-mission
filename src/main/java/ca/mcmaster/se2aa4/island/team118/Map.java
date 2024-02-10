package ca.mcmaster.se2aa4.island.team118;
import java.util.HashMap;

import ca.mcmaster.se2aa4.island.team118.Explorer.Biome;

public class Map {
    private HashMap<Integer[], Tile> TileMap;
    private Integer[] position;

    public Map() {
        this.TileMap = new HashMap<>();
        this.position = new Integer[]{0,0};
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

    private class Tile {
        boolean isBorder;
        boolean isSite;
        boolean isCreek;
        Biome biome;

        private Tile(boolean isBorder, boolean isSite, boolean isCreek, Biome biome) {
            this.isBorder = isBorder;
            this.isSite = isSite;
            this.isCreek = isCreek;
            this.biome = biome;
        }
    }
}
