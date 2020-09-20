package SteamTrain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Cabine2Controller {

    private Scene sceneCouloir;
    public void setSceneCouloir(Scene scene) {
        sceneCouloir = scene;
    }

    private Scene sceneLuggage2Clicked;
    public void setSceneLuggage2Clicked(Scene scene) {
        sceneLuggage2Clicked = scene;
    }

    private Scene sceneLuggage3Clicked;
    public void setSceneLuggage3Clicked(Scene scene) {
        sceneLuggage3Clicked = scene;
    }

    private Scene sceneCabine2;
    public void setSceneCabine2(Scene scene) {
        sceneCabine2 = scene;
    }

    @FXML
    void actionFlecheRetour(MouseEvent event) throws IOException {
        FXMLLoader couloirLoader = new FXMLLoader(getClass().getResource("Couloir.fxml"));
        Parent firstPane = couloirLoader.load();

        Scene sceneCouloir = new Scene(firstPane, 1280, 720);

        CouloirController couloirController = (CouloirController) couloirLoader.getController();
        couloirController.setSceneTouchesTelephone(((Node) event.getSource()).getScene());

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCouloir);
    }

    @FXML
    private Button idLuggage2;
    @FXML
    public void actionLuggage2(ActionEvent event) throws IOException{
        FXMLLoader luggage2clickedLoader = new FXMLLoader(getClass().getResource("Luggage2Clicked.fxml"));
        Parent firstPane = luggage2clickedLoader.load();

        Scene sceneLuggage2Clicked = new Scene(firstPane, 1280, 720);

        Luggage2ClickedController luggage2clickedController = (Luggage2ClickedController) luggage2clickedLoader.getController();
        luggage2clickedController.setSceneLuggage2Clicked(((Node) event.getSource()).getScene());

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneLuggage2Clicked);
    }


    @FXML
    private Button idLuggage3;
    @FXML
    public void actionLuggage3(ActionEvent event) throws IOException{
        FXMLLoader luggage3clickedLoader = new FXMLLoader(getClass().getResource("Luggage3Clicked.fxml"));
        Parent firstPane = luggage3clickedLoader.load();

        Scene sceneLuggage3Clicked = new Scene(firstPane, 1280, 720);

        Luggage3ClickedController luggage3clickedController = (Luggage3ClickedController) luggage3clickedLoader.getController();
        luggage3clickedController.setSceneLuggage3Clicked(((Node) event.getSource()).getScene());

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneLuggage3Clicked);
    }
}
