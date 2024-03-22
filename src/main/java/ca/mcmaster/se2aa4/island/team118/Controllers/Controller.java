package ca.mcmaster.se2aa4.island.team118.Controllers;

import ca.mcmaster.se2aa4.island.team118.Reader;

public interface Controller {

    public String makeDecision();
    
    public void processDecision(Reader reader);

} 
