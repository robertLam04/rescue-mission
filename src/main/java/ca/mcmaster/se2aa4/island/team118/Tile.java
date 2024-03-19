package ca.mcmaster.se2aa4.island.team118;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class Tile {

    private boolean isBorder;
    private boolean isGround;
    private JSONArray sites;
    private JSONArray creeks;
    private JSONArray biomes;

    /* Might want to refactor this to be immutable at some point */

    public Tile(JSONArray sites, JSONArray creeks, boolean isGround, JSONArray biomes) {
        this.sites = sites;
        this.creeks = creeks;
        this.isGround = isGround;
        this.biomes = biomes;
    }

    public boolean isGround() {
        return this.isGround;
    }

    public boolean isPOI() {
        return !creeks.isEmpty() || !sites.isEmpty();
    }   

    public boolean isSite() {
        return sites != null && !sites.isEmpty();
    }

    public boolean isCreek() {
        return creeks != null && !creeks.isEmpty();
    }

    public String getCreek() {
        return creeks.getString(0);
    }

    @Override
    public String toString() {
        return "Tile{" +
            "isSite=" + (this.sites != null ? this.sites.toString() : "null") +
            ", isCreek=" + (this.creeks != null ? this.creeks.toString() : "null") +
            ", isGround=" + (this.isGround ? "true" : "false") +
            ", biomes=" + (this.biomes != null ? this.biomes.toString() : "null") +
            '}';
    }
}
