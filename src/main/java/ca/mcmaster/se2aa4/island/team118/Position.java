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

    //Alternative to getters
    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

    public Position moveX(Integer X){
        this.x = this.x + X;
        return this;
    }

    public Position moveY(Integer Y){
        this.y = this.y + Y;
        return this;
    }

    //Remove setters?
    public void setX(Integer X){
        this.x = X;
    }

    public void setY(Integer Y){
        this.y = Y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public double distanceFrom(Position second_pos){
        Integer diff_x = this.x - second_pos.getX();
        Integer diff_y = this.y - second_pos.getY();
        return Math.sqrt((diff_x*diff_x) + (diff_y*diff_y));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
