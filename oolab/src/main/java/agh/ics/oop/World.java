package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.ConsoleMapDisplay;
import agh.ics.oop.model.util.OptionsParser;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        try {
            ConsoleMapDisplay observer = new ConsoleMapDisplay();
            String[] args1 = {"f","b","r","l","f","f","r","r","backward","f","left","left","f","f","f","f"};
            ArrayList<Vector2d> positions1 = new ArrayList<>(List.of(new Vector2d(7, 8), new Vector2d(3, 4),new Vector2d(2,8)));
            GrassField map1 = new GrassField(7,1);
            map1.addObserver(observer);
            Simulation simulation1 = new Simulation(OptionsParser.change(args1), positions1, map1);
    
            String[] args2 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            ArrayList<Vector2d> positions2 = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4)));
            RectangularMap map2 = new RectangularMap(5,5,2);
            map2.addObserver(observer);
            Simulation simulation2 = new Simulation(OptionsParser.change(args2),positions2,map2);

            SimulationEngine simulationEngine = new SimulationEngine(new ArrayList<>(List.of(simulation1,simulation2)),4);

            simulationEngine.runAsyncInThreadPool();


            System.out.print("System zakonczyl dzialanie");
        }
        catch (IllegalArgumentException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
