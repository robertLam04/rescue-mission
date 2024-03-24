package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class HeadingAcknowledger implements Acknowledger{
    private Drone drone;

    public HeadingAcknowledger(Drone drone) {
        this.drone = drone;
    }

    /**
    Acknowledge the results of 'heading' action based on the contents
    of the 'reader' object. Updates the drones battery,
    gets the direction of the turn from reader then
    moves the drone by calling drone.turn(Direction)

    @param  reader   the reader object which contains necessary
                     information from the response
    */
    public void acknowledgeResults(Reader reader) {
        Direction direction = reader.getDirection();
        drone.updateBattery(reader.getCost());
        drone.turn(direction);

    }

}
