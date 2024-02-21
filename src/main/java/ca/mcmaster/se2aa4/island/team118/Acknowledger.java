package ca.mcmaster.se2aa4.island.team118;

public interface Acknowledger {

    public void scan();
    public void echo();
    public void updateStatus(Drone drone);
    public void updateBattery(Drone drone);
    
}
