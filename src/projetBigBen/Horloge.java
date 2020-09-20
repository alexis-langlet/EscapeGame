package projetBigBen;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import static javafx.animation.Animation.INDEFINITE;

public class Horloge {
    private int minutes = 0;

    private Rotate rotateMinute = new Rotate(0, 165, 165);

    private Rotate rotateHeure = new Rotate(0, 165, 165);

    private int incrementMinute = 5;

    private static boolean solved = false;

    @FXML
    private ImageView petiteAiguille;

    @FXML
    private ImageView grandeAiguille;

    @FXML
    private Button boutonPlus;

    @FXML
    private Button boutonMoins;

    @FXML
    private Button boutonValid;

    @FXML
    private Text texteMauvaiseHeure;

    @FXML
    private Text texteBonneHeure;


    @FXML
    void changeHourClockwise(MouseEvent event) {
        rotateMinute = new Rotate(0, 165, 165);
        rotateHeure = new Rotate(0, 165, 165);
        minutes = (minutes + incrementMinute) % 720;
        rotateMinute.setAngle(6*incrementMinute);
       rotateHeure.setAngle(0.5*incrementMinute);
       petiteAiguille.getTransforms().add(rotateHeure);
       grandeAiguille.getTransforms().add(rotateMinute);
    }


    @FXML
    void changeHourAntiClockwise(MouseEvent event) {
        rotateMinute = new Rotate(0, 165, 165);
        rotateHeure = new Rotate(0, 165, 165);
        if (minutes == 0){
            minutes = 720;
        }
        minutes = (minutes - incrementMinute) % 720;
        rotateMinute.setAngle(360-6*incrementMinute);
        rotateHeure.setAngle(-0.5*incrementMinute);
        petiteAiguille.getTransforms().add(rotateHeure);
        grandeAiguille.getTransforms().add(rotateMinute);
    }

    @FXML
    void stopChangeHour(MouseEvent event){}

    @FXML
    void validateClock(ActionEvent event) {
        Timeline timeline = new Timeline();
        KeyValue transparent = new KeyValue(texteMauvaiseHeure.opacityProperty(), 0.0);
        KeyValue opaque = new KeyValue(texteMauvaiseHeure.opacityProperty(), 100.0);
        if(event.getSource()== boutonValid) {
            if (minutes == (8*60+35)){
                transparent = new KeyValue(texteBonneHeure.opacityProperty(), 0.0);
                opaque = new KeyValue(texteBonneHeure.opacityProperty(), 100.0);
                solved = true;
            }
            KeyFrame startFadeIn = new KeyFrame(Duration.ZERO, transparent);
            KeyFrame endFadeIn = new KeyFrame(Duration.millis(500), opaque);
            KeyFrame startFadeOut = new KeyFrame(Duration.millis(1500), opaque);
            KeyFrame endFadeOut = new KeyFrame(Duration.millis(2000), transparent);
            timeline.getKeyFrames().addAll(startFadeIn, endFadeIn, startFadeOut, endFadeOut);
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    public static boolean isSolved() {
        return solved;
    }
}
