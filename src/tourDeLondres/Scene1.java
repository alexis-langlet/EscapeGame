package tourDeLondres;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1 {

    @FXML
    AnchorPane pane;
    @FXML
    private Button croix;
    @FXML
    private Arc chapelet;

    @FXML
    private Ellipse pas1;

    @FXML
    private Ellipse pas2;

    @FXML
    private Ellipse pas3;

    @FXML
    private Ellipse pas4;

    @FXML
    private Ellipse pas5;

    @FXML
    private Ellipse pas6;

    @FXML
    private Ellipse pas7;

    @FXML
    private Ellipse pas8;

    @FXML
    private Pane depart;

    @FXML
    private Button accepter;

    @FXML
    void fermer(ActionEvent event) {
        depart.setVisible(false);
    }

    @FXML
    void actionnerCroix(ActionEvent event) throws IOException {

        Stage stg = new Stage();
        Group mainGpe = new Group();
        stg.setScene(new Scene(mainGpe));

        DropShadow blurry = new DropShadow();
        stg.setResizable(false);
        stg.setAlwaysOnTop(true);
        ImageView image = null;

        if (event.getSource() == croix) {
            stg.setTitle("Il faut sauver la Reine d'Angleterre");
            //pour "intéragir" avec la photo
            CheckBox tourne = new CheckBox();
            CheckBox check = new CheckBox();
            check.setLayoutX(350);
            check.setLayoutY(130);
            check.setOpacity(0.5);

            Label labelUn = new Label("Intéragir avec le bras gauche");
            Label labelDeux = new Label("Intéragir avec le bras droit");
            labelUn.setLayoutX(300);
            labelUn.setLayoutY(110);
            labelUn.setFont(new Font("Arial", 14));
            labelDeux.setFont(new Font("Arial", 14));
            labelDeux.setLayoutX(850);
            labelDeux.setLayoutY(110);
            mainGpe.getChildren().addAll(labelUn, labelDeux);

            tourne.setLayoutX(910);
            tourne.setLayoutY(130);
            tourne.setOpacity(0.5);
            image = new ImageView(new Image(Scene1.class.getResourceAsStream("../images/crucifix.png")));
            image.setEffect(blurry);

            tourne.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    e -> tourne.setEffect(blurry));

            check.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> check.setEffect(blurry));

            mainGpe.getChildren().add(tourne);
            mainGpe.getChildren().add(check);

            Label lab = new Label("");
            Label labBis = new Label("");
            labBis.setLayoutY(20);
            Button suivant = new Button(); //bouton pour passer à la scène suivante
            suivant.setLayoutX(50);
            suivant.setLayoutY(50);
            suivant.setPrefWidth(200);
            suivant.setPrefHeight(50);
            suivant.setText("Rejoindre la porte");
            suivant.setVisible(false);

            // créer un event quand on coche les deux checkboxes
            EventHandler<ActionEvent> eventBis = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {

                    if (tourne.isSelected() && check.isSelected()) {
                        lab.setText("Une porte vient de s'ouvrir ...");
                        lab.setFont(new Font("Arial", 18));
                        labBis.setText("Vous vous dirigez vers cette dernière");
                        labBis.setFont(new Font("Arial", 18));
                        suivant.setFont(new Font("Arial", 15));
                        suivant.setVisible(true);


                    }
                }
            };
            // set event to checkboxes
            check.setOnAction(eventBis);
            tourne.setOnAction(eventBis);
            mainGpe.getChildren().addAll(lab, labBis, suivant);

// action du bouton dès qu'on clique dessus
            suivant.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) { //charger scene suivante
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
                    Stage stage = (Stage) suivant.getScene().getWindow();
                    Scene scene = null;
                    try {
                        scene = new Scene(loader.load());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene);

                }
            });
            image.setPreserveRatio(false);
            image.setFitHeight(720);
            image.setFitWidth(1280);
            mainGpe.getChildren().add(image);
            stg.show();
            Stage princ = (Stage) croix.getScene().getWindow();
            princ.close();
        } //fin if
    } // fin actionner croix

    @FXML
    void survol(MouseEvent event) { // dès le survol/clic sur le chapelet au sol
        chapelet.setOpacity(0.0);

        chapelet.setFill(Paint.valueOf("#825d4b"));
        // faire apparaître les traces de pas

        pas1.setVisible(true);
        pas2.setVisible(true);
        pas3.setVisible(true);
        pas4.setVisible(true);
        pas5.setVisible(true);
        pas6.setVisible(true);
        pas7.setVisible(true);
        pas8.setVisible(true);

    }
}





