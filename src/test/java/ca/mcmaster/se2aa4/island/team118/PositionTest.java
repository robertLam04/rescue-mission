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
    @DisplayName("Testing method to move test")
    void moveTest() {
        logger.info("Starting Position moveY test");
        Position testPosition = new Position(x,y);
        //Test if Position updates correctly in positive x direction
        testPosition.move(7,Direction.E);
        assertEquals(7,testPosition.getX());
        //Test if Position updates correctly in positive y direction
        testPosition.move(7,Direction.N);
        assertEquals(7,testPosition.getY());
        //Test if Position updates correctly in negative y direction
        testPosition.move(10,Direction.S);
        assertEquals(-3,testPosition.getY());
        //Test if Position updates correctly in negative x direction
        testPosition.move(14,Direction.W);
        assertEquals(-7,testPosition.getX());
    }


    @Test
    @DisplayName("Testing method to convert coordinate position to strings")
    void ToStringTest() {
        logger.info("Starting Position ToString test");
        Position position1 = new Position(x,y);
        Position position2 = new Position(altX,altY);
        //Test generate correct string for position 1
        assertEquals("(0, 0)",position1.toString());
        //Test generate correct string for position 1
        assertEquals("(12, -12)",position2.toString());
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
        assertEquals(16.97056274847714,position1.distanceFrom(position2));
    }

      @Test
      void testEquals() {
          Position testPosition = new Position(x,y);
          Position position1 = new Position(x,y);
          Position position2 = new Position(altX,altY);
          //confirm that position1 is equal to the test position
          assertTrue(testPosition.equals(position1));
          //confirm that position2 is different from the test position
          assertFalse(testPosition.equals(position2));
          //confirm test position is different from a different object
          assertFalse(testPosition.equals(new String()));

      }
  }


