package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    int battery;
    Direction heading;

    public Drone(int initial_battery, Direction initial_direction){
        this.battery = initial_battery;
        this.heading = initial_direction;
    }
    public void updateBattery(int cost){
        this.battery -= cost;
    }
}
