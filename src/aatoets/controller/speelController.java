package aatoets.controller;

import aatoets.data.OptieClass;
import aatoets.data.ToetsClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class speelController extends Controller implements Initializable {
    public Label naamLabel;
    public ToetsClass tc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamLabel.setText(OptieClass.getNaam());
        tc = new ToetsClass();
    }

    public void genereerVraag(ActionEvent actionEvent) {
        tc.genereerVraag();
    }
}
