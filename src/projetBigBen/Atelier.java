package projetBigBen;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Atelier {
    private boolean globeEstOuvert = false;
    private static boolean plan1trouve = false;

    @FXML
    private Button buttonBooks;

    @FXML
    private Button buttonMapLondon;

    @FXML
    private Button buttonDistricts;

    @FXML
    private Button cave;

    @FXML
    private Button horloge;

    @FXML
    private Button globe;

    @FXML
    private Text texteHorlogeNonResolue;

    @FXML
    private Button lunettes;

    @FXML
    private Button vinyle;

    @FXML
    private ImageView globeOuvert;

    @FXML
    void objectClicked(ActionEvent event) {
        Stage stage = new Stage();
        Group group = new Group();
        stage.setScene(new Scene(group));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        ImageView image = new ImageView();
        stage.getIcons().add(new Image(Atelier.class.getResourceAsStream("../images/Cadena.png")));
        if(event.getSource()== buttonBooks) {
            stage.setTitle("Journal de bord");
            image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/livre.png")));
        }
        else if(event.getSource()==buttonMapLondon) {
            stage.setTitle("Carte de Londres");
            image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/map_londres.png")));
        }
        else if(event.getSource()==buttonDistricts){
            stage.setTitle("Quartiers de Londres");
            image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/map_londres_districts.png")));
        }
        else if (event.getSource() == lunettes) {
            stage.setTitle("paire de lunettes");
            image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/lunettes.png")));
            stage.getIcons().add(new Image(Atelier.class.getResourceAsStream("../images/icon_globe.png")));
        }
        else if (event.getSource() == vinyle) {
            stage.setTitle("disque vinyle");
            image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/vinyle.png")));
            stage.getIcons().add(new Image(Atelier.class.getResourceAsStream("../images/icon_globe.png")));
        }
        image.setPreserveRatio(true);
        image.setFitWidth(500);
        group.getChildren().add(image);
        stage.show();
    }

    @FXML
    void cave(ActionEvent event) throws IOException {

        if(Cadenas.ouvert) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cave.fxml"));
                Stage stage = (Stage) cave.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
        }

         else if(event.getSource()==cave){
            Parent test = FXMLLoader.load(getClass().getResource("CadenasFx.fxml"));
            Stage stageCadenas = new Stage();
            stageCadenas.getIcons().add(new Image(Atelier.class.getResourceAsStream("../images/Cadena.png")));
            stageCadenas.setTitle("Cadenas");
            stageCadenas.setScene(new Scene(test, 600, 400));
            stageCadenas.setResizable(false);
            stageCadenas.setAlwaysOnTop(true);
            stageCadenas.show();
        }
    }

    @FXML
    void horlogeClicked(ActionEvent event) throws IOException {
        if (event.getSource() == horloge) {
            Parent parentHorloge = FXMLLoader.load(getClass().getResource("horloge.fxml"));
            Stage stageHorloge = new Stage();
            stageHorloge.setTitle("Horloge");
            stageHorloge.setScene(new Scene(parentHorloge));
            stageHorloge.getIcons().add(new Image(Atelier.class.getResourceAsStream("../images/icon_globe.png")));
            stageHorloge.setResizable(false);
            stageHorloge.setAlwaysOnTop(true);
            stageHorloge.show();
        }
    }


    @FXML
    void globeClicked(ActionEvent event){
        if (event.getSource() == globe) {
            if (Horloge.isSolved()){
                if (globeEstOuvert){
                    if (!Cave.isPlan2trouve()) {
                        plan1trouve = true;
                        Stage stage = new Stage();
                        Group group = new Group();
                        stage.setScene(new Scene(group));
                        stage.setResizable(false);
                        stage.setAlwaysOnTop(true);
                        stage.setTitle("morceau de plan");
                        ImageView image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/Plans_partie1.png")));
                        image.setPreserveRatio(true);
                        group.getChildren().add(image);
                        stage.show();
                    }
                    else
                        fin();
                }
                else {
                    globeOuvert.setVisible(true);
                    globeEstOuvert = true;
                }
            }
            else {
                Timeline timeline = new Timeline();
                KeyValue transparent = new KeyValue(texteHorlogeNonResolue.opacityProperty(), 0.0);
                KeyValue opaque = new KeyValue(texteHorlogeNonResolue.opacityProperty(), 100.0);
                KeyFrame startFadeIn = new KeyFrame(Duration.ZERO, transparent);
                KeyFrame endFadeIn = new KeyFrame(Duration.millis(500), opaque);
                KeyFrame startFadeOut = new KeyFrame(Duration.millis(1500), opaque);
                KeyFrame endFadeOut = new KeyFrame(Duration.millis(2000), transparent);
                timeline.getKeyFrames().addAll(startFadeIn, endFadeIn, startFadeOut, endFadeOut);
                timeline.setCycleCount(1);
                timeline.play();
            }
        }
    }

    public static boolean isPlan1trouve() {
        return plan1trouve;
    }

    public void fin(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fin.fxml"));
            Stage stage = (Stage) globe.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }




}

