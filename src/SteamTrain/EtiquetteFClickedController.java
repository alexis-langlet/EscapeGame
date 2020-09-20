package SteamTrain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EtiquetteFClickedController {

    private Scene sceneEtiquetteFClicked;

    public void setSceneEtiquetteFClicked(Scene scene) {
        sceneEtiquetteFClicked = scene;
    }

    private Scene sceneLuggage1Clicked;

    public void setSceneLuggage1Clicked(Scene scene) {
        sceneLuggage1Clicked = scene;
    }

    @FXML
    void actionFlecheRetourF(MouseEvent event) throws IOException {
            FXMLLoader luggage1clickedLoader = new FXMLLoader(getClass().getResource("Luggage1Clicked.fxml"));
            Parent firstPane = luggage1clickedLoader.load();

            Scene sceneLuggage1Clicked = new Scene(firstPane, 1280, 720);

            Luggage1ClickedController luggage1clickedController = (Luggage1ClickedController) luggage1clickedLoader.getController();
            luggage1clickedController.setSceneLuggage1Clicked(((Node) event.getSource()).getScene());

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(sceneLuggage1Clicked);
        }
    }

