package plateau;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class InventaireController {
    private Scene scenePlateau;

    public void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    @FXML
    private Button invicon;

    @FXML
    void invIconClick(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePlateau);
    }

    //scene de fin
    @FXML
    private ImageView rouage;

    @FXML
    private ImageView rouage2;

    @FXML
    private ImageView clef;

    @FXML
    void sceneFinBoutton(ActionEvent event) throws IOException {
        if (rouage.isVisible() && rouage2.isVisible() && clef.isVisible()) {
            FXMLLoader dialogueLoader = new FXMLLoader(getClass().getResource("dialogue.fxml"));
            Parent dialogue  = dialogueLoader.load();
            Scene sceneDialogue = new Scene(dialogue, 1280, 720);

            DialogueController dialogueController = (DialogueController) dialogueLoader.getController();

            dialogueController.texte(new ArrayList<String>(Arrays.asList("Je suis enfin réparé ! Merci", "Au fait, je ne me suis même pas présenté. \n Je m'appelle Michel !")));

            FXMLLoader FinLoader = new FXMLLoader(getClass().getResource("fin.fxml"));
            Parent Fin  = FinLoader.load();
            Scene sceneFin = new Scene(Fin, 1280, 720);
            dialogueController.setScenePlateau(sceneFin);

            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(sceneDialogue);
        }
    }

    public static boolean boolRouage= false;

    public static boolean boolRouage2= true;

    public static boolean boolClef= false;

    public static void rouageVisible(){
        boolRouage=true;
    }

    public void rouage2Visible(){
        boolRouage2=true;
    }

    public static void clefVisible(){
        boolClef=true;
    }

    @FXML
    void showprops(MouseEvent event) {
        rouage.setVisible(boolRouage);
        rouage2.setVisible(boolRouage2);
        clef.setVisible(boolClef);
    }
}
