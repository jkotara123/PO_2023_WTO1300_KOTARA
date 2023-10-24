package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import agh.ics.oop.model.MoveDirection;
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
