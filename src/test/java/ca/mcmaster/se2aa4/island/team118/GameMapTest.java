package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


  class GameMapTest {
    Tile Creek;
    Tile Site;
    Tile Ocean;
    Tile Beach;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        List<String> creeks = new ArrayList<>();
        creeks.add("CREEK");
        List<String> biomes = new ArrayList<>();
        biomes.add("BEACH");
        this.Site = new Tile(Boolean.TRUE,new ArrayList<>(),Boolean.TRUE,new ArrayList<>());
        this.Creek = new Tile(Boolean.FALSE,creeks,Boolean.TRUE,new ArrayList<>());
        this.Beach = new Tile(Boolean.FALSE,new ArrayList<>(),Boolean.TRUE,biomes);
        this.Ocean = new Tile(Boolean.FALSE,new ArrayList<>(),Boolean.FALSE,new ArrayList<>());
    }

    @Test
    void putTile() {
        logger.info("Starting GameMap putTile test");
        GameMap testMap = new GameMap();
        //Test for placing a Tile at the start of the map
        Position startPosition = new Position(0,0);
        testMap.putTile(startPosition,this.Ocean);
        assertEquals(this.Ocean,testMap.getTile(startPosition));
        //Tests placing a Tile in a filled position (should swap tiles)
        testMap.putTile(startPosition,this.Beach);
        assertEquals(this.Ocean,testMap.getTile(startPosition));
        //Test placing  tiles in extremely far off position
        Position extremePosition = new Position(10000,-10000000);
        testMap.putTile(extremePosition,this.Site);
        assertEquals(this.Site,testMap.getTile(extremePosition));
    }


    @Test
    void sitePosition() {
        logger.info("Starting GameMap sitePosition test");
        GameMap testMap = new GameMap();
        Position startPosition = new Position(0,0);
        Position extremePosition = new Position(10000,-10000000);

        //Test that no positions are returned for empty map
        Exception testException = assertThrows(NoSuchElementException.class , testMap::sitePosition);
        assertEquals("Emergency site not found", testException.getMessage());

        //Test that no positions are returned for non-empty map with no site
        testMap.putTile(startPosition,this.Ocean);
        testException = assertThrows(NoSuchElementException.class , testMap::sitePosition);
        assertEquals("Emergency site not found", testException.getMessage());

        //Test that a position is returned for a map with a site
        testMap.putTile(extremePosition,this.Site);
        assertEquals(extremePosition,testMap.sitePosition());

    }

    @Test
    void creekPositions() {
        logger.info("Starting GameMap creekPositions test");
        GameMap testMap = new GameMap();
        Position startPosition = new Position(0,0);
        Position extremePosition = new Position(10000,-10000000);

        //Test that no positions are returned for empty map
        assertTrue(testMap.creekPositions().isEmpty());
        //Test that no positions arr returned for non-empty map with no creek
        testMap.putTile(startPosition,this.Ocean);
        assertTrue(testMap.creekPositions().isEmpty());
        //Test that a position is returned for a map with a creek
        testMap.putTile(extremePosition,this.Creek);
        assertEquals("CREEK",testMap.creekPositions().get(extremePosition));
    }
/*
    @Test
    void closestCreek() {
       /* GameMap testMap = new GameMap();
        Position closePosition = new Position(10,10);
        Position extremePosition = new Position(10000,10000000);
        List<String> creek = new ArrayList<>();
        creek.add("CREEK2");
        Tile FarCreek = new Tile(Boolean.FALSE,creek,Boolean.TRUE,new ArrayList<>());
        //Test that map returns no creeks for a map without creeks
        assertEquals("No creeks found",testMap.closestCreek());
        //Test that method properly returns closest creek in map
        testMap.putTile(closePosition,this.Creek);
        testMap.putTile(extremePosition,FarCreek);
        assertEquals("CREEK",testMap.closestCreek());

    }*/

}
