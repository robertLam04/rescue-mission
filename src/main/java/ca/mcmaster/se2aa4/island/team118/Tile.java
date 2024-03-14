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


    public Tile(boolean isBorder, JSONArray sites, JSONArray creeks, boolean isGround, JSONArray biomes) {
        this.isBorder = isBorder;
        this.sites = sites;
        this.creeks = creeks;
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
    public void addSites(JSONArray sites){
        this.sites = sites;
    }

    public void addCreeks(JSONArray creeks){
        this.creeks = creeks;
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
        return !creeks.isEmpty() || !sites.isEmpty();
    }

    @Override
    public String toString() {
        return "Tile{" +
            "isBorder=" + (this.isBorder ? "true" : "false") +
            ", isSite=" + (this.sites != null ? this.sites.toString() : "null") +
            ", isCreek=" + (this.creeks != null ? this.creeks.toString() : "null") +
            ", isGround=" + (this.isGround ? "true" : "false") +
            ", biomes=" + (this.biomes != null ? this.biomes.toString() : "null") +
            '}';
    }
}
