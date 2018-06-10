package aatoets;

import aatoets.data.AminozurenHandler;
import aatoets.data.Aminozuur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/mainScene.fxml"));
        primaryStage.setTitle("AA Toets");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        AminozurenHandler aminoModel = new AminozurenHandler();
        aminoModel.initAminozuren();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
