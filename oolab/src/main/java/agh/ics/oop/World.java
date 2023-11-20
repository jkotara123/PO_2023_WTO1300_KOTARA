package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;
import agh.ics.oop.model.util.OptionsParser;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        ArrayList<Vector2d> positions = new ArrayList<>(List.of(new Vector2d(2,8), new Vector2d(3,4)));
        ConsoleMapDisplay mapDisplay = new ConsoleMapDisplay();
        GrassField map = new GrassField(9);
        map.addObserver(mapDisplay);

        Simulation simulation = new Simulation(OptionsParser.change(args),positions,map);
        simulation.run();
    }
}
