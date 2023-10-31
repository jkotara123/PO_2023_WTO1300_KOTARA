package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
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
        Simulation simulation1 = new Simulation(directions1,positions1);

        String[] args2 = {"f","f","b","l","r","r","b","b","r"};
        ArrayList<MoveDirection> directions2 = OptionsParser.change(args2);
        ArrayList<Vector2d> positions2 = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(3,4),new Vector2d(4,4)));
        Simulation simulation2 = new Simulation(directions2,positions2);


        simulation1.run();
        ArrayList<Animal> animalList1 = simulation1.getAnimalList();
        Assertions.assertTrue(animalList1.get(0).isAt(new Vector2d(3,0)));
        Assertions.assertEquals(animalList1.get(0).getOrientation(), MapDirection.SOUTH);
        Assertions.assertTrue(animalList1.get(1).isAt(new Vector2d(2,4)));
        Assertions.assertEquals(animalList1.get(1).getOrientation(),MapDirection.NORTH);

        simulation2.run();
        ArrayList<Animal> animalList2 = simulation2.getAnimalList();
        Assertions.assertTrue(animalList2.get(0).isAt(new Vector2d(3,3)));
        Assertions.assertEquals(animalList2.get(0).getOrientation(),MapDirection.WEST);
        Assertions.assertTrue(animalList2.get(1).isAt(new Vector2d(2,4)));
        Assertions.assertEquals(animalList2.get(1).getOrientation(),MapDirection.EAST);
        Assertions.assertTrue(animalList2.get(2).isAt(new Vector2d(4,3)));
        Assertions.assertEquals(animalList2.get(2).getOrientation(),MapDirection.SOUTH);
    }
}
