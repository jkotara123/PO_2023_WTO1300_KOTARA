package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static final Vector2d WORLD_LOWER_LEFT = new Vector2d(0,0);
    public static final  Vector2d WORLD_UPPER_RIGHT = new Vector2d(4,4);
    public static void main(String[] args){
        RectangularMap map= new RectangularMap(5,5);
        ArrayList<Vector2d> positions = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4)));
        Simulation simulation = new Simulation(OptionsParser.change(args),positions,map);

        simulation.run();
    }
}
