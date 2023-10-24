package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class OptionsParserTest {
    @Test
    public void TestOptionsParser(){
        String[] args = {"f","rl","b","r","a","l"};
        MoveDirection[] resExpected = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        MoveDirection[] res = OptionsParser.change(args);
        assertArrayEquals(resExpected,res);
    }
}
