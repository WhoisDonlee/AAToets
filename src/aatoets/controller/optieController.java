package aatoets.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class optieController extends Controller {

    @FXML private RadioButton rb;


    public void loadResultaat(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/resultaatScene.fxml");
    }

    public void loadSpeelScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/speelScene.fxml");
    }

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
    }
}
