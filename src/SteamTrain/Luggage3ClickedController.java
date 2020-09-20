package SteamTrain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Luggage3ClickedController {

    public ImageView idFlecheRetour3;
    private Scene sceneLuggage3Clicked;
    public void setSceneLuggage3Clicked(Scene scene) {
        sceneLuggage3Clicked = scene;
    }

    private Scene sceneCabine2;
    public void setSceneCabine2(Scene scene) {
        sceneCabine2 = scene;
    }

    private Scene sceneEtiquetteVClicked;
    public void setSceneEtiquetteVClicked(Scene scene) {
        sceneEtiquetteVClicked = scene;
    }

    @FXML
    private Label idRienTrouve;
    @FXML
    private Label idEtiquetteVTrouve;
    @FXML
    private Button idAfficherEtiquetteV;

    @FXML
    private Button idL3Poche1;
    @FXML
    public void actionL3Poche1(ActionEvent event) {
        idEtiquetteVTrouve.setVisible(true);
        idAfficherEtiquetteV.setVisible(true);
        idRienTrouve.setVisible(false);
    }

    @FXML
    private Button idL3Poche2;
    @FXML
    public void actionL3Poche2(ActionEvent event) {
        idEtiquetteVTrouve.setVisible(false);
        idAfficherEtiquetteV.setVisible(false);
        idRienTrouve.setVisible(true);
    }

    @FXML
    public void actionAfficherEtiquetteV(ActionEvent event) throws IOException {
        FXMLLoader etiquettevclickedLoader = new FXMLLoader(getClass().getResource("EtiquetteVClicked.fxml"));
        Parent firstPane = etiquettevclickedLoader.load();

        Scene sceneEtiquetteVClicked = new Scene(firstPane, 1280, 720);

        EtiquetteVClickedController etiquettevclickedController = (EtiquetteVClickedController) etiquettevclickedLoader.getController();
        etiquettevclickedController.setSceneEtiquetteVClicked(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneEtiquetteVClicked);
    }

    @FXML
    void actionFlecheRetour3(MouseEvent event) throws IOException {
        FXMLLoader cabine2Loader = new FXMLLoader(getClass().getResource("Cabine2.fxml"));
        Parent firstPane = cabine2Loader.load();

        Scene sceneCabine2 = new Scene(firstPane, 1280, 720);

        Cabine2Controller cabine2Controller = (Cabine2Controller) cabine2Loader.getController();
        cabine2Controller.setSceneCabine2(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCabine2);
    }
}
