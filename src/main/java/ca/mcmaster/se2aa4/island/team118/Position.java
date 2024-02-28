package ca.mcmaster.se2aa4.island.team118;

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

    public Position moveX(Integer X){
        this.x = this.x + X;
        return this;
    }

    public Position moveY(Integer Y){
        this.y = this.y + Y;
        return this;
    }

    public void setX(Integer X){
        this.x = X;
    }

    public void setY(Integer Y){
        this.y = Y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }


}
