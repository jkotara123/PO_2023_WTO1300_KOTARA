package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap implements WorldMap {
    private final Vector2d worldUpperRight;
    private final Vector2d worldLowerLeft;
    public RectangularMap(int width,int height){
        worldLowerLeft=new Vector2d(0,0);
        worldUpperRight=new Vector2d(width-1,height-1);
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
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.follows(worldLowerLeft) && position.precedes(worldUpperRight);
    }
}
