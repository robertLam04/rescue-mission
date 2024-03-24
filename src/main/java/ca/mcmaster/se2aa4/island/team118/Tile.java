package ca.mcmaster.se2aa4.island.team118;

import java.util.List;

public class Tile {

    private boolean isGround;
    private boolean isSite;
    private List<String> creeks;
    private List<String> biomes;

    public Tile(boolean site, List<String> creeks, boolean isGround, List<String> biomes) {
        this.isSite = site;
        this.creeks = creeks;
        this.isGround = isGround;
        this.biomes = biomes;
    }

    public boolean isGround() {
        return this.isGround;
    }

    public boolean isPOI() {
        return !creeks.isEmpty() || isSite;
    }   

    public boolean isSite() {
        return this.isSite;
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
            "isSite=" + (this.isSite ? "true" : "false") +
            ", isCreek=" + (this.creeks != null ? this.creeks.toString() : "null") +
            ", isGround=" + (this.isGround ? "true" : "false") +
            ", biomes=" + (this.biomes != null ? this.biomes.toString() : "null") +
            '}';
    }
}
