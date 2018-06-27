package aatoets.controller;

import aatoets.data.OptieClass;
import aatoets.data.ToetsClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.lang.management.OperatingSystemMXBean;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class speelController extends Controller implements Initializable {
    public Label naamLabel;
    public Label tijdLabel;
    public Label vraagLabel;
    public Button volgendeVraagButton;
    public ToggleGroup antwoordenToggleGroup;
    public GridPane antwoordGridPane;

    private int timerSeconds = OptieClass.getAantalSeconden();
    private ToetsClass tc;
    private ArrayList<String[]> toets;
    private int currentVraag = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamLabel.setText(OptieClass.getNaam());
        tc = new ToetsClass();
        toets = tc.genereerToets();
        tijdLabel.setText(String.valueOf(timerSeconds));
        timer();
        setVraagLabels(0);
    }

    private void setVraagLabels(int vraagNummer) {
        vraagLabel.setText(getVraag(vraagNummer)[0]);
        antwoordGridPane.getChildren().clear();
        for (int i = 1; i < getVraag(vraagNummer).length; i++) {
            RadioButton rb = new RadioButton(getVraag(vraagNummer)[i]);
            antwoordGridPane.add(rb, 0, i-1);
            rb.setUserData("RB1");
            rb.setToggleGroup(antwoordenToggleGroup);
            System.out.println(getVraag(vraagNummer)[i]);
        }
    }

    private String[] getVraag(int vraagNummer) {
        return toets.get(vraagNummer);
    }

    public void volgendeVraag(ActionEvent actionEvent) {
        if (currentVraag < OptieClass.getAantalVragen()) {
            setVraagLabels(currentVraag++);
            if(currentVraag == OptieClass.getAantalVragen()) {
                volgendeVraagButton.setText("Resultaten");
            }
        } else {
            System.out.println(currentVraag);
        }
//        tijdLabel.setText(String.valueOf(timerSeconds));
    }

    private void timer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        tijdLabel.setText(String.valueOf(timerSeconds));
                    }
                });
                timerSeconds--;
                if(timerSeconds == 0) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000,1000);
    }

    public void start(ActionEvent actionEvent) {
    }
}
