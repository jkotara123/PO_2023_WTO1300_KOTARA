package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements WorldMap{

    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final Vector2d grassUpperRight;
    private final Vector2d grassLowerLeft;
    private static final Vector2d LOWER_LEFT_MIN=new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    private static final Vector2d UPPER_RIGHT_MAX=new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);

    public GrassField(int n){
        this(n,new Random());
    }
    public GrassField(int n,Random seed){
        worldUpperRight= new Vector2d(0, 0); // to tylko wstepne wartosci
        worldLowerLeft= new Vector2d((int) (sqrt(n * 10)), (int) (sqrt(n * 10)));

        RandomPositionsGenerator randomPositionsGenerator = new RandomPositionsGenerator(worldLowerLeft.getX(),worldLowerLeft.getY(),n,seed);
        for(Vector2d grassPosition : randomPositionsGenerator){
            grasses.put(grassPosition,new Grass(grassPosition));
            worldLowerLeft=worldLowerLeft.lowerLeft(grassPosition);
            worldUpperRight=worldUpperRight.upperRight(grassPosition);
        }
        grassUpperRight = worldUpperRight;
        grassLowerLeft = worldLowerLeft;
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
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(LOWER_LEFT_MIN) && position.precedes(UPPER_RIGHT_MAX);
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> values = new ArrayList<>(super.getElements());
        values.addAll(grasses.values());
        return values;
    }
}
