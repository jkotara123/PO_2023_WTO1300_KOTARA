package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] changeOld(String[] args){
        int new_size=0;
        MoveDirection[] res;
        for(String argument : args){
            if(argument.equals("f")) new_size++;
            if(argument.equals("r")) new_size++;
            if(argument.equals("l")) new_size++;
            if(argument.equals("b")) new_size++;
        }
        res = new MoveDirection[new_size];
        int current_index=0;
        for(String argument : args){
            if(argument.equals("f")) {
                res[current_index]=MoveDirection.FORWARD;
                current_index++;
            }
            if(argument.equals("r")) {
                res[current_index]=MoveDirection.RIGHT;
                current_index++;
            }
            if(argument.equals("l")) {
                res[current_index]=MoveDirection.LEFT;
                current_index++;
            }
            if(argument.equals("b")) {
                res[current_index]=MoveDirection.BACKWARD;
                current_index++;
            }
        }
        return res;
    }
    public static ArrayList<MoveDirection> change(String[] args){
        ArrayList<MoveDirection> res = new ArrayList<>(0);
        for(String argument : args){
            if(argument.equals("f"))    res.add(MoveDirection.FORWARD);
            else if(argument.equals("r"))   res.add(MoveDirection.RIGHT);
            else if(argument.equals("l"))   res.add(MoveDirection.LEFT);
            else if(argument.equals("b"))   res.add(MoveDirection.BACKWARD);
        }
        return res;
    }
}
