package agh.ics.oop.model.interfaces;

import java.util.Observer;

public interface Observable {
    void addObserver(MapChangeListener observer);
    void removeObserver(MapChangeListener observer);
    void emitMessage(String message);
}
