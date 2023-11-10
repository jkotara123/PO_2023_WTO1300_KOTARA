package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.sqrt;

public class GrassField implements WorldMap{

    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private Vector2d worldUpperRight;
    private Vector2d worldLowerLeft;
    private final MapVisualizer map = new MapVisualizer(this);

    public GrassField(int n){
        Vector2d grassUpperRight = new Vector2d((int) (sqrt(n * 10)), (int) (sqrt(n * 10)));

        worldUpperRight= new Vector2d(0, 0); // to tylko wstepne wartosci
        worldLowerLeft= grassUpperRight;

        RandomPositionsGenerator randomPositions = new RandomPositionsGenerator(grassUpperRight.getX(), grassUpperRight.getY(),n);
        for(int i=0;i<n;i++){
            Vector2d grassPosition=randomPositions.getPoint(i);
            grasses.put(grassPosition,new Grass(grassPosition));
            worldLowerLeft=worldLowerLeft.lowerLeft(grassPosition);
            worldUpperRight=worldUpperRight.upperRight(grassPosition);
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            worldUpperRight=worldUpperRight.upperRight(animal.getPosition());
            worldLowerLeft=worldLowerLeft.lowerLeft(animal.getPosition());
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
            worldUpperRight=worldUpperRight.upperRight(animal.getPosition());
            worldLowerLeft=worldLowerLeft.lowerLeft(animal.getPosition());
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        Animal animal = animals.get(position);
        if(animal == null){
            return grasses.get(position);
        }
        return animal;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public String toString() {
        return map.draw(worldLowerLeft,worldUpperRight);
    }
}
