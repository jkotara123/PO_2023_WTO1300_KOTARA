package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;


public class Simulation {
    private final ArrayList<MoveDirection> moveList;
    private final ArrayList<Animal> animalList = new ArrayList<>(0);
    private final RectangularMap map;
    public Simulation(ArrayList<MoveDirection> moveList, ArrayList<Vector2d> positionList,RectangularMap map){
        this.moveList=moveList;
        this.map=map;
        for(Vector2d position : positionList) {
            Animal animal = new Animal(position);
            if (this.map.place(animal)) {
                this.animalList.add(animal);
            }
        }

        System.out.println(this.map);
        System.out.println("start...\n\n");
    }
    public Animal getAnimal(int i) {
        assert i>=0 && i<animalList.size();
        return animalList.get(i);
    }
    public void run(){
        for(int i=0;i < moveList.size();i++){
            this.map.move(this.getAnimal(i%animalList.size()),moveList.get(i));
            System.out.println("Zwierzak "+i%animalList.size()+": "+this.getAnimal(i%animalList.size()));
            System.out.println(this.map);
        }
    }
}
