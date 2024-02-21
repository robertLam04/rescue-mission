package ca.mcmaster.se2aa4.island.team118;

import java.util.List;
import org.json.JSONArray;
import ca.mcmaster.se2aa4.island.team118.Explorer.Biome;

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
