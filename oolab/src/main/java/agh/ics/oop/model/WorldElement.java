package agh.ics.oop.model;

public interface WorldElement {
    Vector2d getPosition();
    @Override
    String toString();
    boolean isAt(Vector2d position);
}
