package ca.mcmaster.se2aa4.island.team118;

import ca.mcmaster.se2aa4.island.team118.Direction;

public class Drone {
    private Integer battery;
    private Direction heading;
    private Condition status;
    private Position location;

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

    public Direction getDroneHeading(){
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
    
    public void fly(){
        switch (heading.getHeading()) {
            case NORTH:
                location.moveY(1);
                break;
            case EAST:
                location.moveX(1);
            case SOUTH:
                location.moveY(-1);
            case WEST:
                location.moveX(-1);
            default:
                throw new IllegalArgumentException();
       }
    }
    public void heading(Direction turningDirection){
        switch (this.heading.getHeading()) {
            case NORTH:
                if (this.heading.left() == turningDirection.getHeading()){
                    location.moveY(1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection.getHeading()) {
                    location.moveY(1);
                    location.moveX(1);
                    this.heading = turningDirection;
                }
                break;
            case EAST:
                if (this.heading.left() == turningDirection.getHeading()){
                    location.moveY(1);
                    location.moveX(1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection.getHeading()) {
                    location.moveY(-1);
                    location.moveX(1);
                    this.heading = turningDirection;
                }
                break;
            case SOUTH:
                if (this.heading.left() == turningDirection.getHeading()){
                    location.moveY(-1);
                    location.moveX(1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection.getHeading()) {
                    location.moveY(-1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                }
                break;
            case WEST:
                if (this.heading.left() == turningDirection.getHeading()){
                    location.moveY(-1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection.getHeading()) {
                    location.moveY(1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                }
                break;
            default:
                throw new IllegalArgumentException();
       }
    }

}
