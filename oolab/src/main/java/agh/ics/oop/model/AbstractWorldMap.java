package agh.ics.oop.model;

import agh.ics.oop.model.enums.MoveDirection;
import agh.ics.oop.model.exceptions.IllegalPositionException;
import agh.ics.oop.model.interfaces.MapChangeListener;
import agh.ics.oop.model.interfaces.Observable;
import agh.ics.oop.model.interfaces.WorldElement;
import agh.ics.oop.model.interfaces.WorldMap;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap, Observable {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer map = new MapVisualizer(this);
    protected final ArrayList<MapChangeListener> observers = new ArrayList<>();

    public void addObserver(MapChangeListener observer){
        observers.add(observer);
    }
    public void removeObserver(MapChangeListener observer){
        observers.remove(observer);
    }
    public void emitMessage(String message){
        for(MapChangeListener observer : observers){
            observer.mapChanged(this,message);
        }
    }
    public void move(Animal animal, MoveDirection direction){
        if(objectAt(animal.getPosition())==animal){
            Vector2d oldPosition = animal.getPosition();
            this.animals.remove(animal.getPosition());
            animal.move(direction,this);
            this.animals.put(animal.getPosition(),animal);

            switch (direction){
                case FORWARD -> {if(oldPosition != animal.getPosition()) emitMessage("Zwierzak "+animal+" ruszył do przodu");}
                case BACKWARD -> {if(oldPosition != animal.getPosition()) emitMessage("Zwierzak "+animal+" ruszył do tyłu");}
                case RIGHT -> emitMessage("Zwierzak "+animal+" obrócił się w prawo");
                case LEFT -> emitMessage("Zwierzak "+animal+" obrócił się w lewo");
            }
        }
    }
    public void place(Animal animal) throws IllegalPositionException{
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            emitMessage("Zwierzak dodany na pozycję "+animal.getPosition());
        }
        else{
            throw new IllegalPositionException(animal.getPosition());
        }
    }
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }
    @Override
    public ArrayList<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
    @Override
    public abstract Boundary getCurrentBounds();
    @Override
    public String toString() {
        return map.draw(this.getCurrentBounds().lowerLeft(), this.getCurrentBounds().upperRight());
    }
}