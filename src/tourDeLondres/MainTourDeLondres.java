package tourDeLondres;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTourDeLondres extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent s1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene firstScene = new Scene(s1, 1280, 720);
        primaryStage.setTitle("Il faut sauver la Reine d'Angleterre !");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
