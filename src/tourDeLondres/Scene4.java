package tourDeLondres;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene4 {
    @FXML
    private Button cle;

    @FXML
    private static Scene scenePlateau;

    @FXML
    public static void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    @FXML
    void PrendreCle(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Group group = new Group();
        stage.setScene(new Scene(group));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        ImageView couro = new ImageView();
        if (event.getSource() == cle) {
            Group group2 = new Group();
            couro = new ImageView(new Image(Scene4.class.getResourceAsStream("../images/couronne.png")));
            group2.getChildren().add(couro);
            Stage main = (Stage) cle.getScene().getWindow();
            main.setTitle("Bravo tu as pu ouvrir la porte qui te mène a la couronne grace a la clé !");
            main.setScene(new Scene(group2));
        }
    }
}
