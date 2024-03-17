package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneTest {
    private Integer battery;
    private Direction heading;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setUp() {
        this.battery = 100;
        this.heading = Direction.E;

    }

    @Test
    @DisplayName("Testing method to update Drone battery")
    void updateBatteryTest() {
        logger.info("Starting Drone updatebattery test");

        Drone testDrone = new Drone(this.battery,this.heading);
        //Normal case
        testDrone.updateBattery(5);
        assertEquals(95,testDrone.getBattery());
        //Erroneous case
        testDrone.updateBattery(-11);
        assertEquals(95-11,testDrone.getBattery());
        //Extreme case
        testDrone.updateBattery(101);
        assertEquals(0,testDrone.getBattery());


    }

    @Test
    @DisplayName("Testing method to update Drone status")
    void updateStatusTest() {
        logger.info("Starting Drone updateStatus method");
        //Test that correct status is generated upon start up
        Drone testDrone = new Drone(this.battery,this.heading);
        assertSame(testDrone.getStatus(), Condition.Working );
        //Confirm that status is updated appropriately
        testDrone.updateStatus(Condition.MIA);
        assertSame(Condition.MIA,testDrone.getStatus());
    }

    @Test
    @DisplayName("Testing method to calculate Drone's distance to base")
    void distanceToStopTest() {
        logger.info("Starting Drone distanceToStop method");
        //Ensure Drone Starts in correct location and distanceToStop works at base location
        Drone testDrone = new Drone(this.battery,this.heading);
        Double distance =  testDrone.distanceToStop();
        assertEquals(0.0,distance);
        //Test whether distance is calculated properly after flight
        testDrone.fly();
        testDrone.fly();
        distance =  testDrone.distanceToStop();
        assertEquals(2.0,distance);
    }

    @Test
    @DisplayName("Testing to Determine if Drone flies properly")
    void flyTest() {
        logger.info("Starting Drone fly test");
        Drone testDrone = new Drone(this.battery,this.heading);
        testDrone.fly();
        Position location = testDrone.getLocation();
        assertEquals(location.toString(),new Position(1,0).toString());

    }

    @Test
    @DisplayName("Testing to Ensure Drone turns properly")
    void headingTest() {
        logger.info("Starting Drone heading test");
        Drone testDrone = new Drone(this.battery,this.heading);
        testDrone.heading(Direction.N);
        Position location = testDrone.getLocation();
        //Test Right Turn (should turn with momentum)
        assertSame(testDrone.getDroneHeading(),Direction.N);
        assertEquals(location.toString(),new Position(1,1).toString());
        //Test Left Turn
        testDrone.heading(this.heading);
        location = testDrone.getLocation();
        assertSame(testDrone.getDroneHeading(),Direction.E);
        assertEquals(location.toString(),new Position(2,2).toString());
    }
}