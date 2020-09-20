package SteamTrain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EtiquetteVClickedController {

    private Scene sceneEtiquetteVClicked;
    public void setSceneEtiquetteVClicked(Scene scene) {
        sceneEtiquetteVClicked = scene;
    }

    private Scene sceneLuggage3Clicked;
    public void setSceneLuggage3Clicked(Scene scene) {
        sceneLuggage3Clicked = scene;
    }

    @FXML
    void actionFlecheRetourV(MouseEvent event) throws IOException {
        FXMLLoader luggage3clickedLoader = new FXMLLoader(getClass().getResource("Luggage3Clicked.fxml"));
        Parent firstPane = luggage3clickedLoader.load();

        Scene sceneLuggage3Clicked = new Scene(firstPane, 1280, 720);

        Luggage3ClickedController luggage3clickedController = (Luggage3ClickedController) luggage3clickedLoader.getController();
        luggage3clickedController.setSceneLuggage3Clicked(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneLuggage3Clicked);
    }
}
