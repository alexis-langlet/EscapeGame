package projetBigBen;

import javafx.animation.PauseTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Cave {
    private static boolean plan2trouve = false;

    private int num = 1;

    PauseTransition pauseRouge = new PauseTransition(Duration.seconds(1));
    PauseTransition pauseBleu = new PauseTransition(Duration.millis(500));
    PauseTransition pauseVert = new PauseTransition(Duration.millis(500));
    PauseTransition pauseVert2 = new PauseTransition(Duration.millis(1000));
    PauseTransition pauseVert3 = new PauseTransition(Duration.millis(1500));
    PauseTransition pauseVert4 = new PauseTransition(Duration.millis(2000));
    PauseTransition pauseVert5 = new PauseTransition(Duration.millis(2500));
    PauseTransition pauseVert6 = new PauseTransition(Duration.millis(3000));
    PauseTransition pauseVert7 = new PauseTransition(Duration.millis(3500));


    @FXML
    private Button Manivelle1;

    @FXML
    private Button Manivelle2;

    @FXML
    private Button Manivelle3;

    @FXML
    private Button Manivelle4;

    @FXML
    private Button Manivelle5;

    @FXML
    private Arc LumiereVerte;

    @FXML
    private Arc LumiereRouge;

    @FXML
    private Button ManivelleRouge;

    @FXML
    private ImageView imgCave;

    @FXML
    private Button feuille;

    @FXML
    private Arc LumiereBleu;


    public void afficherImage() {
        Stage stage = new Stage();
        Group group = new Group();
        stage.setScene(new Scene(group));
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setTitle("Cuve");
        ImageView image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/cuve.png")));
        image.setPreserveRatio(true);
        image.setFitWidth(500);
        group.getChildren().add(image);
        stage.show();
    }

    public void valve(ActionEvent event) throws InterruptedException {
        pauseRouge.setOnFinished(actionEvent -> LumiereRouge.setVisible(false));
        pauseBleu.setOnFinished(actionEvent -> LumiereBleu.setVisible(false));
        pauseVert.setOnFinished(actionEvent -> LumiereVerte.setVisible(false));
        pauseVert2.setOnFinished(actionEvent -> LumiereVerte.setVisible(true));
        pauseVert3.setOnFinished(actionEvent -> LumiereVerte.setVisible(false));
        pauseVert4.setOnFinished(actionEvent -> LumiereVerte.setVisible(true));
        pauseVert5.setOnFinished(actionEvent -> LumiereVerte.setVisible(false));
        pauseVert6.setOnFinished(actionEvent -> LumiereVerte.setVisible(true));
        pauseVert7.setOnFinished(actionEvent -> LumiereVerte.setVisible(false));


        if(event.getSource()==Manivelle1){
            if(num == 1){
                num++;
                LumiereBleu.setVisible(true);
                pauseBleu.play();
            }
            else {
                num = 1;
                LumiereRouge.setVisible(true);
                pauseRouge.play();
            }
        }
        else if(event.getSource()==Manivelle2){
            if(num == 3 || num == 4){
                num++;
                LumiereBleu.setVisible(true);
                pauseBleu.play();
            }
            else {
                num = 1;
                LumiereRouge.setVisible(true);
                pauseRouge.play();
            }
        }
        else if(event.getSource()==Manivelle3){
            if(num == 5){
                num++;
                LumiereBleu.setVisible(true);
                pauseBleu.play();
            }
            else {
                num = 1;
                LumiereRouge.setVisible(true);
                pauseRouge.play();
            }
        }
        else if(event.getSource()==Manivelle4){
            if(num == 2){
                num++;
                LumiereBleu.setVisible(true);
                pauseBleu.play();
            }
            else if(num == 6){
                LumiereVerte.setVisible(true);
                pauseVert3.play();
                ManivelleRouge.setVisible(false);
                Manivelle1.setVisible(false);
                Manivelle2.setVisible(false);
                Manivelle3.setVisible(false);
                Manivelle4.setVisible(false);
                Manivelle5.setVisible(false);
                imgCave.setImage(new Image(Atelier.class.getResourceAsStream("../images/placard_ouvert.png")));
                feuille.setVisible(true);
            }
            else {
                num = 1;
                LumiereRouge.setVisible(true);
                pauseRouge.play();
            }
        }
        else if(event.getSource()==Manivelle5){
                num = 1;
                LumiereRouge.setVisible(true);
                pauseRouge.play();
        }
        else if(event.getSource()==ManivelleRouge){
            if(num == 1){
                LumiereVerte.setVisible(true);
                pauseVert.play();
            }
            else if(num == 3 || num == 4){
                LumiereVerte.setVisible(true);
                pauseVert.play();
                pauseVert2.play();
                pauseVert3.play();
            }
            else if(num == 5){
                LumiereVerte.setVisible(true);
                pauseVert.play();
                pauseVert2.play();
                pauseVert3.play();
                pauseVert4.play();
                pauseVert5.play();
            }
            else if(num == 2 || num == 6){
                LumiereVerte.setVisible(true);
                pauseVert.play();
                pauseVert2.play();
                pauseVert3.play();
                pauseVert4.play();
                pauseVert5.play();
                pauseVert6.play();
                pauseVert7.play();
            }
        }
    }

    public void papier(ActionEvent event){
        if (Atelier.isPlan1trouve()){
            fin();
        }
        else {
            plan2trouve = true;
            Stage stage = new Stage();
            Group group = new Group();
            stage.setScene(new Scene(group));
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setTitle("Cuve");
            ImageView image = new ImageView(new Image(Atelier.class.getResourceAsStream("../images/Plans_partie2.png")));
            image.setPreserveRatio(true);
            group.getChildren().add(image);
            stage.show();
        }
    }

    public void retourAtelier() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atelier.fxml"));
            Stage stage = (Stage) Manivelle1.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public static boolean isPlan2trouve() {
        return plan2trouve;
    }

    public void fin(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fin.fxml"));
            Stage stage = (Stage) feuille.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
