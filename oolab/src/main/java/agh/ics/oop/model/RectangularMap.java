package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Vector2d worldUpperRight;
    private final Vector2d worldLowerLeft;
    private final MapVisualizer map = new MapVisualizer(this);
    public RectangularMap(int width,int height){
        worldUpperRight=new Vector2d(width-1,height-1);
        worldLowerLeft=new Vector2d(0,0);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(objectAt(animal.getPosition())==animal){
            this.animals.remove(animal.getPosition());
            animal.move(direction,this);
            this.place(animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(worldLowerLeft) && position.precedes(worldUpperRight);
    }

    @Override
    public String toString() {
        return map.draw(worldLowerLeft,worldUpperRight);
    }
}
