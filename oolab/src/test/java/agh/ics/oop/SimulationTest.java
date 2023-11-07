package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulationTest {
    @Test
    public void TestRun(){
        String[] args1 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        ArrayList<MoveDirection> directions1 = OptionsParser.change(args1);
        ArrayList<Vector2d> positions1 = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4)));
        RectangularMap map1 = new RectangularMap(5,5);
        Simulation simulation1 = new Simulation(directions1,positions1,map1);

        String[] args2 = {"f","f","b","l","r","r","b","b","r"};
        ArrayList<MoveDirection> directions2 = OptionsParser.change(args2);
        ArrayList<Vector2d> positions2 = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4),new Vector2d(4,4)));
        RectangularMap map2 = new RectangularMap(5,5);
        Simulation simulation2 = new Simulation(directions2,positions2,map2);


        simulation1.run();
        Assertions.assertTrue(simulation1.getAnimal(0).isAt(new Vector2d(2,0)));
        Assertions.assertEquals(simulation1.getAnimal(0).getOrientation(), MapDirection.SOUTH);
        Assertions.assertTrue(simulation1.getAnimal(1).isAt(new Vector2d(3,4)));
        Assertions.assertEquals(simulation1.getAnimal(1).getOrientation(),MapDirection.NORTH);

        simulation2.run();
        Assertions.assertTrue(simulation2.getAnimal(0).isAt(new Vector2d(3,3)));
        Assertions.assertEquals(simulation2.getAnimal(0).getOrientation(),MapDirection.WEST);
        Assertions.assertTrue(simulation2.getAnimal(1).isAt(new Vector2d(2,4)));
        Assertions.assertEquals(simulation2.getAnimal(1).getOrientation(),MapDirection.EAST);
        Assertions.assertTrue(simulation2.getAnimal(2).isAt(new Vector2d(4,3)));
        Assertions.assertEquals(simulation2.getAnimal(2).getOrientation(),MapDirection.SOUTH);
    }
}
