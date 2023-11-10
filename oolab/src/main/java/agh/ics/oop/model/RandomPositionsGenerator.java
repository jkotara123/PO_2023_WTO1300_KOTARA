package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collections;

public class RandomPositionsGenerator {
    private final ArrayList<Vector2d> points = new ArrayList<>(0);
    public RandomPositionsGenerator(int maxWidth, int maxHeight, int grassCount){
        ArrayList<Vector2d> allPoints = new ArrayList<>((maxHeight+1)*(maxWidth+1));
        for(int i=0;i<=maxHeight;i++){
            for(int j=0;j<=maxWidth;j++){
                allPoints.add(new Vector2d(i,j));
            }
        }
        Collections.shuffle(allPoints);
        for(int i=0;i<grassCount;i++){
            points.add(allPoints.get(i));
        }
    }
    public Vector2d getPoint(int i) {
        return points.get(i);
    }
}
