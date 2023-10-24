package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void Testnext(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        assertEquals(east, north.next() );
        assertEquals(south, east.next() );
        assertEquals(west, south.next() );
        assertEquals(north, west.next() );
    }
    @Test
    public void Testprevious(){

        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        assertEquals(east, south.previous() );
        assertEquals(south, west.previous() );
        assertEquals(west, north.previous() );
        assertEquals(north, east.previous() );
    }
}
