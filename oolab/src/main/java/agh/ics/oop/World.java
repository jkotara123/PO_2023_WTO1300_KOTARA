package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static final Vector2d WORLD_LOWER_LEFT = new Vector2d(0,0);
    public static final  Vector2d WORLD_UPPER_RIGHT = new Vector2d(4,4);
    public static void main(String[] args){
        ArrayList<MoveDirection> directions = OptionsParser.change(args);
        ArrayList<Vector2d> positions = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4)));
        Simulation simulation = new Simulation(directions,positions);
        simulation.run();
    }
}
