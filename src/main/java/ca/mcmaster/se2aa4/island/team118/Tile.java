package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONArray;

public class Tile {
    boolean isBorder;
    boolean isSite;
    boolean isCreek;
    JSONArray biomes;

    public Tile(boolean isBorder, boolean isSite, boolean isCreek, JSONArray biomes) {
        this.isBorder = isBorder;
        this.isSite = isSite;
        this.isCreek = isCreek;
        this.biomes = biomes;
    }
}
