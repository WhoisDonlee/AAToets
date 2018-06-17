package aatoets.controller;

import aatoets.data.OptieClass;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class optieController extends Controller implements Initializable {

    private String[] comboBoxList = {"Volledige Naam", "1 lettercode",
                             "3 lettercode", "Hydrofobiciteit",
                             "Lading", "Grootte",
                             "3D Voorkeur", "Structuur"};
    private int vragenlijstTrue = 0;
    private int antwoordenlijstTrue = 0;

    @FXML
    Button speelButton;
    @FXML
    TextField naamTextField;
    @FXML
    GridPane checkBoxGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamTextFieldChangeListener();
        createCheckboxes(0);
        createCheckboxes(1);
    }

    private void createCheckboxes(int col) {
        for (int i = 0; i < comboBoxList.length; i++) {
            CheckBox cb;
            checkBoxGrid.add(cb = new CheckBox(comboBoxList[i]), col ,i+1);
            cb.setId("cb" + i);
            cb.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
                if (col == 0) {
                    vragenlijstTrue += t1 ? +1 : -1;
                } else if (col == 1) {
                    antwoordenlijstTrue += t1 ? +1 : -1;
                }
                enableSpeelButton();
            });

        }
    }

    private void enableSpeelButton() {
        if ((vragenlijstTrue == 0) || (antwoordenlijstTrue == 0) || (naamTextField.getText().equals(""))) {
            speelButton.setDisable(true);
        } else {
           speelButton.setDisable(false);
        }
    }

    private void slaOptiesOp() {
        OptieClass.setNaam(naamTextField.getText());
    }

    private void naamTextFieldChangeListener() {
        naamTextField.textProperty().addListener((observableValue, s, t1) -> enableSpeelButton());
    }

    public void loadSpeelScene(ActionEvent actionEvent) throws IOException {
        slaOptiesOp();
//        screenManager.loadStage(rootPane, "/aatoets/view/speelScene.fxml");
    }

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }


}
