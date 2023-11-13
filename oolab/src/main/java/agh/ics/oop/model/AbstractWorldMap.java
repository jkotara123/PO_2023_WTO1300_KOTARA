package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d worldUpperRight;
    protected Vector2d worldLowerLeft;
    protected MapVisualizer map = new MapVisualizer(this);

    public AbstractWorldMap(int width,int height){
        worldUpperRight=new Vector2d(width-1,height-1);
        worldLowerLeft=new Vector2d(0,0);
    }
    public AbstractWorldMap(){
        this(5,5);
    }
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
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    @Override
    public String toString() {
        return map.draw(worldLowerLeft,worldUpperRight);
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
}
