package aatoets.controller;

import aatoets.data.OptieClass;
import aatoets.data.ToetsClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class speelController extends Controller implements Initializable {
    public Label naamLabel;
    private ToetsClass tc;
    private ArrayList<String[]> toets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamLabel.setText(OptieClass.getNaam());
        tc = new ToetsClass();
        toets = tc.genereerToets();
        for (String[] s : toets) {
            for (String ss : s) {
                System.out.println(ss);
            }
        }
    }

    public void volgendeVraag(ActionEvent actionEvent) {
    }
}
