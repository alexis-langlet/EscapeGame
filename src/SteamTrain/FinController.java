package SteamTrain;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FinController {
    private Scene sceneFin;
    private static Scene scenePlateau;

    public static void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    public void setSceneFin(Scene scene){
        sceneFin = scene;
    }

    @FXML
    private Button boutonSortie;
    @FXML
    private ImageView passerDialogue;
    @FXML
    private ImageView dialogue;
    @FXML
    private Text textPhrase;
    @FXML
    private Text textNom;


    @FXML
    public void passer(MouseEvent action) throws IOException {
        if(action.getSource()==passerDialogue) {
            textNom.setText("");
            textPhrase.setText("");
            passerDialogue.setVisible(false);
            dialogue.setVisible(false);
        }
    }

    @FXML
    void derniereAction(MouseEvent event) {
        if(event.getSource()==boutonSortie) {
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scenePlateau);
        }
    }
}
