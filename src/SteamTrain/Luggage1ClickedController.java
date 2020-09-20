package SteamTrain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Luggage1ClickedController {
    private Scene sceneLuggage1Clicked;
    public void setSceneLuggage1Clicked(Scene scene) {
        sceneLuggage1Clicked = scene;
    }

    private Scene sceneCabine1;
    public void setSceneCabine1(Scene scene) {
        sceneCabine1 = scene;
    }

    private Scene sceneEtiquetteFClicked;
    public void setSceneEtiquetteFClicked(Scene scene) {
        sceneEtiquetteFClicked = scene;
    }

    @FXML
    private Label idEtiquetteFTrouve;
    @FXML
    private Label idRienTrouve;
    @FXML
    private Label idTrouveStylo;
    @FXML
    private Button idAfficherEtiquetteF;

    @FXML
    private Button idL1Poche1;
    @FXML
    public void actionL1Poche1(ActionEvent actionEvent) {
        idEtiquetteFTrouve.setVisible(true);
        idAfficherEtiquetteF.setVisible(true);
        idTrouveStylo.setVisible(false);
        idRienTrouve.setVisible(false);
    }

    @FXML
    public void actionAfficherEtiquetteF(ActionEvent event) throws IOException {
            FXMLLoader etiquettefclickedLoader = new FXMLLoader(getClass().getResource("EtiquetteFClicked.fxml"));
            Parent firstPane = etiquettefclickedLoader.load();

            Scene sceneEtiquetteFClicked = new Scene(firstPane, 1280, 720);

            EtiquetteFClickedController etiquettefclickedController = (EtiquetteFClickedController) etiquettefclickedLoader.getController();
            etiquettefclickedController.setSceneEtiquetteFClicked(((Node)event.getSource()).getScene());

            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(sceneEtiquetteFClicked);
    }

    @FXML
    private Button idL1Poche2;
    @FXML
    public void actionL1Poche2(ActionEvent event) {
        idRienTrouve.setVisible(true);
        idEtiquetteFTrouve.setVisible(false);
        idAfficherEtiquetteF.setVisible(false);
        idTrouveStylo.setVisible(false);
    }

    @FXML
    private Button idL1Poche3;
    @FXML
    public void actionL1Poche3(ActionEvent event) {
        idRienTrouve.setVisible(true);
        idEtiquetteFTrouve.setVisible(false);
        idAfficherEtiquetteF.setVisible(false);
        idTrouveStylo.setVisible(false);
    }

    @FXML
    private Button idL1Poche4;
    @FXML
    public void actionL1Poche4(ActionEvent event) {
        idTrouveStylo.setVisible(true);
        idRienTrouve.setVisible(false);
        idEtiquetteFTrouve.setVisible(false);
        idAfficherEtiquetteF.setVisible(false);
    }

    @FXML
    void actionFlecheRetour1(MouseEvent event) throws IOException {
        FXMLLoader cabine1Loader = new FXMLLoader(getClass().getResource("Cabine1.fxml"));
        Parent firstPane = cabine1Loader.load();

        Scene sceneCabine1 = new Scene(firstPane, 1280, 720);

        Cabine1Controller cabine1Controller = (Cabine1Controller) cabine1Loader.getController();
        cabine1Controller.setSceneCouloir(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCabine1);
    }
}
