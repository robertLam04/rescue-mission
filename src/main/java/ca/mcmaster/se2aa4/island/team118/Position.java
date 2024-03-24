package ca.mcmaster.se2aa4.island.team118;

import java.util.Objects;

public class Position {

    private Integer x;
    private Integer y;

    public Position(Integer X, Integer Y) {
        this.x = X;
        this.y = Y;
    }

    public Position(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

    /**
    Moves the position based on distance and direction
    @param distance to move
    @param direction to move
    */
    public void move(Integer distance, Direction direction){
        switch (direction) {
            case N:
                this.y += distance;
                break;
            case E:
                this.x += distance;
                break;
            case S:
                this.y -= distance;
                break;
            case W:
                this.x -= distance;
                break;
            default:
                throw new IllegalArgumentException();
       }
    }

    /**
    Calculates the distance between this position and
    another position.
    @param position
    @return distance as a double
    */
    public double distanceFrom(Position second_pos){
        Integer diff_x = this.x - second_pos.getX();
        Integer diff_y = this.y - second_pos.getY();
        return Math.sqrt((diff_x*diff_x) + (diff_y*diff_y));
    }

    /**
     * Compares this Position object with the specified object for equality.
     * Two Position objects are considered equal if they have the same x and y coordinates.
     *
     * @param obj the object to be compared for equality
     * @return true if the specified object is equal to this Position object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }

    /**
     * Returns a hash code value for this Position object.
     * The hash code is computed based on the x and y coordinates of this Position.
     *
     * @return the hash code value for this Position object
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y +")";
    }
}
