package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class OptionsParserTest {
    @Test
    public void TestOptionsParser(){
        String[] args = {"f","rl","b","r","a","l"};
        MoveDirection[] resExpectedTab = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        ArrayList<MoveDirection> resExpected = new ArrayList<MoveDirection>(List.of(resExpectedTab));
        ArrayList<MoveDirection> res = OptionsParser.change(args);
        assertEquals(res, resExpected);
    }
}
