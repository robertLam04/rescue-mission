package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    
    private Integer battery;
    private Direction heading;
    private Position location;

    public Drone(Integer initial_battery, Direction initial_direction){
        this.battery = initial_battery;
        this.heading = initial_direction;
        this.location = new Position(0, 0);
    }
    public void updateBattery(Integer cost){
        // updates the drone battery level based on most recent action's cost
        cost = Math.abs(cost); 
        this.battery -= cost;
        if (this.battery < 0) {this.battery = 0;}
    }

    public void updateHeading(Direction current_heading){
        // updates the drones current heading
        this.heading = current_heading;
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
        return new Position(location);
    }

    public double distanceToStop(){
        return location.distanceFrom(new Position(0,0));
    }
    
    public void fly(){
        location.move(1, heading);
    }


    //might not be needed
    public Position potentialFly(){
        Position potentialPosition = new Position(location.getX(),location.getY());
        potentialPosition.move(1, heading);
        return potentialPosition;
           
    }

    //might not be needed
    public Position potentialDoubleFly(){
        Position potentialPosition = new Position(location.getX(),location.getY());
        potentialPosition.move(2, heading);
        return potentialPosition;
    }


    //might not be needed
    public Position potentialShift(Boolean isLeft){
        Position potentialPosition = new Position(location.getX(),location.getY());
        if (isLeft){
            potentialPosition.move(2, heading.left());
        } else {
            potentialPosition.move(2, heading.right());
        }
        return potentialPosition;
    }

    public void heading(Direction turningDirection){        
        location.move(1, heading);
        location.move(1, turningDirection);
        this.heading = turningDirection;
    }

}
