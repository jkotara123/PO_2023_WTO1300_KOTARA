package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final Vector2d worldUpperRight=new Vector2d(5,5);
    protected final Vector2d worldLowerLeft=new Vector2d(0,0);
    protected MapVisualizer map = new MapVisualizer(this);

    public void move(Animal animal, MoveDirection direction) {
        if(objectAt(animal.getPosition())==animal){
            this.animals.remove(animal.getPosition());
            animal.move(direction,this);
            this.place(animal);
        }
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public String toString() {
        return map.draw(worldLowerLeft,worldUpperRight);
    }
}
