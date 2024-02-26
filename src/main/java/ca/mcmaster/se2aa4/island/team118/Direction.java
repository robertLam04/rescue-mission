package ca.mcmaster.se2aa4.island.team118;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction left(){
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Direction right(){
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException();
       }
    }
}
