package ca.mcmaster.se2aa4.island.team118;

import java.util.List;

public interface Reader {

    public String getDecision();

    public boolean isGround();

    public List<String> getCreeks();

    public List<String> getBiomes();

    public boolean isSite();

    public Direction getDirection();

    public Integer range();
    
    public Integer getCost();
    
}
