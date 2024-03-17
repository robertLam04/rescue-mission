package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
   private boolean IS;
    private boolean Not;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setUp() {
        this.IS = Boolean.TRUE;
        this.Not =  Boolean.FALSE;
    }

    @Test
    void addIsBorder() {
        logger.info("Starting Tile IsBorder test");
        Tile testTile = new Tile();
        //Test if tile properly updates to represent a border
        testTile.addIsBorder(this.IS);
        assertEquals(this.IS,testTile.isBorder);
        //Test if tile properly updates to show it is not a border
        testTile.addIsBorder(this.Not);
        assertEquals(this.Not,testTile.isBorder);
    }

    @Test
    void addIsSite() {
        logger.info("Starting Tile IsSite test");
        Tile testTile = new Tile();
        //Test if tile properly updates to represent a site
        testTile.addIsSite(this.IS);
        assertEquals(this.IS,testTile.isSite);
        //Test if tile properly updates to show it is not a site
        testTile.addIsSite(this.Not);
        assertEquals(this.Not,testTile.isSite);
    }

    @Test
    void addIsCreek() {
        logger.info("Starting Tile IsCreek test");
        Tile testTile = new Tile();
        //Test if tile properly updates to represent a creek
        testTile.addIsCreek(this.IS);
        assertEquals(this.IS,testTile.isCreek);
        //Test if tile properly updates to show it is not a creek
        testTile.addIsCreek(this.Not);
        assertEquals(this.Not,testTile.isCreek);
    }

    @Test
    void addIsGround() {
        logger.info("Starting Tile IsGround test");
        Tile testTile = new Tile();
        //Test if tile properly updates to represent ground
        testTile.addIsGround(this.IS);
        assertEquals(this.IS,testTile.isGround);
        //Test if tile properly updates to show it is not ground
        testTile.addIsGround(this.Not);
        assertEquals(this.Not,testTile.isGround);
    }

    @Test
    void addbiomes() {
        logger.info("Starting Tile IsGround test");
        Tile testTile = new Tile();
        JSONArray biome = new JSONArray();
        biome.put("Beach");
        //Test if method properly updates biome
        testTile.addbiomes(biome);
        assertEquals(biome,testTile.biomes);
        biome.remove(0);
    }
}