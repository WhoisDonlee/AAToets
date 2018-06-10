package aatoets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/mainScene.fxml"));
        primaryStage.setTitle("AA Toets");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        List<String[]> aminoList;
        XMLreader xmlReader = new XMLreader("src/aatoets/data/amino.xml");
        aminoList = xmlReader.getByTag();

        for (String[] anAminoList : aminoList) {
            for (String anAnAminoList : anAminoList) {
                System.out.println(anAnAminoList);
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
