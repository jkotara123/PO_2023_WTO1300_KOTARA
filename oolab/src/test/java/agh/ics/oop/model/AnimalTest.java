package agh.ics.oop.model;

import agh.ics.oop.World;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void TestToString(){
        Animal animalDefault = new Animal();
        Animal animal1 = new Animal(new Vector2d(2,5));
        animal1.setOrientation(MapDirection.WEST);
        Animal animal2 = new Animal(new Vector2d(1,0));
        animal2.setOrientation(MapDirection.SOUTH);

        String resDefault = "Pozycja: (2,2) Zwrot: Północ";
        String res1 = "Pozycja: (2,5) Zwrot: Zachód";
        String res2 = "Pozycja: (1,0) Zwrot: Południe";

        Assertions.assertEquals(resDefault,animalDefault.toString());
        Assertions.assertEquals(res1,animal1.toString());
        Assertions.assertEquals(res2,animal2.toString());
    }
    @Test
    public void TestIsAt(){
        Animal animalDefault = new Animal();
        Animal animal1 = new Animal(new Vector2d(2,5));
        Animal animal2 = new Animal(new Vector2d(1,0));

        Vector2d positionDefault = new Vector2d(2,2);
        Vector2d position1 = new Vector2d(2,5);
        Vector2d position2 = new Vector2d(1,0);

        Assertions.assertTrue(animalDefault.isAt(positionDefault));
        Assertions.assertTrue(animal1.isAt(position1));
        Assertions.assertTrue(animal2.isAt(position2));

        Assertions.assertFalse(animalDefault.isAt(position1));
        Assertions.assertFalse(animal1.isAt(position2));
        Assertions.assertFalse(animal2.isAt(positionDefault));
    }
    @Test
    public void TestCanMoveTo(){
        Animal animal = new Animal();
        Vector2d okayPosition1 = new Vector2d(3,4);
        Vector2d okayPosition2 = new Vector2d(2,2);
        Vector2d wrongPosition1 = new Vector2d(0,-1);
        Vector2d wrongPosition2 = new Vector2d(-3,-2);
        Vector2d wrongPosition3 = new Vector2d(4,6);
        Vector2d wrongPosition4 = new Vector2d(9,4);

        Assertions.assertTrue(animal.canMoveTo(okayPosition1));
        Assertions.assertTrue(animal.canMoveTo(okayPosition2));
        Assertions.assertTrue(animal.canMoveTo(World.WORLD_LOWER_LEFT));
        Assertions.assertTrue(animal.canMoveTo(World.WORLD_UPPER_RIGHT));

        Assertions.assertFalse(animal.canMoveTo(wrongPosition1));
        Assertions.assertFalse(animal.canMoveTo(wrongPosition2));
        Assertions.assertFalse(animal.canMoveTo(wrongPosition3));
        Assertions.assertFalse(animal.canMoveTo(wrongPosition4));
    }
    @Test
    public void TestMove(){
        Animal animalTurn = new Animal();
        Animal animalCannotGoForward=new Animal(new Vector2d(3,4));
        Animal animalGoForward1=new Animal();
        Animal animalGoForward2=new Animal();
        animalGoForward2.setOrientation(MapDirection.WEST);
        Animal animalGoBackward1=new Animal();
        Animal animalGoBackward2 = new Animal();
        animalGoBackward2.setOrientation(MapDirection.EAST);
        {
            animalTurn.move(MoveDirection.RIGHT);                                   //skrecanie w prawo
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.EAST);
            animalTurn.move(MoveDirection.RIGHT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.SOUTH);
            animalTurn.move(MoveDirection.RIGHT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.WEST);
            animalTurn.move(MoveDirection.RIGHT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.NORTH);

            animalTurn.move(MoveDirection.LEFT);                                     //skrecanie w lewo
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.WEST);
            animalTurn.move(MoveDirection.LEFT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.SOUTH);
            animalTurn.move(MoveDirection.LEFT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.EAST);
            animalTurn.move(MoveDirection.LEFT);
            Assertions.assertEquals(animalTurn.getOrientation(), MapDirection.NORTH);
        }
        animalCannotGoForward.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalCannotGoForward.isAt(new Vector2d(3,4)));

        animalGoForward1.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalGoForward1.isAt(new Vector2d(2,3)));

        animalGoForward2.move(MoveDirection.FORWARD);
        Assertions.assertTrue(animalGoForward2.isAt(new Vector2d(1,2)));

        animalGoBackward1.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animalGoBackward1.isAt(new Vector2d(2,1)));

        animalGoBackward2.move(MoveDirection.BACKWARD);
        Assertions.assertTrue(animalGoBackward2.isAt(new Vector2d(1,2)));
    }
}
