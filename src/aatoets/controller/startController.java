package aatoets.controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class startController extends Controller {

    public void loadToetsScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/toetsScene.fxml");
    }

    public void loadOptiesScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/optieScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }
}
