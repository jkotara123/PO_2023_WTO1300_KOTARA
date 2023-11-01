package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;

public class Simulation {
    private final ArrayList<MoveDirection> moveList;
    private final ArrayList<Animal> animalList = new ArrayList<>(0);
    public Simulation(ArrayList<MoveDirection> moveList, ArrayList<Vector2d> positionList){
        this.moveList=moveList;
        for(Vector2d position : positionList) {
            Animal animal = new Animal(position);
            this.animalList.add(animal);
//            System.out.println("Zwierzak "+animalCount+": "+animal);
        }
    }
    public Animal getAnimal(int i) {
        assert i>=0 && i<animalList.size();
        return animalList.get(i);
    }
    public void run(){
        for(int i=0;i < moveList.size();i++){
            this.getAnimal(i%animalList.size()).move(moveList.get(i));
            System.out.println("Zwierzak "+i%animalList.size()+": "+this.getAnimal(i%animalList.size()));
        }
    }



}
