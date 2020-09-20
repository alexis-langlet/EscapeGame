package plateau;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DialogueController {
    private ArrayList<String> histoire = new ArrayList<String>();
    private int enCours = 1;

    private Scene scenePlateau;

    @FXML
    private ImageView skip;

    @FXML
    private ImageView dialogueBox;

    @FXML
    private Text textLore;
    /*
        Timeline timeline = new Timeline();
        KeyValue transparent = new KeyValue(textEnCours.opacityProperty(), 0.0);
        KeyValue opaque = new KeyValue(textEnCours.opacityProperty(), 100.0);

        CarteController carteController = (CarteController) carteLoader.getController();
        carteController.setScenePlateau(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCarte);

     */

    public void texte(ArrayList<String> phrases){
        histoire = phrases;
        textLore.setText(histoire.get(0));
    }

    public void setScenePlateau(Scene scene) {
        scenePlateau = scene;
    }

    void affichePlateau(MouseEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scenePlateau);
    }


    public void nextText(MouseEvent mouseEvent){
        if(this.enCours != this.histoire.size()){
            textLore.setText(histoire.get(enCours));
            enCours++;
        }
        else{
            skip.setVisible(false);
            this.affichePlateau(mouseEvent);
        }
    }
}
