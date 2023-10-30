package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class OptionsParserTest {
    @Test
    public void TestOptionsParser(){
        String[] args1 = {"f","rl","b","r","a","l"};
        String[] args2 = {"r","f","l","b","rr","ll"};

        ArrayList<MoveDirection> resExpected1 = new ArrayList<MoveDirection>(Arrays.asList(MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT));
        ArrayList<MoveDirection> resExpected2 = new ArrayList<MoveDirection>(Arrays.asList(MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD));

        assertEquals(resExpected1, OptionsParser.change(args1));
        assertEquals(resExpected2,OptionsParser.change(args2));
    }
}
