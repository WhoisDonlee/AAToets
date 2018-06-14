package aatoets.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ScreenManager {

    void loadStage(GridPane rootPane, String sceneName) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource(sceneName));
        rootPane.getChildren().setAll(pane);
    }
}
