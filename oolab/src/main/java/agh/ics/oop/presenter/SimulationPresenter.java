package agh.ics.oop.presenter;

import agh.ics.oop.model.interfaces.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimulationPresenter {
    private WorldMap map;
    @FXML
    private Label infoLabel;
    public void setWorldMap(WorldMap map){
        this.map=map;
    }
    public void draw(){

    }
}
