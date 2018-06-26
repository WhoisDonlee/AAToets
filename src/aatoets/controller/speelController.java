package aatoets.controller;

import aatoets.data.OptieClass;
import aatoets.data.ToetsClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class speelController extends Controller implements Initializable {
    public Label naamLabel;
    public Label tijdLabel;

    private int timerSeconds = OptieClass.getAantalSeconden();
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
        tijdLabel.setText(String.valueOf(timerSeconds));
        timer();
    }

    public void volgendeVraag(ActionEvent actionEvent) {
        tijdLabel.setText(String.valueOf(timerSeconds));
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
                if(timerSeconds == 0) {
                    timer.cancel();
                }
                timerSeconds--;
            }
        };
        timer.scheduleAtFixedRate(task, 1000,1000);
    }
}
