package ca.mcmaster.se2aa4.island.team118.Readers;

import java.util.List;

import ca.mcmaster.se2aa4.island.team118.Direction;

public interface Reader {

    public String getDecision();

    public boolean isGround();

    public List<String> getCreeks();

    public List<String> getBiomes();

    public boolean isSite();

    public Direction getDirection();

    public Integer getRange();
    
    public Integer getCost();
    
}
