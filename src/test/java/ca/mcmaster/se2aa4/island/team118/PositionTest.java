package ca.mcmaster.se2aa4.island.team118;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Integer x;
    private Integer y;
    private Integer altX;
    private Integer altY;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup() {
        this.x=0;
        this.y=0;
        this.altX = 12;
        this.altY = -12;
    }

    @Test
    @DisplayName("Testing method to move along x")
    void moveXTest() {
        logger.info("Starting Position moveX test");
        Position testPosition = new Position(x,y);
        //Test if Position updates correctly in positive x direction
        testPosition.moveX(7);
        assertEquals(testPosition.getX(),7);
        //Test if Position updates correctly in negative x direction
        testPosition.moveX(-10);
        assertEquals(testPosition.getX(),-3);
    }

    @Test
    @DisplayName("Testing method to move along y")
    void moveYTest() {
        logger.info("Starting Position moveY test");
        Position testPosition = new Position(x,y);
        //Test if Position updates correctly in positive y direction
        testPosition.moveY(7);
        assertEquals(testPosition.getY(),7);
        //Test if Position updates correctly in negative y direction
        testPosition.moveY(-10);
        assertEquals(testPosition.getY(),-3);
    }

    @Test
    @DisplayName("Testing method to set specific x coordinate")
    void setXTest() {
        logger.info("Starting Position setX test");
        Position testPosition = new Position(x,y);
        //Test setting a positive x coordinate
        testPosition.setX(9);
        assertEquals(testPosition.getX(),9);
        //Test setting a negative x coordinate
        testPosition.setX(-1);
        assertEquals(testPosition.getX(),-1);
        //Test setting zero coordinate
        testPosition.setX(0);
        assertEquals(testPosition.getX(),0);
    }

    @Test
    @DisplayName("Testing method to set specific x coordinate")
    void setYTest() {
        logger.info("Starting Position setY test");
        Position testPosition = new Position(x,y);
        //Test setting a positive y coordinate
        testPosition.setY(9);
        assertEquals(testPosition.getY(),9);
        //Test setting a negative Y coordinate
        testPosition.setY(-1);
        assertEquals(testPosition.getY(),-1);
        //Test setting zero coordinate
        testPosition.setY(0);
        assertEquals(testPosition.getY(),0);
    }

    @Test
    @DisplayName("Testing method to convert coordinate position to strings")
    void ToStringTest() {
        logger.info("Starting Position ToString test");
        Position position1 = new Position(x,y);
        Position position2 = new Position(altX,altY);
        //Test genereate correct string for position 1
        assertEquals("("+x+","+y+")",position1.toString());
        //Test genereate correct string for position 1
        assertEquals("("+altX+","+altY+")",position2.toString());
    }

    @Test
    @DisplayName("Testing method to calculate distance from initial position")
    void distanceFromTest() {
        logger.info("Starting Position distanceFrom test");
        Position position1 = new Position(x,y);
        Position position2 = new Position(altX,altY);
        //Test whether method returns zero distance from itself
        Double distance1 = position1.distanceFrom(position1);
        Double distance2 = position2.distanceFrom(position2);
        assertEquals(0.0,distance1);
        assertEquals(0.0,distance2);
        //Test whether method returns correct distance from two different positions
        Double distance = position1.distanceFrom(position2);
        assertEquals(Math.sqrt(altX*altX + altY*altY),distance);
    }

}
