package aatoets.controller;

import aatoets.data.OptieClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class resultaatController extends Controller implements Initializable {

    public Label naamLabel;
    public Label scoreLabel;

    public void loadStartScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamLabel.setText(OptieClass.getNaam());
        scoreLabel.setText("30/50!");
    }
}
