package SteamTrain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader couloirLoader = new FXMLLoader(getClass().getResource("Couloir.fxml"));

        Parent couloir  = couloirLoader.load();

        Scene sceneCouloir = new Scene(couloir, 1280, 720);

        primaryStage.setTitle("Le Jeu");
        primaryStage.setScene(sceneCouloir);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}