package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements WorldMap{

    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    private Vector2d worldUpperRight;
    private Vector2d worldLowerLeft;
    private final Vector2d grassUpperRight;
    private final Vector2d grassLowerLeft;
    public GrassField(int n){
        this(n,new Random());
    }
    public GrassField(int n,Random seed){
        worldUpperRight= new Vector2d(0, 0);
        worldLowerLeft= new Vector2d((int)(sqrt(n * 10)),(int) (sqrt(n * 10)));

        RandomPositionsGenerator randomPositionsGenerator = new RandomPositionsGenerator(worldLowerLeft.x(),worldLowerLeft.y(),n,seed);
        for(Vector2d grassPosition : randomPositionsGenerator){
            grasses.put(grassPosition,new Grass(grassPosition));
            worldLowerLeft=worldLowerLeft.lowerLeft(grassPosition);
            worldUpperRight=worldUpperRight.upperRight(grassPosition);
        }
        grassUpperRight = worldUpperRight;
        grassLowerLeft = worldLowerLeft;
    }
    @Override
    public Vector2d getWorldLowerLeft(){
        return worldLowerLeft;
    }
    @Override
    public Vector2d getWorldUpperRight(){
        return worldUpperRight;
    }
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            worldUpperRight = worldUpperRight.upperRight(animal.getPosition());
            worldLowerLeft = worldLowerLeft.lowerLeft(animal.getPosition());
        }
        return super.place(animal);
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal,direction);
        updateCorners();
    }
    public void updateCorners(){
        worldLowerLeft=grassLowerLeft;
        worldUpperRight=grassUpperRight;
        animals.forEach((key,value) -> {
            worldLowerLeft=worldLowerLeft.lowerLeft(key);
            worldUpperRight=worldUpperRight.upperRight(key);
        });
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) == null){
            return grasses.get(position);
        }
        return super.objectAt(position);
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> values = new ArrayList<>(super.getElements());
        values.addAll(grasses.values());
        return values;
    }
}
