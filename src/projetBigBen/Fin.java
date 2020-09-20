package projetBigBen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Fin {

    @FXML
    private Button suivant;

    @FXML
    private static Scene scenePlateau;


    @FXML
    public static void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    @FXML
    void derniereAction(ActionEvent event) {
        if (event.getSource() == suivant){
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(scenePlateau);
        }

    }
}

