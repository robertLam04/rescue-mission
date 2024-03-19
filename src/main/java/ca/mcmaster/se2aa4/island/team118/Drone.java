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
        switch (heading) {
            case N:
                location.moveY(1);
                break;
            case E:
                location.moveX(1);
                break;
            case S:
                location.moveY(-1);
                break;
            case W:
                location.moveX(-1);
                break;
            default:
                throw new IllegalArgumentException();
       }
    }

    public Position potentialFly(){
        switch (heading) {
            case N:
                return new Position(location.getX(),location.getY()+1);
            case E:
                return new Position(location.getX()+1,location.getY());
            case S:
                return new Position(location.getX(),location.getY()-1);
            case W:
            return new Position(location.getX()-1,location.getY());
            default:
                throw new IllegalArgumentException();
       }
    }

    public Position potentialDoubleFly(){
        switch (heading) {
            case N:
                return new Position(location.getX(),location.getY()+2);
            case E:
                return new Position(location.getX()+2,location.getY());
            case S:
                return new Position(location.getX(),location.getY()-2);
            case W:
            return new Position(location.getX()-2,location.getY());
            default:
                throw new IllegalArgumentException();
       }
    }

    public void heading(Direction turningDirection){
        switch (this.heading) {
            case N:
                if (this.heading.left() == turningDirection){
                    location.moveY(1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection) {
                    location.moveY(1);
                    location.moveX(1);
                    this.heading = turningDirection;
                }
                break;
            case E:
                if (this.heading.left() == turningDirection){
                    location.moveY(1);
                    location.moveX(1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection) {
                    location.moveY(-1);
                    location.moveX(1);
                    this.heading = turningDirection;
                }
                break;
            case S:
                if (this.heading.left() == turningDirection){
                    location.moveY(-1);
                    location.moveX(1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection) {
                    location.moveY(-1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                }
                break;
            case W:
                if (this.heading.left() == turningDirection){
                    location.moveY(-1);
                    location.moveX(-1);
                    this.heading = turningDirection;
                } else if (this.heading.right() == turningDirection) {
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
