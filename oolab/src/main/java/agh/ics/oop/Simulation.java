package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;

public class Simulation {
    private final ArrayList<MoveDirection> moveList;
    private final ArrayList<Animal> animalList = new ArrayList<>(0);
    private int animalCount=0;
    public Simulation(ArrayList<MoveDirection> moveList, ArrayList<Vector2d> positionList){
        this.moveList=moveList;
        for(Vector2d position : positionList)
        {
            Animal animal = new Animal(position);
            this.animalList.add(animal);
//            System.out.println("Zwierzak "+animalCount+": "+animal);
            this.animalCount++;
        }
    }
    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
    public void run(){
        for(int i=0;i < moveList.size();i++){
            animalList.get(i%animalCount).move(moveList.get(i));
//            System.out.println(moveList.get(i));
            System.out.println("Zwierzak "+i%animalCount+": "+animalList.get(i%animalCount));
        }
    }



}
