package agh.ics.oop;

import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.ConsoleMapDisplay;
import agh.ics.oop.model.util.OptionsParser;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ConsoleMapDisplay observer = new ConsoleMapDisplay();
        String[] args1 = {"f","b","r","l","f","f","r","r","backward","f","left","left","f","f","f","f"};
        ArrayList<Vector2d> positions1 = new ArrayList<>(List.of(new Vector2d(7, 8), new Vector2d(3, 4),new Vector2d(2,8)));
        GrassField map1 = new GrassField(7,1);
        map1.addObserver(observer);
        Simulation simulation1 = new Simulation(OptionsParser.change(args1), positions1, map1);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        presenter.setWorldMap(map1);
        configureStage(primaryStage,viewRoot);
        primaryStage.show();
    }
    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
