package aatoets.controller;

import aatoets.data.OptieClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class optieController extends Controller implements Initializable {

    private String[] checkBoxList = {"Volledige Naam", "1 lettercode",
                             "3 lettercode", "Hydrofobiciteit",
                             "Lading", "Grootte",
                             "3D Voorkeur", "Structuur"};
    private ArrayList<String> soortVragenLijst = new ArrayList<>();
    private ArrayList<String> soortAntwoordenLijst = new ArrayList<>();

    @FXML
    Button speelButton;
    @FXML
    ToggleGroup aantalVragen;
    @FXML
    ToggleGroup aantalSeconden;
    @FXML
    TextField naamTextField;
    @FXML
    CheckBox tijdCheckBox;
    @FXML
    GridPane checkBoxGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tijdCheckBoxListener();
        naamTextFieldChangeListener();
        createCheckboxes(0);
        createCheckboxes(1);
    }

    /*
    * Loop door checkBoxList
    * Plaatst de checkboxen voor soorten vragen/antwoorden met eventlistener
    * */
    private void createCheckboxes(int col) {
        for (int i = 0; i < checkBoxList.length; i++) {
            CheckBox cb;
            checkBoxGrid.add(cb = new CheckBox(checkBoxList[i]), col ,i+1);
            cb.setId("cb" + i);
            int finalI = i;
            cb.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
                if (t1) {
                    (col == 0 ? soortVragenLijst : soortAntwoordenLijst).add(checkBoxList[finalI]);
                } else {
                    (col == 0 ? soortVragenLijst : soortAntwoordenLijst).remove(checkBoxList[finalI]);
                }
                enableSpeelButton();
            });

        }
    }

    /*
    * Checkt of alle waarden voldoen om de speelbutten te enablen
    * */
    private void enableSpeelButton() {
        if ((soortVragenLijst.isEmpty()) || (soortAntwoordenLijst.isEmpty()) || (naamTextField.getText().equals(""))) {
            speelButton.setDisable(true);
        } else {
           speelButton.setDisable(false);
        }
    }

    private void enableTijdbuttons() {
        Boolean disable = !tijdCheckBox.isSelected();
        for (Toggle t : aantalSeconden.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setDisable(disable);
            }
        }
    }

    private void slaOptiesOp() {
        OptieClass.setNaam(naamTextField.getText());
        OptieClass.setAantalVragen(getAantalVragen());
        OptieClass.setSoortVragen(soortVragenLijst);
        OptieClass.setSoortAntwoorden(soortAntwoordenLijst);
        OptieClass.setTijd(tijdCheckBox.isSelected());
        OptieClass.setAantalSeconden(getAantalSeconden());
    }

    private int getAantalVragen() {
        RadioButton rb = (RadioButton)aantalVragen.getSelectedToggle();
        return Integer.parseInt(rb.getText());
    }

    private int getAantalSeconden() {
        RadioButton rb = (RadioButton)aantalSeconden.getSelectedToggle();
        return Integer.parseInt(rb.getText());
    }

    private void tijdCheckBoxListener (){
        tijdCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> enableTijdbuttons());
    }

    private void naamTextFieldChangeListener() {
        naamTextField.textProperty().addListener((observableValue, s, t1) -> enableSpeelButton());
    }

    public void loadSpeelScene(ActionEvent actionEvent) throws IOException {
        slaOptiesOp();
        screenManager.loadStage(rootPane, "/aatoets/view/speelScene.fxml");
    }

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }


}
