package ca.mcmaster.se2aa4.island.team118;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class Week3BonusController implements Controller {
    int counter = 1;
    private final Logger logger = LogManager.getLogger();
    public String makeDecision(Drone drone){
        JSONObject decision = new JSONObject();
        if (counter == 1) {
            decision.put( "action", "echo");
            switch (drone.getHeading()) {
                case NORTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "N"));
                    counter++;
                    break;
                case EAST:
                    decision.put("parameters", (new JSONObject()).put("direction", "E"));
                    counter++;
                    break;
                case SOUTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "S"));
                    counter++;
                    break;
                case WEST:
                    decision.put("parameters", (new JSONObject()).put("direction", "W"));
                    counter++;
                    break;
                default:
                    throw new IllegalArgumentException();
                }
        }else if (counter == 2){
            decision.put( "action", "echo");
            switch (drone.getHeading().left()) {
                case NORTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "N"));
                    counter++;
                    break;
                case EAST:
                    decision.put("parameters", (new JSONObject()).put("direction", "E"));
                    counter++;
                    break;
                case SOUTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "S"));
                    counter++;
                    break;
                case WEST:
                    decision.put("parameters", (new JSONObject()).put("direction", "W"));
                    counter++;
                    break;
                default:
                    throw new IllegalArgumentException();
                }
        } else if (counter == 3){
            decision.put( "action", "echo");
            switch (drone.getHeading().right()) {
                case NORTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "N"));
                    counter++;
                    break;
                case EAST:
                    decision.put("parameters", (new JSONObject()).put("direction", "E"));
                    counter++;
                    break;
                case SOUTH:
                    decision.put("parameters", (new JSONObject()).put("direction", "S"));
                    counter++;
                    break;
                case WEST:
                    decision.put("parameters", (new JSONObject()).put("direction", "W"));
                    counter++;
                    break;
                default:
                    throw new IllegalArgumentException();
                }
        } else {
            decision.put("action", "stop");
        }
         
        logger.info("** Decision: {}",decision.toString());
        return decision.toString();
    }
        
    
}
