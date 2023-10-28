package agh.ics.oop.model;

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
    @Override
    public String toString(){
        return "Pozycja: "+this.position+" Orientacja: "+this.orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction){
            case LEFT ->  this.orientation=this.orientation.previous();
            case RIGHT -> this.orientation=this.orientation.next();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4))) this.position=newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4))) this.position=newPosition;
            }
        }
    }


}
