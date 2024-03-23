package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.Reader;

public class FlyAcknowledger implements Acknowledger{

    private Drone drone;
    private Reader reader;

    public FlyAcknowledger(Drone drone, Reader reader) {
        this.drone = drone;
        this.reader = reader;
    }

    public void acknowledgeResults() {

        drone.updateBattery(reader.getCost());
        drone.fly();

    }

}
