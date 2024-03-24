package ca.mcmaster.se2aa4.island.team118.Controllers;

import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public interface Controller {

    public String makeDecision();
    
    public void updatePhase(Reader reader);

} 
