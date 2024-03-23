package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import java.util.List;

import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.GameMap;
import ca.mcmaster.se2aa4.island.team118.Position;
import ca.mcmaster.se2aa4.island.team118.Tile;
import ca.mcmaster.se2aa4.island.team118.Readers.Reader;

public class EchoAcknowledger implements Acknowledger{

    private Drone drone;
    private GameMap map;

    public EchoAcknowledger(Drone drone, GameMap map) {
        this.drone = drone;
        this.map = map;
    }

    /**
    Acknowledge the results of 'echo' action based on the contents
    of the 'reader' object. Updates the drones battery, adds
    a new tile to the map at the echo location.

    @param  reader   the reader object which contains necessary
                     information from the response
    */
    public void acknowledgeResults(Reader reader) {

        drone.updateBattery(reader.getCost());

        boolean isGround = reader.isGround();
        List<String> creeks = reader.getCreeks();
        boolean isSite = reader.isSite();
        List<String> biomes = reader.getBiomes();
        

        Direction echoDirection = reader.getDirection();
        Tile tile = new Tile(isSite, creeks, isGround, biomes);
        Position dronePosition = new Position(drone.getLocation().getX(), drone.getLocation().getY());
        dronePosition.move(reader.getRange(), echoDirection);
        map.putTile(dronePosition, tile);

    }

}
