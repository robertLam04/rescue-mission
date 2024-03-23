package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class FlyAcknowledger implements Acknowledger{

    private Drone drone;

    public FlyAcknowledger(Drone drone) {
        this.drone = drone;
    }

    /**
    Acknowledge the results of 'fly' based on the contents
    of the 'reader' object. Updates the drones battery,
    moves the drone by calling drone.fly()

    @param  reader   the reader object which contains necessary
                     information from the response
    */
    public void acknowledgeResults(Reader reader) {
        drone.updateBattery(reader.getCost());
        drone.fly();
    }

}
