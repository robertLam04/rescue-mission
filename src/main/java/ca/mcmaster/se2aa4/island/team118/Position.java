package ca.mcmaster.se2aa4.island.team118;

public class Position {

    private Integer x;
    private Integer y;

    public Position(Integer X, Integer Y) {
        this.x = X;
        this.y = Y;
    }

    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

    public void moveX(Integer X){
        this.x = this.x + X;
    }

    public void moveY(Integer Y){
        this.y = this.y + Y;
    }

    public void setX(Integer X){
        this.x = X;
    }

    public void setY(Integer Y){
        this.y = Y;
    }


}
