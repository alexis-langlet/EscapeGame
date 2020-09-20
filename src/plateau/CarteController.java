package plateau;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CarteController {

    private Scene scenePlateau;

    public void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView mapicon;

    @FXML
    private ImageView bigben;

    @FXML
    private ImageView toweroflondon;

    @FXML
    private ImageView train;

    public static boolean boolBigBen= false;

    public static boolean boolTower= false;

    public static boolean boolTrain= false;

    public void bibgenVisible(){
        boolBigBen=true;
    }

    public void towerVisible(){
        boolTower=true;
    }

    public void trainVisible(){
        boolTrain=true;
    }

    @FXML
    void showprops(MouseEvent event) {
        bigben.setVisible(boolBigBen);
        toweroflondon.setVisible(boolTower);
        train.setVisible(boolTrain);
    }

    @FXML
    void mapIconClick(MouseEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePlateau);
    }

}