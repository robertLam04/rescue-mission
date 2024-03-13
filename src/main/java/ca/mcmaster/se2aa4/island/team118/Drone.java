package ca.mcmaster.se2aa4.island.team118;

public class Drone {
    private Integer battery;
    private Direction heading;
    private Condition status;
    private Position location;

    public Drone(Integer initial_battery, Direction initial_direction){
        this.battery = initial_battery;
        this.heading = initial_direction;
        this.status = Condition.Working;
        this.location = new Position(0, 0);
    }
    public void updateBattery(Integer cost){
        // updates the drone battery level based on most recent action's cost
        cost = Math.abs(cost); 
        this.battery -= cost;
        if (this.battery < 0 ){
            this.battery = 0;
            this.status = Condition.MIA;
        }
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
    public void heading(Direction turningDirection){
        switch (this.heading.getHeading()) {
            case N:
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
            case E:
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
            case S:
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
            case W:
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
