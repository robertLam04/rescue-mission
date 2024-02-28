package ca.mcmaster.se2aa4.island.team118;

import org.json.JSONArray;

public class Tile {

    boolean isBorder;
    boolean isSite;
    boolean isCreek;
    boolean isGround;
    JSONArray biomes;

    public Tile(boolean isBorder, boolean isSite, boolean isCreek, boolean isGround, JSONArray biomes) {
        this.isBorder = isBorder;
        this.isSite = isSite;
        this.isCreek = isCreek;
        this.isGround = isGround;
        this.biomes = biomes;
    }
    
    public Tile(){
      
    }
    
    public void addIsBorder(boolean Border){
        this.isBorder = Border;
    }

    public void addIsSite(boolean Site){
        this.isSite = Site;
    }

    public void addIsCreek(boolean Creek){
        this.isCreek = Creek;
    }

    public void addIsGround(boolean Ground){
        this.isGround = Ground;
    }

    public void addbiomes(JSONArray biomes){
        this.biomes = biomes;
    }

    @Override
    public String toString() {
        return "Tile{" +
            "isBorder=" + (this.isBorder ? "true" : "false") +
            ", isSite=" + (this.isSite ? "true" : "false") +
            ", isCreek=" + (this.isCreek ? "true" : "false") +
            ", isGround=" + (this.isGround ? "true" : "false") +
            ", biomes=" + (this.biomes != null ? this.biomes.toString() : "null") +
            '}';
    }
}
