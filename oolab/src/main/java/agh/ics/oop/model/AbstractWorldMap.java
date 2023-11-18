package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer map = new MapVisualizer(this);

    public void move(Animal animal, MoveDirection direction) {
        if(objectAt(animal.getPosition())==animal){
            this.animals.remove(animal.getPosition());
            animal.move(direction,this);
            this.place(animal);
        }
    }

    public Vector2d getWorldUpperRight() {return new Vector2d(5,5);}
    public Vector2d getWorldLowerLeft(){return new Vector2d(0,0);}

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
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    @Override
    public String toString() {
        return map.draw(this.getWorldLowerLeft(),this.getWorldUpperRight());
    }
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
}