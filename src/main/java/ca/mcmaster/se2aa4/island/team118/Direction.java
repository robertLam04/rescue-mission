package ca.mcmaster.se2aa4.island.team118;

public enum Direction {
    N, E, S, W;

    public static Direction fromString(String stringDirection) {
        switch (stringDirection.toLowerCase()) {
            case "n":
                return N;
            case "e":
                return E;
            case "s":
                return S;
            case "w":
                return W;
            default:
                throw new IllegalArgumentException("Invalid direction: " + stringDirection);
        }
    }

    public Direction left(){
        switch (this) {
            case N:
                return W;
            case E:
                return N;
            case S:
                return E;
            case W:
                return S;
            default:
                throw new IllegalArgumentException();
       }
    }
    public Direction right(){
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalArgumentException();
       }
    }
}

