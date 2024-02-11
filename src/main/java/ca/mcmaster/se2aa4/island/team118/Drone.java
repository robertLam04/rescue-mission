package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    private Integer battery;
    private Direction heading;
    private Condition status;

    public Drone(Integer initial_battery, Direction initial_direction){
        this.battery = initial_battery;
        this.heading = initial_direction;
        this.status = Condition.Working;
    }
    public void updateBattery(Integer cost){
        // updates the drone battery level based on most recent action's cost
        this.battery -= cost;
    }

    public void updateDirection(Direction current_heading){
        // updates the drones current heading
        this.heading = current_heading;
    }

    public void updateStatus(Condition status){
        this.status = status;
    }
    public Integer getBattery(){
        // returns current battery level
        return this.battery;
    }

    public Direction getHeading(){
        //returns drones current direction
        return this.heading;
    }

    public Condition getStatus(){
        //returns drones current condition
        return this.status;
    }
}
