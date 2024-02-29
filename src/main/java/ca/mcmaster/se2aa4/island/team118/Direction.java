package ca.mcmaster.se2aa4.island.team118;

public enum Direction {
    n("n"), e("e"), s("s"), w("w");
    
    private final String value;

    Direction(String s) {
        this.value = s.toLowerCase();
    }

    public static Direction fromString(String string_direction) {
        switch (string_direction.toLowerCase()) {
            case "n":
                return n;
            case "e":
                return e;
            case "s":
                return s;
            case "w":
                return w;
            default:
                throw new IllegalArgumentException("Invalid direction: " + s);
        }
    }

    public Direction left(){
        switch (this) {
            case n:
                return w;
            case e:
                return n;
            case s:
                return e;
            case w:
                return s;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Direction right(){
        switch (this) {
            case n:
                return e;
            case e:
                return s;
            case s:
                return w;
            case w:
                return n;
            default:
                throw new IllegalArgumentException();
       }
    }

    public Direction getHeading(){
        return this;
    }
    
}

