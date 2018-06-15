package aatoets.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class optieController extends Controller implements Initializable {

    String[] comboBoxList = {"Volledige Naam", "1 lettercode",
                             "3 lettercode", "Hydrofobiciteit",
                             "Lading", "Grootte",
                             "3D Voorkeur", "Structuur"};
    @FXML
    TextField naamTextField;
    @FXML
    GridPane checkBoxGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamTextFieldChangeListener();
        for (int i = 0; i < comboBoxList.length; i++) {
            CheckBox cb;
            checkBoxGrid.add(cb = new CheckBox(comboBoxList[i]),0 ,i+1);
            cb.setId("cb" + i);
            cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                    System.out.println(t1);
                }
            });

        }

    }

    private void onCheck(CheckBox cb) {
        System.out.println(cb.getId());
    }

    public void loadSpeelScene(ActionEvent actionEvent) throws IOException {
        System.out.println(getNaamTextField());
//        screenManager.loadStage(rootPane, "/aatoets/view/speelScene.fxml");
    }

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        System.out.println(getNaamTextField());
//        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
    }

    private void slaOptiesOp() {
       getNaamTextField();
    }

    private void naamTextFieldChangeListener() {
        naamTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(getNaamTextField());
            }
        });
    }

    private String getNaamTextField() {
       return naamTextField.getText();
    }

}
