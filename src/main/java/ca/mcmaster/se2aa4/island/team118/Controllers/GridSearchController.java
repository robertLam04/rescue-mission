package ca.mcmaster.se2aa4.island.team118.Controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team118.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.*;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class GridSearchController implements Controller {

    private final Logger logger = LogManager.getLogger();
    private ActionFactory factory;
    private Phase phase;
    private Drone drone;
    private boolean goLeft = true;

    public GridSearchController(Drone drone, ActionFactory factory) {
        this.factory = factory;
        this.drone = drone;
        this.phase = new FindGround(drone, factory);
    }
    
    /**
    Gets the current decision from the current phase
    and returns it.

    @return string     the string representing the
                       decision being made
    */
    @Override
    public String makeDecision() {
        return phase.getNextDecision();
    }

    /**
    Updates the phase based on the drone battery,
    the response of the last decision (translated by reader)
    and the current phase.

    @param reader   the reader object which contains relevant information
                    about the last decision made and it's results
    */
    @Override
    public void updatePhase(Reader reader) {

        if ((int)drone.distanceToHome() == 0 && drone.getBattery()<=7){
            phase = new ReturnHome(factory);
        } else if (drone.distanceToHome() <= 10 && drone.getBattery() <= 15) { 
            phase = new ReturnHome(factory);
        } else if (drone.distanceToHome() > 10 && drone.getBattery() <= 25) {
            phase = new ReturnHome(factory);
        }

        boolean isGround = reader.isGround();

        if ("echo".equals(reader.getDecision())) {
                Integer range = reader.getRange();
                Direction echoDirection = reader.getDirection();
                
                if (phase.getCurrentPhase().equals("Danger")){
                    phase = new FindGround(drone, factory);
                }
                
                //Update the phase if the tile is ground
                if (isGround && 
                    (phase.getCurrentPhase().equals("FindGround")||
                    phase.getCurrentPhase().equals("EchoAfterExplore")||
                    phase.getCurrentPhase().equals("Uturn")||
                    phase.getCurrentPhase().equals("Shift")||
                    phase.getCurrentPhase().equals("DoubleShift")||
                    phase.getCurrentPhase().equals("SafeUturn"))) {
                    phase = new FlyToGround(drone, echoDirection, range + 1, factory);
                } else if ((!isGround)&&phase.getCurrentPhase().equals("EchoAfterExplore")){
                    goLeft = !goLeft;
                    phase = new FlyToUturn(drone, goLeft, factory);
                } else if ((!isGround||range>3)&&phase.getCurrentPhase().equals("FlyToUturn")){
                    phase = new Uturn(drone, goLeft, factory);
                } else if ((!isGround)&&phase.getCurrentPhase().equals("Uturn")) {
                    phase  = new Shift(drone, goLeft, factory);
                    goLeft = !goLeft;
                } else if ((!isGround)&&phase.getCurrentPhase().equals("Shift")){
                    goLeft = !goLeft;
                    phase = new DoubleShift(drone, goLeft, factory);
                    goLeft = !goLeft;
                } 
        } else if (reader.getDecision().equals("scan")){
                //if (tile.isSite()){phase = new ReturnHome();}
                
                //Switch to Explore ground phase if scan is called in FlyToGround phase
                if (phase.getCurrentPhase().equals("FlyToGround")) {
                    phase = new ExploreGround(factory);
                } else if (phase.getCurrentPhase().equals("ExploreGround")&&!isGround){
                    phase = new EchoAfterExplore(drone, factory);
                }else if (phase.getCurrentPhase().equals("Uturn")&&isGround){
                    phase = new ExploreGround(factory);
                }
        }
        logger.info(phase.getCurrentPhase());
        logger.info(drone.getLocation().toString());
        }
}
