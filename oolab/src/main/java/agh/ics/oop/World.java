package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;

public class World {
    public static void runOld (MoveDirection[] args) {
        for (MoveDirection direction : args){
            switch (direction){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case BACKWARD -> System.out.println("Zwierezak idzie do tyłu");
            }
        }
    }
    public static void run (ArrayList<MoveDirection> args){
        for (MoveDirection arg : args) {
            switch (arg) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case BACKWARD -> System.out.println("Zwierezak idzie do tyłu");
            }
        }
    }
    public static void main(String[] args){
        run(OptionsParser.change(args));
        Animal smakus = new Animal();
        System.out.println(smakus);
        System.out.println(smakus.isAt(new Vector2d(4,2)));
        smakus.move(MoveDirection.RIGHT);
        System.out.println(smakus);
        smakus.move(MoveDirection.BACKWARD);
        System.out.println(smakus);
    }


}
