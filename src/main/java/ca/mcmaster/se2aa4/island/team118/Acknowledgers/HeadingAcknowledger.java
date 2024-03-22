package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Reader;

public class HeadingAcknowledger implements Acknowledger{
    private Drone drone;
    private Reader reader;
    private Direction direction;

    public HeadingAcknowledger(Drone drone, Reader reader) {
        this.drone = drone;
        this.reader = reader;
        this.direction = reader.getDirection();
    }

    public void acknowledgeResults() {

        drone.updateBattery(reader.getCost());
        drone.heading(direction);

    }

}
