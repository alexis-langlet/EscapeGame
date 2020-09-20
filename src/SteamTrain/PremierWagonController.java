package SteamTrain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;



public class PremierWagonController {

    private Scene sceneNote;
    private Scene scenePorte;

    public void setSceneNote(Scene scene){
        sceneNote = scene;
    }

    public void setScenePorte(Scene scene){
        scenePorte = scene;
    }


   @FXML
   private ImageView note1;

    @FXML
    private ImageView flecheScenePorte;

    public void clickBoutonNote1(MouseEvent mouseEvent) throws IOException {
        FXMLLoader noteLoader = new FXMLLoader(getClass().getResource("NotePremierWagon.fxml"));
        Parent firstPane = noteLoader.load();

        Scene sceneNote = new Scene(firstPane, 1280, 720);

        NotePremierWagonController noteController = (NotePremierWagonController) noteLoader.getController();
        noteController.setScenePremierWagon(((Node)mouseEvent.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneNote);
    }


    public void clickFlecheScenePorte(MouseEvent mouseEvent) throws IOException {

        FXMLLoader porteLoader = new FXMLLoader(getClass().getResource("PremierePorte.fxml"));
        Parent firstPane = porteLoader.load();

        Scene scenePorte = new Scene(firstPane, 1280, 720);

        PremierePorteController porteController = (PremierePorteController) porteLoader.getController();
        porteController.setScenePremierWagon(((Node)mouseEvent.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePorte);

    }
}
