package ca.mcmaster.se2aa4.island.team118;

import java.util.List;

public class Tile {

    private boolean isGround;
    private boolean site;
    private List<String> creeks;
    private List<String> biomes;

    /* Might want to refactor this to be immutable at some point */

    public Tile(boolean site, List<String> creeks, boolean isGround, List<String> biomes) {
        this.site = site;
        this.creeks = creeks;
        this.isGround = isGround;
        this.biomes = biomes;
    }

    public boolean isGround() {
        return this.isGround;
    }

    public boolean isPOI() {
        return !creeks.isEmpty() || site;
    }   

    public boolean isSite() {
        return site;
    }

    public boolean isCreek() {
        return creeks != null && !creeks.isEmpty();
    }

    public List<String> getCreeks() {
        return creeks;
    }

    @Override
    public String toString() {
        return "Tile{" +
            "isSite=" + (this.site ? "true" : "false") +
            ", isCreek=" + (this.creeks != null ? this.creeks.toString() : "null") +
            ", isGround=" + (this.isGround ? "true" : "false") +
            ", biomes=" + (this.biomes != null ? this.biomes.toString() : "null") +
            '}';
    }
}
