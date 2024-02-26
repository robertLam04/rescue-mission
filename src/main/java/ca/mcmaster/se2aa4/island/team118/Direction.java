package ca.mcmaster.se2aa4.island.team118;



public class Direction {
    private Heading direction;

    public Direction(String s){
        switch (s.toLowerCase()) {
            case "n":
                this.direction = Heading.NORTH;
                break;
            case "e":
                this.direction = Heading.EAST;
                break;
            case "s":
                this.direction = Heading.SOUTH;
                break;
            case "w":
                this.direction = Heading.WEST;
                break;
            default:
                throw new IllegalArgumentException();
            }
    }
    public Heading left(){
        switch (this.direction) {
            case Heading.NORTH:
                return Heading.WEST;
            case Heading.EAST:
                return Heading.NORTH;
            case Heading.SOUTH:
                return Heading.EAST;
            case Heading.WEST:
                return Heading.SOUTH;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Heading right(){
        switch (this.direction) {
            case Heading.NORTH:
                return Heading.EAST;
            case Heading.EAST:
                return Heading.SOUTH;
            case Heading.SOUTH:
                return Heading.WEST;
            case Heading.WEST:
                return Heading.NORTH;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Heading getHeading(){
        return direction;
    }
    
}

