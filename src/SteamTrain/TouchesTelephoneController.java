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

public class TouchesTelephoneController {

    private Scene sceneCouloir;
    public void setSceneCouloir(Scene scene) {
        sceneCouloir = scene;
    }


    @FXML
    private Button tel1;
    @FXML
    private Button tel2;
    @FXML
    private Button tel3;
    @FXML
    private Button tel4;
    @FXML
    private Button tel5;
    @FXML
    private Button tel6;
    @FXML
    private Button tel7;
    @FXML
    private Button tel8;
    @FXML
    private Button tel9;
    @FXML
    private Button tel0;
    @FXML
    private Button reset;
    @FXML
    private Button valide;
    @FXML
    private TextField display;

    @FXML
    void actionClick(ActionEvent action) throws IOException{
        if(action.getSource()==tel1)
            display.setText(display.getText()+'1');
        else if(action.getSource()==tel2)
            display.setText(display.getText()+'2');
        else if(action.getSource()==tel3)
            display.setText(display.getText()+'3');
        else if(action.getSource()==tel4)
            display.setText(display.getText()+'4');
        else if(action.getSource()==tel5)
            display.setText(display.getText()+'5');
        else if(action.getSource()==tel6)
            display.setText(display.getText()+'6');
        else if(action.getSource()==tel7)
            display.setText(display.getText()+'7');
        else if(action.getSource()==tel8)
            display.setText(display.getText()+'8');
        else if(action.getSource()==tel9)
            display.setText(display.getText()+'9');
        else if(action.getSource()==tel0)
            display.setText(display.getText()+'0');

        else if(action.getSource()==reset)
            display.setText("");
        else if(action.getSource()==valide)
            if(display.getText().equals("02017142647")) {
                FXMLLoader finLoader = new FXMLLoader(getClass().getResource("Fin.fxml"));
                Parent firstPane = finLoader.load();

                Scene sceneFin = new Scene(firstPane, 1280, 720);

                FinController finController = (FinController) finLoader.getController();
                finController.setSceneFin(((Node) action.getSource()).getScene());

                Stage primaryStage = (Stage) ((Node) action.getSource()).getScene().getWindow();
                primaryStage.setScene(sceneFin);

            }

            else
                display.setText("");
    }

    @FXML
    void actionFlecheRetour(MouseEvent event) throws IOException{
        FXMLLoader couloirLoader = new FXMLLoader(getClass().getResource("Couloir.fxml"));
        Parent firstPane = couloirLoader.load();

        CouloirController couloirController = (CouloirController) couloirLoader.getController();
        couloirController.setSceneTouchesTelephone(((Node)event.getSource()).getScene());

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneCouloir);
    }
}
