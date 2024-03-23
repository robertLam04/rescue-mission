package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecisionTest {/*
    Direction direction;
    Direction Alternatedirection;
    private final Logger logger = LogManager.getLogger();
    @BeforeEach
    void setup(){
        direction = Direction.E;
        Alternatedirection = Direction.N;
    }
    @Test
    void fly() {
       logger.info("Starting Decision fly test");
       Decision testDecision = new Decision();
        JSONObject  fly = testDecision.fly();
       assertEquals("fly",fly.get("action"));
    }

    @Test
    void stop() {
        logger.info("Starting Decision stop test");
        Decision testDecision = new Decision();
        JSONObject  stop = testDecision.stop();
        assertEquals("stop",stop.get("action"));
    }

    @Test
    void echo() {
        Decision testDecision = new Decision();
        JSONObject  echo = testDecision.echo(this.direction);
        JSONObject direction = echo.getJSONObject("parameters");
        //Test whether echo generates object properly for two different headings
        assertEquals("echo",echo.get("action"));
        assertEquals("E",direction.get("direction"));

        echo = testDecision.echo(this.Alternatedirection);
        direction = echo.getJSONObject("parameters");
        assertEquals("echo",echo.get("action"));
        assertEquals("N",direction.get("direction"));
    }

    @Test
    void scan() {
        logger.info("Starting Decision scan test");
        Decision testDecision = new Decision();
        //
        JSONObject  scan = testDecision.scan();
        assertEquals("scan",scan.get("action"));
    }

    @Test
    void heading() {
        Decision testDecision = new Decision();
        JSONObject heading = testDecision.heading(this.direction);
        JSONObject direction = heading.getJSONObject("parameters");
        //Test whether heading generates object properly for two different headings.
        assertEquals("heading", heading.get("action"));
        assertEquals("E", direction.get("direction"));

        heading = testDecision.heading(this.Alternatedirection);
        direction = heading.getJSONObject("parameters");
        assertEquals("heading", heading.get("action"));
        assertEquals("N", direction.get("direction"));
    }*/
}