package projetBigBen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Cadenas {

    public static boolean ouvert = false;
    private int l1 = 1;
    private int l2 = 1;
    private int l3 = 1;
    private int l4 = 1;

    @FXML
    private Button incrPremier;
    @FXML
    private Button incrDeuxieme;
    @FXML
    private Button incrTroisieme;
    @FXML
    private Button incrQuatrieme;
    @FXML
    private Button decrPremier;
    @FXML
    private Button decrDeuxieme;
    @FXML
    private Button decrTroisieme;
    @FXML
    private Button decrQuatrieme;
    @FXML
    private Label premier;
    @FXML
    private Label deuxieme;
    @FXML
    private Label troisieme;
    @FXML
    private Label quatrieme;

    @FXML
    void chiffre(ActionEvent event) {


        if (event.getSource()==incrPremier){
            if (l1++ == 9){
                l1 = 1;
            }
            premier.setText("" + l1);
        }

        else if (event.getSource()==incrDeuxieme){
            if (l2++ == 9){
                l2 = 1;
            }
            deuxieme.setText("" + l2);
        }

        else if (event.getSource()==incrTroisieme){
            if (l3++ == 9){
                l3 = 1;
            }
            troisieme.setText("" + l3);
        }

        else if (event.getSource()==incrQuatrieme){
            if (l4++ == 9){
                l4 = 1;
            }
            quatrieme.setText("" + l4);
        }

        else if (event.getSource()==decrPremier){
            if (l1-- == 1){
                l1 = 9;
            }
            premier.setText("" + l1);
        }

        else if (event.getSource()==decrDeuxieme){
            if (l2-- == 1){
                l2 = 9;
            }
            deuxieme.setText("" + l2);
        }

        else if (event.getSource()==decrTroisieme){
            if (l3-- == 1){
                l3 = 9;
            }
            troisieme.setText("" + l3);
        }

        else if (event.getSource()==decrQuatrieme){
            if (l4-- == 1){
                l4 = 9;
            }
            quatrieme.setText("" + l4);
        }

        if (l1 == 4 && l2 == 3 && l3 == 2 && l4 == 8) {
            ouvert = true;
            Stage stage = (Stage) decrQuatrieme.getScene().getWindow();
            stage.close();
        }
    }
}
