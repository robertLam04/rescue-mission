package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import java.util.List;

import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.GameMap;
import ca.mcmaster.se2aa4.island.team118.Position;
import ca.mcmaster.se2aa4.island.team118.Reader;
import ca.mcmaster.se2aa4.island.team118.Tile;

public class ScanAcknowledger implements Acknowledger{
    private Drone drone;
    private GameMap map;
    private Reader reader;

    public ScanAcknowledger(Drone drone, GameMap map, Reader reader) {
        this.drone = drone;
        this.map = map;
        this.reader = reader;
    }

    public void acknowledgeResults() {

        drone.updateBattery(reader.getCost());

        boolean isGround = reader.isGround();
        List<String> creeks = reader.getCreeks();
        boolean isSite = reader.isSite();
        List<String> biomes = reader.getBiomes();
        

        Tile tile = new Tile(isSite, creeks, isGround, biomes);
        Position drone_position = new Position(drone.getLocation().getX(), drone.getLocation().getY());
        map.putTile(drone_position, tile);

    }

}
