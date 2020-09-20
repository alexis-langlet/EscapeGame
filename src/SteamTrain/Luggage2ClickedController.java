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

public class Luggage2ClickedController {

    public ImageView idFlecheRetour2;
    private Scene sceneLuggage2Clicked;
    public void setSceneLuggage2Clicked(Scene scene) {
        sceneLuggage2Clicked = scene;
    }
    private Scene sceneCabine2;
    public void setSceneCabine2(Scene scene) {
        sceneCabine2 = scene;
    }

    @FXML
    private Label idAllumettesTrouve;
    @FXML
    private Label idRienTrouve;

    @FXML
    private Button idL2Poche1;
    @FXML
    public void actionL2Poche1(ActionEvent actionEvent) {
        idAllumettesTrouve.setVisible(true);
        idRienTrouve.setVisible(false);
    }

    @FXML
    private Button idL2Poche2;
    @FXML
    public void actionL2Poche2(ActionEvent actionEvent) {
        idAllumettesTrouve.setVisible(false);
        idRienTrouve.setVisible(true);
    }

    @FXML
    private Button idL2Poche3;
    @FXML
    public void actionL2Poche3(ActionEvent actionEvent) {
        idAllumettesTrouve.setVisible(false);
        idRienTrouve.setVisible(true);
    }

    @FXML
    void actionFlecheRetour2(MouseEvent event) throws IOException {
        FXMLLoader cabine2Loader = new FXMLLoader(getClass().getResource("Cabine2.fxml"));
        Parent firstPane = cabine2Loader.load();

        Scene sceneCabine2 = new Scene(firstPane, 1280, 720);

        Cabine2Controller cabine2Controller = (Cabine2Controller) cabine2Loader.getController();
        cabine2Controller.setSceneCabine2(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCabine2);
    }
}
