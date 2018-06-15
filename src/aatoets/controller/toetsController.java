package aatoets.controller;

import aatoets.data.OptieClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class toetsController extends Controller {
    @FXML
    ToggleGroup aantal;


    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void genereerToets(ActionEvent actionEvent) {
        RadioButton selectedRadionbutton = (RadioButton) aantal.getSelectedToggle();
        String toggleGroupValue = selectedRadionbutton.getText();
    }

    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }
}
