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
            case NORTH:
                return Heading.WEST;
            case EAST:
                return Heading.NORTH;
            case SOUTH:
                return Heading.EAST;
            case WEST:
                return Heading.SOUTH;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Heading right(){
        switch (this.direction) {
            case NORTH:
                return Heading.EAST;
            case EAST:
                return Heading.SOUTH;
            case SOUTH:
                return Heading.WEST;
            case WEST:
                return Heading.NORTH;
            default:
                throw new IllegalArgumentException();
       }
    }
    
}

