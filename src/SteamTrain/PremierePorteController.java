package SteamTrain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PremierePorteController {

    private Scene scenePremierWagon;

    @FXML
    private TextField zoneTexte;


    @FXML
    private Button boutonValider;

    public void setScenePremierWagon(Scene scene) {
        scenePremierWagon = scene;
    }


    public void clickBoutonValider(ActionEvent actionEvent) throws IOException{
        if(actionEvent.getSource()==boutonValider) {
            if (zoneTexte.getText().equals("invisible")){

                FXMLLoader couloirLoader = new FXMLLoader(getClass().getResource("Couloir.fxml"));
                Parent firstPane = couloirLoader.load();

                Scene sceneCouloir = new Scene(firstPane, 1280, 720);

                CouloirController couloirController = (CouloirController) couloirLoader.getController();
                couloirController.setSceneCouloir(((Node) actionEvent.getSource()).getScene());

                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(sceneCouloir);

            }
            else
                zoneTexte.setText("");
        }

    }

    public void clickBoutonRetour(MouseEvent mouseEvent) throws IOException {
        FXMLLoader premierWagonLoader = new FXMLLoader(getClass().getResource("PremierWagon.fxml"));
        Parent firstPane = premierWagonLoader.load();

        PremierWagonController premierWagonController = (PremierWagonController) premierWagonLoader.getController();
        premierWagonController.setSceneNote(((Node) mouseEvent.getSource()).getScene());

        Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePremierWagon);
    }
}
