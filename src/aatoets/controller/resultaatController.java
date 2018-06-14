package aatoets.controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class resultaatController extends Controller {
    public void loadOpties(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/optieScene.fxml");
    }

}
