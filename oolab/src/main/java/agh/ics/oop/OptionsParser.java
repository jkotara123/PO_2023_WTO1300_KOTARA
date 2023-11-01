package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;

public class OptionsParser {
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
