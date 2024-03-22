package ca.mcmaster.se2aa4.island.team118.Acknowledgers;

import java.util.List;

import ca.mcmaster.se2aa4.island.team118.Direction;
import ca.mcmaster.se2aa4.island.team118.Drone;
import ca.mcmaster.se2aa4.island.team118.GameMap;
import ca.mcmaster.se2aa4.island.team118.Position;
import ca.mcmaster.se2aa4.island.team118.Reader;
import ca.mcmaster.se2aa4.island.team118.Tile;

public class EchoAcknowledger implements Acknowledger{

    private Drone drone;
    private GameMap map;
    private Reader reader;
    private Direction echo_direction;

    public EchoAcknowledger(Drone drone, GameMap map, Reader reader) {
        this.drone = drone;
        this.map = map;
        this.echo_direction = reader.getDirection();
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
        drone_position.move(reader.range(), echo_direction);
        map.putTile(drone_position, tile);

    }

}
