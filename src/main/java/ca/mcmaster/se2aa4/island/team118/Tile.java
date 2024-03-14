package ca.mcmaster.se2aa4.island.team118;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class Tile {

    private boolean isBorder;
    private boolean isSite;
    private boolean isCreek;
    private boolean isGround;
    private JSONArray biomes;

    /* Might want to refactor this to be immutable at some point */


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

    public boolean getIsBorder(){
        return this.isBorder;
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

    public boolean isGround() {
        return this.isGround;
    }

    public boolean isLand() {
        if (biomes.length() == 1 & biomes.get(0).equals("OCEAN")) {return false;}
        return true;
    }

    public boolean isPOI() {
        return isCreek || isSite;
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
