package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    private boolean IS;
    private boolean Not;
    private List<String> biomes;
    private List<String> creeks;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setUp() {
        this.IS = Boolean.TRUE;
        this.Not =  Boolean.FALSE;
        this.creeks = new ArrayList<>();
        creeks.add("CREEK");
        this.biomes = new ArrayList<>();
        biomes.add("BEACH");
    }


    @Test
    void IsSite() {
        logger.info("Starting Tile IsSite test");
        Tile testTile = new Tile(this.IS,this.creeks,this.Not,this.biomes);
        //Test if tile properly updates to represent a site
        assertTrue(testTile.isSite());
        //Test if tile properly updates to show it is not a site
        testTile = new Tile(this.Not,this.creeks,this.Not,this.biomes);
        assertFalse(testTile.isSite());
    }

    @Test
    void IsCreek() {
        logger.info("Starting Tile IsCreek test");
        Tile testTile = new Tile(this.Not,this.creeks,this.Not,this.biomes);
        //Test if tile properly updates to represent a creek
        assertTrue(testTile.isCreek());
        //Test if tile properly updates to show it is not a creek
        testTile = new Tile(this.Not, new ArrayList<>() , this.Not, this.biomes);
        assertFalse(testTile.isCreek());
    }

    @Test
    void addIsGround() {
        logger.info("Starting Tile IsGround test");
        Tile testTile = new Tile(this.Not,this.creeks,this.IS,this.biomes);
        //Test if tile properly updates to represent ground
        assertTrue(testTile.isGround());
        //Test if tile properly updates to show it is not ground
        testTile = new Tile(this.IS,this.creeks,this.Not,this.biomes);
        assertFalse(testTile.isGround());
    }

    @Test
    void getCreeks() {
        Tile testTile = new Tile(this.Not,this.creeks,this.IS,this.biomes);
    }
    @Test
    void isPOI(){
        logger.info("Starting Tile IsPOI test");
        Tile testTile = new Tile(this.Not,this.creeks,this.IS,this.biomes);
        //Test if tile properly updates to represent a POI
        assertTrue(testTile.isPOI());
        //Test if tile properly updates to show it is not a POI
        testTile = new Tile(this.Not,new ArrayList<>(),this.IS,this.biomes);
        assertFalse(testTile.isPOI());
    }
}

