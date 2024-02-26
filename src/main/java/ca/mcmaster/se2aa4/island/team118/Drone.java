package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    private Integer battery;
    private Heading heading;
    private Condition status;
    private Position location;

    public Drone(Integer initial_battery, Heading initial_direction){
        this.battery = initial_battery;
        this.heading = initial_direction;
        this.status = Condition.Working;
    }
    public void updateBattery(Integer cost){
        // updates the drone battery level based on most recent action's cost
        this.battery -= cost;
    }

    public void updateDirection(Heading current_heading){
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

    public Heading getHeading(){
        //returns drones current direction
        return this.heading;
    }

    public Condition getStatus(){
        //returns drones current condition
        return this.status;
    }

    public Position getLocation(){
        return new Position(location.getX(),location.getY());
    }
    
    public void moveX(Integer X){
        location.moveX(X);
    }
    public void moveY(Integer Y){
        location.moveY(Y);
    }

}
