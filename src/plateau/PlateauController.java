package plateau;

import SteamTrain.FinController;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import projetBigBen.Fin;
import tourDeLondres.Scene4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class PlateauController {

    private Scene sceneCarte;

    public void setSceneCarte(Scene scene) {
        sceneCarte = scene;
    }

    private Scene sceneInventaire;

    public void setSceneInventaire(Scene scene) {
        sceneInventaire = scene;
    }

    private boolean enigmeTrain = false;

    private boolean enigmeTower = false;

    private boolean enigmeBigBen = false;

    private boolean enigmeTrain2 = false;

    private boolean enigmeTower2 = false;

    private boolean enigmeBigBen2 = false;

    @FXML
    private ImageView mapicon;

    @FXML
    private ImageView invicon;

    @FXML
    private ImageView character_token;

    @FXML
    private Button dest0;

    @FXML
    private Button dest1;

    @FXML
    private Button dest2;

    @FXML
    private Button dest3;

    @FXML
    private Button dest4;

    @FXML
    private Button dest5;

    @FXML
    private Button dest6;

    @FXML
    private Button dest7;

    @FXML
    private Button dest8;

    @FXML
    private Button dest9;

    @FXML
    private HBox lampe;

    private InnerShadow ombre = new InnerShadow(70, Color.BLACK);

    @FXML
    void mapIconClick(MouseEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCarte);
    }

    @FXML
    void invIconClick(MouseEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneInventaire);
    }

    public void pausIconClick(MouseEvent event) throws IOException {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.setScene(scenePause);
        Popup menupause = new Popup();
        menupause.setAutoHide(true);
        FXMLLoader pauseLoader = new FXMLLoader(getClass().getResource("menupause.fxml"));
        Parent menupauseParent  = pauseLoader.load();
        menupause.getContent().add(menupauseParent);

        Button reprendre = new Button("Reprendre");
        reprendre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menupause.hide();
            }
        });
        reprendre.setLayoutX(menupause.getWidth()/2+20.5);
        reprendre.setLayoutY(menupause.getHeight());

        Button quitter = new Button("Quitter");
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        quitter.setLayoutX(menupause.getWidth()/2+20.5);
        quitter.setLayoutY(menupause.getHeight()+100);

        Button credits = new Button("Crédits");
        credits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                menupause.hide();
                Popup credits = new Popup();
                Text insertCredits = new Text("Crédits\n\nÉquipe du plateau :\nAntoine Belliard\nRémi Espié\nGatien Delhotal\nAlexis Fondard\nValentin Caradec\n\n" +
                        "Équipe de la Tour de Londres :\nSamy Bouhitem\nSantiago Martinez\nLoïc Paumier\nOcéane Scanzi\nKévin Tran\n\n" +
                        "Équipe du train :\nLouis Burnichon\nSilvio Expert-Vasquez\nYlona Fabiani\nAugustin Frey\nLuca Gregoire\nEwan Mahu\n\n" +
                        "Équipe de Big Ben :\nClaire Berthaud\nAlexis Langlet\nFu Lo\nTom Simula\nKimon Vasileiadis\n\n");
                insertCredits.setY(35);
                Pane creditsPane = new Pane();
                creditsPane.setStyle("-fx-background-color: grey;");
                creditsPane.setPrefSize(169, 528);
                credits.getContent().addAll(creditsPane, insertCredits);
                credits.setAutoHide(true);
                credits.show(primaryStage);
            }
        });
        credits.setLayoutX(menupause.getWidth()/2+20.5);
        credits.setLayoutY(menupause.getHeight()+50);

        menupause.getContent().addAll(reprendre,quitter, credits);
        menupause.show(primaryStage);
    }

    @FXML
    void dest_click(ActionEvent event) {
        Button boutonEnCours = ((Button) event.getSource());
        if(character_token.getX()+character_token.getFitWidth()/2!=Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2) && character_token.getY()+character_token.getFitHeight()/2!=Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2)){
            ArrayList<Node> Ampoules = new ArrayList<>(getAllNodes(lampe));

            dest0.setDisable(true);
            dest1.setDisable(true);
            dest2.setDisable(true);
            dest3.setDisable(true);
            dest4.setDisable(true);
            dest5.setDisable(true);
            dest6.setDisable(true);
            dest7.setDisable(true);
            dest8.setDisable(true);
            dest9.setDisable(true);


            PathTransition transition = new PathTransition();
            transition.setNode(character_token);
            transition.setDuration(Duration.seconds(1));
            transition.setPath(mouvement(boutonEnCours));
            transition.setCycleCount(1);
            transition.play();
            transition.setOnFinished(actionEvent -> {
                character_token.setLayoutX(Math.floor(character_token.getLayoutX()+character_token.getTranslateX()));
                character_token.setLayoutY(Math.floor(character_token.getLayoutY()+character_token.getTranslateY()));
                character_token.setTranslateX(0);
                character_token.setTranslateY(0);

                for (Node node: Ampoules){
                    if (node.getEffect() != ombre){
                        node.setEffect(ombre);
                        break;
                    }
                }

                if(enigmeTrain==true && enigmeTrain2 == false){
                    enigmeTrain2=true;
                    //Changement scene train
                    FXMLLoader TrainLoader = new FXMLLoader(getClass().getResource("../SteamTrain/PremierWagon.fxml"));
                    Parent Train  = null;
                    try {
                        Train = TrainLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene sceneTrain = new Scene(Train, 1280, 720);

                    FXMLLoader FinLoaderTrain = new FXMLLoader(getClass().getResource("../SteamTrain/fin.fxml"));
                    try {
                        Parent TrainFin  = FinLoaderTrain.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    FinController TrainFinController = (FinController) FinLoaderTrain.getController();
                    TrainFinController.setScenePlateau(((Button) event.getSource()).getScene()); //scène suivante

                    Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    primaryStage.setScene(sceneTrain);
                }
                if(enigmeBigBen==true && enigmeBigBen2 == false){
                    enigmeBigBen2=true;
                    //Changement scene bigben
                    FXMLLoader bigbenLoader = new FXMLLoader(getClass().getResource("../projetBigBen/intro.fxml"));
                    Parent BigBen  = null;
                    try {
                        BigBen = bigbenLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene sceneBigBen = new Scene(BigBen, 1280, 720);

                    //Intro bigbenController = (Intro) bigbenLoader.getController();


                    FXMLLoader FinLoaderBigBen = new FXMLLoader(getClass().getResource("../projetBigBen/fin.fxml"));
                    try {
                        Parent BigBenFin  = FinLoaderBigBen.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Fin bigbenFinController = (Fin) FinLoaderBigBen.getController();
                    bigbenFinController.setScenePlateau(((Button) event.getSource()).getScene()); //scène suivante

                    Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    primaryStage.setScene(sceneBigBen);
                }
                if(enigmeTower==true && enigmeTower2 == false){
                    enigmeTower2=true;
                    //Changement scene tour de londres
                    FXMLLoader TourLoader = new FXMLLoader(getClass().getResource("../tourDeLondres/Scene1.fxml"));
                    Parent Tour  = null;
                    try {
                        Tour = TourLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene sceneTour = new Scene(Tour, 1280, 720);

                    FXMLLoader FinLoaderTour = new FXMLLoader(getClass().getResource("../tourDeLondres/Scene4.fxml"));
                    try {
                        Parent TourFin  = FinLoaderTour.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Scene4 TourFinController = (Scene4) FinLoaderTour.getController();
                    Scene4.setScenePlateau(((Button) event.getSource()).getScene()); //scène suivante

                    Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    primaryStage.setScene(sceneTour);
                }


                dest0.setDisable(false);
                dest1.setDisable(false);
                dest2.setDisable(false);
                dest3.setDisable(false);
                dest4.setDisable(false);
                dest5.setDisable(false);
                dest6.setDisable(false);
                dest7.setDisable(false);
                dest8.setDisable(false);
                dest9.setDisable(false);
            });
        }
    }


    Polyline mouvement(Button boutonEnCours){
        Polyline polyline = new Polyline();

        FXMLLoader carteLoader = new FXMLLoader(getClass().getResource("carte.fxml"));
        try {
            Parent carte  = carteLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CarteController carteController = (CarteController) carteLoader.getController();

        FXMLLoader InventaireLoader = new FXMLLoader(getClass().getResource("inventaire.fxml"));
        try {
            Parent inventaire  = InventaireLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InventaireController inventaireController = (InventaireController) InventaireLoader.getController();

        switch (boutonEnCours.getId()){
            case "dest0":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest1.getLayoutX()-character_token.getLayoutX()+dest1.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest1.getLayoutY()-character_token.getLayoutY()+dest1.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), 45.0, 50.0, Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest1":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest0.getLayoutX()-character_token.getLayoutX()+dest0.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest0.getLayoutY()-character_token.getLayoutY()+dest0.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), -25.0, 75.0, Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest2.getLayoutX()-character_token.getLayoutX()+dest2.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest2.getLayoutY()-character_token.getLayoutY()+dest2.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), 110.0, 110.0, Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest3.getLayoutX()-character_token.getLayoutX()+dest3.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest3.getLayoutY()-character_token.getLayoutY()+dest3.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), 80.0, 30.0, Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest2":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest1.getLayoutX()-character_token.getLayoutX()+dest1.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest1.getLayoutY()-character_token.getLayoutY()+dest1.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-30.0+character_token.getFitWidth()/2), Math.floor(15.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest4.getLayoutX()-character_token.getLayoutX()+dest4.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest4.getLayoutY()-character_token.getLayoutY()+dest4.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(17.0+character_token.getFitWidth()/2), Math.floor(-25.0+character_token.getFitHeight()/2), Math.floor(41.0+character_token.getFitWidth()/2), Math.floor(-33.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest5.getLayoutX()-character_token.getLayoutX()+dest5.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest5.getLayoutY()-character_token.getLayoutY()+dest5.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(26.0+character_token.getFitWidth()/2), Math.floor(27.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest3":


                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest1.getLayoutX()-character_token.getLayoutX()+dest1.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest1.getLayoutY()-character_token.getLayoutY()+dest1.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(25+character_token.getFitWidth()/2), Math.floor(-244.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.towerVisible();
                    InventaireController.rouageVisible();
                    enigmeTower=true;
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest9.getLayoutX()-character_token.getLayoutX()+dest9.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest9.getLayoutY()-character_token.getLayoutY()+dest9.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(51.0+character_token.getFitWidth()/2), Math.floor(-5.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.towerVisible();
                    InventaireController.rouageVisible();
                    enigmeTower=true;
                }
                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest5.getLayoutX()-character_token.getLayoutX()+dest5.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest5.getLayoutY()-character_token.getLayoutY()+dest5.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(31.0+character_token.getFitWidth()/2), Math.floor(-14.0+character_token.getFitHeight()/2), Math.floor(48.0+character_token.getFitWidth()/2), Math.floor(-121.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.towerVisible();
                    InventaireController.rouageVisible();
                    enigmeTower=true;
                }

                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest4":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest2.getLayoutX()-character_token.getLayoutX()+dest2.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest2.getLayoutY()-character_token.getLayoutY()+dest2.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-22.0+character_token.getFitWidth()/2), Math.floor(53.0+character_token.getFitHeight()/2), Math.floor(-63.0+character_token.getFitWidth()/2), Math.floor(86.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest6.getLayoutX()-character_token.getLayoutX()+dest6.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest6.getLayoutY()-character_token.getLayoutY()+dest6.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(63.0+character_token.getFitWidth()/2), Math.floor(-27.0+character_token.getFitHeight()/2), Math.floor(38.0+character_token.getFitWidth()/2), Math.floor(44.0+character_token.getFitHeight()/2), Math.floor(72.0+character_token.getFitWidth()/2), Math.floor(136.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest5":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest2.getLayoutX()-character_token.getLayoutX()+dest2.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest2.getLayoutY()-character_token.getLayoutY()+dest2.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-4+character_token.getFitWidth()/2), Math.floor(-35.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest3.getLayoutX()-character_token.getLayoutX()+dest3.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest3.getLayoutY()-character_token.getLayoutY()+dest3.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-63.0+character_token.getFitWidth()/2), Math.floor(-25.0+character_token.getFitHeight()/2), Math.floor(-64.0+character_token.getFitWidth()/2), Math.floor(64.0+character_token.getFitHeight()/2), Math.floor(-81.0+character_token.getFitWidth()/2), Math.floor(94.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest6.getLayoutX()-character_token.getLayoutX()+dest6.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest6.getLayoutY()-character_token.getLayoutY()+dest6.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(character_token.getFitWidth()/2, character_token.getFitHeight()/2, 65.0+character_token.getFitWidth()/2, -23.0+character_token.getFitHeight()/2, Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest9.getLayoutX()-character_token.getLayoutX()+dest9.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest9.getLayoutY()-character_token.getLayoutY()+dest9.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(51.0+character_token.getFitWidth()/2), Math.floor(-5.0+character_token.getFitHeight()/2), Math.floor(48.0+character_token.getFitWidth()/2), Math.floor(73.0+character_token.getFitHeight()/2), Math.floor(33.0+character_token.getFitWidth()/2), Math.floor(104.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest6":

                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest4.getLayoutX()-character_token.getLayoutX()+dest4.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest4.getLayoutY()-character_token.getLayoutY()+dest4.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-26.0+character_token.getFitWidth()/2), Math.floor(-17.0+character_token.getFitHeight()/2), Math.floor(-61.0+character_token.getFitWidth()/2), Math.floor(-110.0+character_token.getFitHeight()/2), Math.floor(-36.0+character_token.getFitWidth()/2), Math.floor(-181.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.bibgenVisible();
                    enigmeBigBen=true;
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest5.getLayoutX()-character_token.getLayoutX()+dest5.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest5.getLayoutY()-character_token.getLayoutY()+dest5.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-113.0+character_token.getFitWidth()/2), Math.floor(-46.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.bibgenVisible();
                    enigmeBigBen=true;
                }
                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest7.getLayoutX()-character_token.getLayoutX()+dest7.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest7.getLayoutY()-character_token.getLayoutY()+dest7.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-57.0+character_token.getFitWidth()/2), Math.floor(39.0+character_token.getFitHeight()/2), Math.floor(-48.0+character_token.getFitWidth()/2), Math.floor(59.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.bibgenVisible();
                    enigmeBigBen=true;
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest7":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest6.getLayoutX()-character_token.getLayoutX()+dest6.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest6.getLayoutY()-character_token.getLayoutY()+dest6.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(26.0+character_token.getFitWidth()/2), Math.floor(-10.0+character_token.getFitHeight()/2), Math.floor(17.0+character_token.getFitWidth()/2), Math.floor(-31.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest9.getLayoutX()-character_token.getLayoutX()+dest9.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest9.getLayoutY()-character_token.getLayoutY()+dest9.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-39.0+character_token.getFitWidth()/2), Math.floor(17.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest8.getLayoutX()-character_token.getLayoutX()+dest8.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest8.getLayoutY()-character_token.getLayoutY()+dest8.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(25.0+character_token.getFitHeight()/2), Math.floor(16.0+character_token.getFitWidth()/2), Math.floor(50.0+character_token.getFitHeight()/2),  Math.floor(character_token.getFitWidth()/2), Math.floor(78.0+character_token.getFitHeight()/2),Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest8":

                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest7.getLayoutX()-character_token.getLayoutX()+dest7.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest7.getLayoutY()-character_token.getLayoutY()+dest7.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-12.0+character_token.getFitWidth()/2), Math.floor(-25.0+character_token.getFitHeight()/2), Math.floor(3.0+character_token.getFitWidth()/2), Math.floor(-57.0+character_token.getFitHeight()/2), Math.floor(-13.0+character_token.getFitWidth()/2), Math.floor(-80.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.trainVisible();
                    InventaireController.clefVisible();
                    enigmeTrain=true;
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest9.getLayoutX()-character_token.getLayoutX()+dest9.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest9.getLayoutY()-character_token.getLayoutY()+dest9.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-11.0+character_token.getFitWidth()/2), Math.floor(-43.0+character_token.getFitHeight()/2), Math.floor(-50.0+character_token.getFitWidth()/2), Math.floor(-76.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));

                    carteController.trainVisible();
                    InventaireController.clefVisible();
                    enigmeTrain=true;
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            case "dest9":
                if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest8.getLayoutX()-character_token.getLayoutX()+dest8.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest8.getLayoutY()-character_token.getLayoutY()+dest8.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(57.0+character_token.getFitWidth()/2), Math.floor(3.0+character_token.getFitHeight()/2), Math.floor(97.0+character_token.getFitWidth()/2), Math.floor(37.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest3.getLayoutX()-character_token.getLayoutX()+dest3.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest3.getLayoutY()-character_token.getLayoutY()+dest3.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(-58.0+character_token.getFitWidth()/2), Math.floor(-27.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }

                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest5.getLayoutX()-character_token.getLayoutX()+dest5.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest5.getLayoutY()-character_token.getLayoutY()+dest5.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(31.0+character_token.getFitWidth()/2), Math.floor(-14.0+character_token.getFitHeight()/2), Math.floor(48.0+character_token.getFitWidth()/2), Math.floor(-121.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else if(Math.floor(character_token.getX()+character_token.getFitWidth()/2)==Math.floor(dest7.getLayoutX()-character_token.getLayoutX()+dest7.getWidth()/2) && Math.floor(character_token.getY()+character_token.getFitHeight()/2)==Math.floor(dest7.getLayoutY()-character_token.getLayoutY()+dest7.getHeight()/2-character_token.getFitHeight()/2)){
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(55.0+character_token.getFitWidth()/2), Math.floor(-5.0+character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                }
                else{
                    polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2-5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2+5), Math.floor(character_token.getFitHeight()/2), Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2));
                }
                break;
            default:
                polyline.getPoints().addAll(Math.floor(character_token.getFitWidth()/2), Math.floor(character_token.getFitHeight()/2), Math.floor(boutonEnCours.getLayoutX()-character_token.getLayoutX()+boutonEnCours.getWidth()/2), Math.floor(boutonEnCours.getLayoutY()-character_token.getLayoutY()+boutonEnCours.getHeight()/2-character_token.getFitHeight()/2));
                System.out.println("default");
                break;
        }

        //System.out.println(polyline.toString());
        return polyline;
    }

    public static ArrayList<Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<>();
        addAllDescendents(root, nodes);
        Collections.reverse(nodes);
        return nodes;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof Parent)
                addAllDescendents((Parent)node, nodes);
        }
    }

    /*base code pour mouvement avec DESTINATION la node de destination
    if(character_token.getX()+character_token.getFitWidth()/2!=Math.floor(DESTINATION.getLayoutX()-character_token.getLayoutX()-DESTINATION.getWidth()/2) && character_token.getY()+character_token.getFitHeight()/2!=Math.floor(DESTINATION.getLayoutY()-character_token.getLayoutY()+DESTINATION.getHeight()/2)) {
        Polyline polyline = new Polyline();

        polyline.getPoints().addAll(character_token.getX()+character_token.getFitWidth()/2, character_token.getY()+character_token.getFitHeight()/2, DESTINATION.getLayoutX()-character_token.getLayoutX()-DESTINATION.getWidth()/2, DESTINATION.getLayoutY()-character_token.getLayoutY()+DESTINATION.getHeight()/2);
        System.out.println(polyline.toString());

        PathTransition transition = new PathTransition();
        transition.setNode(character_token);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(polyline);
        transition.setCycleCount(1);
        transition.play();
        transition.setOnFinished(actionEvent -> {
            character_token.setLayoutX(character_token.getLayoutX()+character_token.getTranslateX());
            character_token.setLayoutY(character_token.getLayoutY()+character_token.getTranslateY());
            character_token.setTranslateX(0);
            character_token.setTranslateY(0);

        });
     */

}
