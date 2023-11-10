package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        ArrayList<Vector2d> positions = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4)));
        GrassField map = new GrassField(10);
        Simulation simulation = new Simulation(OptionsParser.change(args),positions,map);
        simulation.run();
    }
}
