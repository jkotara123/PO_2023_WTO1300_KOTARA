package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap implements WorldMap {
    public RectangularMap(int width,int height){
        super(width, height);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(worldLowerLeft) && position.precedes(worldUpperRight);
    }

}
