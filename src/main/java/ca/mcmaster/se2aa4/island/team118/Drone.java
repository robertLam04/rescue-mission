package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    
    private Integer battery;
    private Direction heading;
    private Position location;

    public Drone(Integer initialBattery, Direction initialDirection){
        this.battery = initialBattery;
        this.heading = initialDirection;
        this.location = new Position(0, 0);
    }

    /**
    Updates the drone battery level based on cost

    @params cost of action
    */
    public void updateBattery(Integer cost){
        
        cost = Math.abs(cost); 
        this.battery -= cost;
        if (this.battery < 0) {this.battery = 0;}
    }

    public void updateHeading(Direction currentHeading){
        // updates the drones current heading
        this.heading = currentHeading;
    }

    public Integer getBattery(){
        // returns current battery level
        return this.battery;
    }

    public Direction getHeading(){
        //returns drones current direction
        return this.heading;
    }

    public Position getLocation(){
        //returns drones current position
        return new Position(location);
    }

    /**
    Calculates the distance between the starting pos
    (0,0) and the drone's current position

    @return direct distance to starting point
    */
    public double distanceToHome(){
        return location.distanceFrom(new Position(0,0));
    }
    
    public void fly(){
        location.move(1, heading);
    }

    public void turn(Direction turningDirection){        
        location.move(1, heading);
        location.move(1, turningDirection);
        this.heading = turningDirection;
    }

}
