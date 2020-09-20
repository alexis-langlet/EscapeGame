package tourDeLondres;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Scene3 {

    @FXML
    public Button autres2;

    @FXML
    public Button autres1;

    @FXML
    public Button autres4;

    @FXML
    public Button autres6;

    @FXML
    public Button autres5;

    @FXML
    public Button autres7;

    @FXML
    public Button autres3;

    @FXML
    private Button tableau1;

    @FXML
    private Button tableau2;

    @FXML
    private Button tableau3;

    @FXML
    private Button tableau4;

    @FXML
    private Button parchemin;

    @FXML
    void actionnerTableau(ActionEvent event) throws IOException {
        Stage Stableau = new Stage();
        Group Gtableau = new Group();
        Stableau.setResizable(false);
        Stableau.setAlwaysOnTop(true);
        Stableau.setScene(new Scene(Gtableau));

        if (event.getSource() == tableau1) {
            Stableau.setTitle("Portrait de la Reine Victoria");
            ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/tableauVictoria.jpeg")));
            Button clic = new Button();
            clic.setLayoutX(236);
            clic.setLayoutY(151);
            clic.setPrefWidth(26);
            clic.setPrefHeight(31);
            clic.setOpacity(0);
            image.setPreserveRatio(true);
            image.setFitHeight(720);
            Gtableau.getChildren().add(image);
            Gtableau.getChildren().add(clic);

            clic.setOnAction(actionEvent -> appuyerBouton(clic));
        } else if (event.getSource() == tableau2) {
            Stableau.setTitle("La Joconde");
            ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/laJoconde.jpg")));
            image.setPreserveRatio(true);
            image.setFitHeight(720);
            Gtableau.getChildren().add(image);
        } else if (event.getSource() == tableau3) {
            Stableau.setTitle("Liberté guidant le Peuple");
            ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/liberteGuidantLePeuple.jpg")));
            image.setPreserveRatio(true);
            image.setFitHeight(720);
            Gtableau.getChildren().add(image);
        } else if (event.getSource() == tableau4) {
            Stableau.setTitle("Cardinal de Michelieu");
            ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/cardinal-michelieu.png")));
            image.setPreserveRatio(true);
            image.setFitHeight(720);
            Gtableau.getChildren().add(image);
        } else {
            Stableau.setTitle("Tableau commun");
            ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/parcheminInutile.png")));
            image.setPreserveRatio(true);
            image.setFitHeight(720);
            Gtableau.getChildren().add(image);
        }
        Stableau.show();
    }

    @FXML
    void lireParchemin(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Group group = new Group();
        stage.setScene(new Scene(group));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setTitle("Parchemin");
        ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/parcheminComplet.png")));
        image.setPreserveRatio(true);
        image.setFitHeight(720);
        group.getChildren().add(image);
        stage.show();
    }

    public void appuyerBouton(Button clic) {
        Stage main = (Stage) tableau1.getScene().getWindow();
        Group group = new Group();
        Scene Sporte = new Scene(group);
        ImageView image = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/galerie.jpg")));
        Button porte = new Button();
        porte.setCursor(Cursor.HAND);
        porte.setStyle("-fx-background-color: black");
        porte.setLayoutX(822);
        porte.setLayoutY(282);
        porte.setPrefWidth(60);
        porte.setPrefHeight(102);
        group.getChildren().add(image);
        group.getChildren().add(porte);
        main.setScene(Sporte);

        Stage tableau = (Stage) clic.getScene().getWindow();
        Group Tgroup = new Group();
        ImageView Iimage = new ImageView(new Image(Scene3.class.getResourceAsStream("../images/parcheminFin.png")));
        Iimage.setPreserveRatio(true);
        Iimage.setFitHeight(720);
        Tgroup.getChildren().add(Iimage);
        Scene fin = new Scene(Tgroup);
        tableau.setScene(fin);

        String musicFile = "src/images/grincement.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        porte.setOnAction(ActionEvent -> salleSuivante(porte));
    }

    public void salleSuivante(Button porte) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
        Stage stage = (Stage) porte.getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene);

    }

    public void rendreVisible(DragEvent mouseEvent) {
        Button bouton = (Button) mouseEvent.getSource();
        bouton.setOpacity(1);
        bouton.setStyle("-fx-background-color: white");
    }
}