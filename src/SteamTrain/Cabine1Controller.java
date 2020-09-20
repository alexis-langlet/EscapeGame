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

public class Cabine1Controller {

    private Scene sceneCouloir;
    public void setSceneCouloir(Scene scene) {
        sceneCouloir = scene;
    }
    private Scene sceneCabine1;
    public void setSceneCabine1(Scene scene) {
        sceneCabine1 = scene;
    }

    @FXML
    void actionFlecheRetour(MouseEvent event) throws IOException {
        FXMLLoader couloirLoader = new FXMLLoader(getClass().getResource("Couloir.fxml"));
        Parent firstPane = couloirLoader.load();

        Scene sceneCouloir = new Scene(firstPane, 1280, 720);

        CouloirController couloirController = (CouloirController) couloirLoader.getController();
        couloirController.setSceneTouchesTelephone(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCouloir);
    }

    @FXML
    private Button idLuggage1;
    public void actionLuggage1(ActionEvent event) throws IOException{
            FXMLLoader luggage1clickedLoader = new FXMLLoader(getClass().getResource("Luggage1Clicked.fxml"));
            Parent firstPane = luggage1clickedLoader.load();

            Scene sceneLuggage1Clicked = new Scene(firstPane, 1280, 720);

            Luggage1ClickedController luggage1clickedController = (Luggage1ClickedController) luggage1clickedLoader.getController();
            luggage1clickedController.setSceneLuggage1Clicked(((Node)event.getSource()).getScene());

            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(sceneLuggage1Clicked);
    }
}
