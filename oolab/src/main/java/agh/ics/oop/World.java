package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    /*
    public static void run1(String[] args) {
        int n = args.length;
        for(int i=0;i<n-1;i++) System.out.print(args[i]+", ");
        System.out.println(args[n-1]);
    }
    public static void run2(String[] args){
        for(String arg : args){
            if (arg.equals("f")) System.out.println("Zwierzak idzie do przodu");
            if (arg.equals("b")) System.out.println("Zwierzak idzie do tyłu");
            if (arg.equals("l")) System.out.println("Zwierzak skręca w lewo");
            if (arg.equals("r")) System.out.println("Zwierzak skręca w prawo");
        }
    }
    */
    public static void run (MoveDirection[] args) {
        for (MoveDirection direction : args){
            switch (direction){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case BACKWARD -> System.out.println("Zwierezak idzie do tyłu");
            }
        }
    }
    public static void main(String[] args){
        System.out.println("system wystartował\n");
        run(OptionsParser.change(args));
//        run1(args);
//        run2(args);
        System.out.println("\nsystem zakończył działanie");
    }


}
