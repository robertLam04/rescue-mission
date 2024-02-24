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
    public void addIsBorder(boolean isBorder){
        this.isBorder = isBorder;
    }
    public void addIsSite(boolean isSite){
        this.isSite = isSite;
    }public void addIsCreek(boolean isCreek){
        this.isCreek = isCreek;
    }public void addIsGround(boolean isGround){
        this.isGround = isGround;
    }public void addbiomes(JSONArray biomes){
        this.biomes = biomes;
    }
}
