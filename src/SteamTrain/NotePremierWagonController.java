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

public class NotePremierWagonController {

    private Scene scenePremierWagon;

    public void setScenePremierWagon(Scene scene) {
        scenePremierWagon = scene;
    }

    @FXML
    private ImageView boutonRetour;


    public void clickBoutonRetour(MouseEvent mouseEvent) throws IOException {
        FXMLLoader premierWagonLoader = new FXMLLoader(getClass().getResource("PremierWagon.fxml"));
        Parent firstPane = premierWagonLoader.load();

        PremierWagonController premierWagonController = (PremierWagonController) premierWagonLoader.getController();
        premierWagonController.setSceneNote(((Node) mouseEvent.getSource()).getScene());

        Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePremierWagon);
    }
}
