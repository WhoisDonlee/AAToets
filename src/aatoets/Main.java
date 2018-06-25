package aatoets;

import aatoets.data.AminozurenHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/optieScene.fxml"));
        primaryStage.setTitle("AA Toets");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        AminozurenHandler.initAminozuren();
        AminozurenHandler.getRandAminozuurByAttribute("lading", "positief", false);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
