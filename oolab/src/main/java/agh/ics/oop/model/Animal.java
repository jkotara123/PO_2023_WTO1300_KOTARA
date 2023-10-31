package agh.ics.oop.model;

import agh.ics.oop.World;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(Vector2d position){
        this.position=position;
        this.orientation=MapDirection.NORTH;
    }
    public Animal(){
        this(new Vector2d(2,2));
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }
    public MapDirection getOrientation() {
        return this.orientation;
    }

    @Override
    public String toString(){
        return "Pozycja: "+this.position+" Zwrot: "+this.orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public boolean canMoveTo(Vector2d newPosition){
        return newPosition.follows(World.WORLD_LOWER_LEFT) && newPosition.precedes(World.WORLD_UPPER_RIGHT);
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT ->  this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (this.canMoveTo(newPosition))    this.position=newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (this.canMoveTo(newPosition))    this.position=newPosition;
            }
        }
    }
}
