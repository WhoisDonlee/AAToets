package aatoets.controller;


import aatoets.data.OptieClass;
import aatoets.data.ToetsClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class toetsController extends Controller implements Initializable {
    private ArrayList<String> allewoorden = new ArrayList<>();
    public javafx.scene.control.TextArea textfieldtoets;
    public Label label;
    @FXML
    ToggleGroup aantal;
    private ToetsClass tc;
    private ArrayList<String[]> toets;

    public void loadBeginScene(ActionEvent actionEvent) throws IOException {
        screenManager.loadStage(rootPane, "/aatoets/view/startScene.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> soortVragen = new ArrayList<>(Arrays.asList("Volledige Naam", "1 lettercode",
                             "3 lettercode", "Hydrofobiciteit",
                             "Lading", "Grootte",
                             "3D Voorkeur"));
        OptieClass.setSoortVragen(soortVragen);
        OptieClass.setSoortAntwoorden(soortVragen);
    }

    public void genereerToets(ActionEvent actionEvent) throws IOException {

        OptieClass.setAantalVragen(getAantalVragen());

        tc = new ToetsClass();
        toets = tc.genereerToets();
        // Dennis toggleGroupValue is het aantal vragen dat er gemaakt moeten worden.
        // Bij maaktestfiles en maakantfiles worden de test en antwoorden files gemaakt
        // Deze moeten nog gevuld worden met vragen.
        maaktestfiles();
        maakantfiles();

        label.setText("De files zijn gegenereerd");

    }

    private int getAantalVragen() {
        RadioButton rb = (RadioButton) aantal.getSelectedToggle();
        return Integer.parseInt(rb.getText());
    }

    private void maaktestfiles() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        for (String naam : allewoorden) { // is hetzelfde als (int i = 0; i < allewoorden.size(); i++)
            String fileName = "AA_toets_" + naam + "_" + timeStamp + ".txt";
            File file = new File(fileName);
            if (file.createNewFile()) {
                // file created successfully
                FileWriter writer = new FileWriter(file);
                for (String[] s : toets) {
                    for (int i = 0; i < s.length; i++) {
                        if (i == 0) {
                            writer.write(s[i]);
                            System.out.println(s[i]);
                        } else {
                            writer.write("[ ] " + s[i]);
                            System.out.println("[ ] " + s[i]);
                        }
                        writer.write("\n");
                    }
                    writer.write("\n");
                }
                writer.close();
            }
        }
    }

    private void maakantfiles() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        for (String naam : allewoorden) { // is hetzelfde als (int i = 0; i < allewoorden.size(); i++)
            String fileName = "AA_ant_" + naam + "_" + timeStamp + ".txt";
            File file = new File(fileName);
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                for (String[] s : toets) {
                    writer.write(s[0] + "\n" + s[1] + "\n\n");
                }
                writer.close();
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

