package aatoets.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class toetsController extends Controller {
    private ArrayList<String> allewoorden = new ArrayList<>();
    public javafx.scene.control.TextArea textfieldtoets;
    public Label label;
    @FXML
    ToggleGroup aantal;

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    public void genereerToets(ActionEvent actionEvent) throws IOException {
        RadioButton selectedRadionbutton = (RadioButton) aantal.getSelectedToggle();
        String toggleGroupValue = selectedRadionbutton.getText();

        // Dennis toggleGroupValue is het aantal vragen dat er gemaakt moeten worden.
        // Bij maaktestfiles en maakantfiles worden de test en antwoorden files gemaakt
        // Deze moeten nog gevuld worden met vragen.
        maaktestfiles();
        maakantfiles();

        label.setText("De files zijn gegenereerd");

    }

    private void maaktestfiles() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        for (String naam : allewoorden) { // is hetzelfde als (int i = 0; i < allewoorden.size(); i++)
            String fileName = "AA_toets_" + naam + "_" + timeStamp + ".txt";
            if (new File(fileName).createNewFile()) {
                // file created successfully
            } else {
                // error, do something appropriate
            }
        }
    }

    private void maakantfiles() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        for (String naam : allewoorden) { // is hetzelfde als (int i = 0; i < allewoorden.size(); i++)
            String fileName = "AA_ant_" + naam + "_" + timeStamp + ".txt";
            if (new File(fileName).createNewFile()) {
                // file created successfully
            } else {
                // error, do something appropriate
            }
        }
    }

    public void kiesbestand(ActionEvent actionEvent) throws IOException {
        File file = choosefile();
        String filepath = getfilepath(file);
        ArrayList<String> allezinnenlijst = maakzinnenlijst(filepath);

        maaktotaalwoordenlijst(allezinnenlijst);// 0 is alle zinnen
        setTextfieldtoets(allezinnenlijst); // 1 is de eerste 10 zinnen
    }

    private ArrayList<String> maakzinnenlijst(String filepath) throws IOException {
        Scanner input = new Scanner(new File(filepath));
        ArrayList<String> allezinnenlist = new ArrayList<>();

        while (input.hasNextLine()) {
            allezinnenlist.add(input.nextLine());
        }

        return allezinnenlist;
    }

    private void maaktotaalwoordenlijst(ArrayList<String> allezinnenlist) {
        for (String temp : allezinnenlist) { //is hetzelfde als (int i = 0; i < allezinnenlist.size(); i++)
            String arr[] = temp.split(" ", 2);
            String woord = arr[0];
            allewoorden.add(woord);
        }
    }

    private File choosefile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        return fileChooser.showOpenDialog(rootPane.getParent().getScene().getWindow());
    }

    private String getfilepath(File file) {

        File f;
        String filepath = "";
        boolean bool;
        f = file;
        bool = f.exists();
        if (bool) {
            filepath = f.toString();
        }
        return filepath;
    }


    private void setTextfieldtoets(ArrayList<String> tienzinnenlist) {
        StringBuilder stringBuilder10 = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            String temp = tienzinnenlist.get(i);
            String arr[] = temp.split(" ", 2);
            String woord = arr[0];
            stringBuilder10.append(woord);
            stringBuilder10.append("\n");
        }

        String finalString = stringBuilder10.toString();
        textfieldtoets.setText(finalString);
    }


    public void afsluiten(ActionEvent actionEvent) {
        System.exit(0);
    }


}

