package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import java.util.List;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.GameMap;
import ca.mcmaster.se2aa4.island.team118.Tile;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class ScanAcknowledger implements Acknowledger{
    private Drone drone;
    private GameMap map;

    public ScanAcknowledger(Drone drone, GameMap map) {
        this.drone = drone;
        this.map = map;
    }

    /**
    Acknowledge the results of 'scan' action based on the contents
    of the 'reader' object. Updates the drones battery, adds
    a new tile to the map at the drone's location.

    @param  reader   the reader object which contains necessary
                     information from the response
    */
    public void acknowledgeResults(Reader reader) {

        drone.updateBattery(reader.getCost());

        boolean isGround = reader.isGround();
        List<String> creeks = reader.getCreeks();
        boolean isSite = reader.isSite();
        List<String> biomes = reader.getBiomes();

        Tile tile = new Tile(isSite, creeks, isGround, biomes);
        map.putTile(drone.getLocation(), tile);

    }

}
