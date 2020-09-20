package projetBigBen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Intro {

    @FXML
    private Button accord;

    @FXML
    private Button accord2;

    @FXML
    private Button non;

    @FXML
    void atelier() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atelier.fxml"));
            Stage stage = (Stage) accord.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void non() {
        accord2.setVisible(true);
        non.setVisible(false);
    }
}
