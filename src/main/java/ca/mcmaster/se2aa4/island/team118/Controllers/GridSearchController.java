package ca.mcmaster.se2aa4.island.team118.Controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team118.*;
import ca.mcmaster.se2aa4.island.team118.ActionFactories.ActionFactory;
import ca.mcmaster.se2aa4.island.team118.MissionPhases.*;

public class GridSearchController implements Controller {

    private final Logger logger = LogManager.getLogger();
    private String previous_decision;
    private ActionFactory factory;
    private Phase phase;
    private Drone drone;
    private boolean isLeft = true;

    public GridSearchController(Drone drone, ActionFactory factory) {
        this.factory = factory;
        this.drone = drone;
        this.phase = new FindGround(drone, factory);
    }
    
    @Override
    public String makeDecision() {
        if (((int)drone.distanceToStop() == 0)&&(drone.getBattery()<=7)){
            phase = new ReturnHome(factory);
        } else if ((drone.distanceToStop() <= 10)&&(drone.getBattery() <= 15)) { 
            phase = new ReturnHome(factory);
        } else if ((drone.distanceToStop() > 10)&&(drone.getBattery() <= 25)) {
            phase = new ReturnHome(factory);
        }

        previous_decision = phase.getNextDecision();
        return previous_decision;
    }

    @Override
    public void processDecision(Reader reader) {

        boolean isGround = reader.isGround();

        if (reader.getDecision().equals("echo")) {
                Integer range = reader.range();
                Direction echo_dir = reader.getDirection();
                
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
                    phase = new FlyToGround(drone, echo_dir, range + 1, factory);
                } else if ((!isGround)&&phase.getCurrentPhase().equals("EchoAfterExplore")){
                    isLeft = !isLeft;
                    phase = new FlyToUturn(drone, isLeft, factory);
                } else if ((!isGround||range>3)&&phase.getCurrentPhase().equals("FlyToUturn")){
                    phase = new Uturn(drone, isLeft, factory);
                } else if ((!isGround)&&phase.getCurrentPhase().equals("Uturn")) {
                    phase  = new Shift(drone, isLeft, factory);
                    isLeft = !isLeft;
                } else if ((!isGround)&&phase.getCurrentPhase().equals("Shift")){
                    isLeft = !isLeft;
                    phase = new DoubleShift(drone, isLeft, factory);
                    isLeft = !isLeft;
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
