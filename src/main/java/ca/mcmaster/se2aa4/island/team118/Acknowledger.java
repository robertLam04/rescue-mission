package ca.mcmaster.se2aa4.island.team118;

public interface Acknowledger {

    public Tile scan();
    public Tile echo();
    public Integer range();
    public void updateStatus(Drone drone);
    public void updateBattery(Drone drone);
    
}
