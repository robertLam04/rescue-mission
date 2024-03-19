package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/* SORRY AMOS
 * class GameMapTest {
    Tile Creek;
    Tile Site;
    Tile Ocean;
    Tile Beach;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        this.Beach = new Tile();
        this.Beach.addIsGround(Boolean.TRUE);
        this.Ocean = new Tile();
        this.Beach.addIsGround(Boolean.FALSE);
        this.Creek = new Tile();
        JSONArray creek = new  JSONArray();
        this.Creek.addCreeks(creek);
        creek.put("CREEK");
        this.Site= new Tile();
        JSONArray site = new  JSONArray();
        site.put("POI");
        this.Site.addSites(site);
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
        assertEquals(this.Beach,testMap.getTile(startPosition));
        //Test placing multiple tiles in extremely far off position
        Position extremePosition = new Position(10000,-10000000);
       testMap.putTile(extremePosition,this.Site);
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

        //Test that no position is returned for a site tile that is empty
        JSONArray emptyPOI = new JSONArray();
        Tile emptySite = new Tile();
        emptySite.addSites(emptyPOI);
        testMap.putTile(extremePosition,emptySite);
        testException = assertThrows(NoSuchElementException.class , testMap::sitePosition);
        assertEquals("Emergency site not found", testException.getMessage());


    }

    @Test
    void creekPositions() {
        logger.info("Starting GameMap creekPositions test");
        GameMap testMap = new GameMap();
        Position startPosition = new Position(0,0);
        Position extremePosition = new Position(10000,-10000000);
        JSONArray emptyPOI = new JSONArray();
        Tile emptyCreek = new Tile();
        emptyCreek.addCreeks(emptyPOI);
        //Test that no positions are returned for empty map
        assertTrue(testMap.creekPositions().isEmpty());
        //Test that no positions arr returned for non-empty map with no creek
        testMap.putTile(startPosition,this.Ocean);
        assertTrue(testMap.creekPositions().isEmpty());
        //Test that a position is returned for a map with a creek
        testMap.putTile(extremePosition,this.Creek);
        assertEquals("CREEK",testMap.creekPositions().get(extremePosition));
        //Test that no position is returned for a creek tile that is empty
        testMap.putTile(extremePosition,emptyCreek);
        assertTrue(testMap.creekPositions().isEmpty());
    }
}
 */