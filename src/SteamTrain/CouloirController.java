package SteamTrain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CouloirController {

    private Scene sceneCabine1;
    private Scene sceneCabine2;
    private Scene sceneTouchesTelephone;
    private Scene sceneCouloir;

    public void setSceneCabine1(Scene scene){
        sceneCabine1 = scene;
    }

    public void setSceneCabine2(Scene scene){
        sceneCabine2 = scene;
    }

    public void setSceneTouchesTelephone(Scene scene){
        sceneTouchesTelephone = scene;
    }

    public void setSceneCouloir(Scene scene){
        sceneCouloir = scene;
    }

    @FXML
    private Button buttonPoignee1;
    @FXML
    private Button buttonPoignee2;
    @FXML
    private Button buttonPorteTelephone;
    @FXML
    private ImageView idCouloir;
    @FXML
    private ImageView idPorteTelephone;

    @FXML
    void actionPoignee1(ActionEvent event) throws IOException {
        FXMLLoader cabine1Loader = new FXMLLoader(getClass().getResource("Cabine1.fxml"));
        Parent firstPane = cabine1Loader.load();

        Scene sceneCabine1 = new Scene(firstPane, 1280, 720);

        Cabine1Controller cabine1Controller = (Cabine1Controller) cabine1Loader.getController();
        cabine1Controller.setSceneCouloir(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCabine1);
    }

    @FXML
    void actionPoignee2(ActionEvent event) throws IOException {
        FXMLLoader cabine2Loader = new FXMLLoader(getClass().getResource("Cabine2.fxml"));
        Parent firstPane = cabine2Loader.load();

        Scene sceneCabine2 = new Scene(firstPane, 1280, 720);

        Cabine2Controller cabine2Controller = (Cabine2Controller) cabine2Loader.getController();
        cabine2Controller.setSceneCouloir(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCabine2);
    }

    @FXML
    void actionPorteTelephone(ActionEvent event) throws IOException {
        FXMLLoader telephoneLoader = new FXMLLoader(getClass().getResource("TouchesTelephone.fxml"));
        Parent firstPane = telephoneLoader.load();

        Scene sceneTouchesTelephone = new Scene(firstPane, 1280, 720);

        TouchesTelephoneController telephoneController = (TouchesTelephoneController) telephoneLoader.getController();
        telephoneController.setSceneCouloir(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneTouchesTelephone);
    }


}
