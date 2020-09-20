package plateau;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader dialogueLoader = new FXMLLoader(getClass().getResource("dialogue.fxml"));
        Parent dialogue  = dialogueLoader.load();
        Scene sceneDialogue = new Scene(dialogue, 1280, 720);

        FXMLLoader plateauLoader = new FXMLLoader(getClass().getResource("plateau.fxml"));
        Parent plateau  = plateauLoader.load();
        Scene scenePlateau = new Scene(plateau, 1280, 720);

        FXMLLoader carteLoader = new FXMLLoader(getClass().getResource("carte.fxml"));
        Parent carte  = carteLoader.load();
        Scene sceneCarte = new Scene(carte, 1280, 720);

        FXMLLoader inventaireLoader = new FXMLLoader(getClass().getResource("inventaire.fxml"));
        Parent inventaire  = inventaireLoader.load();
        Scene sceneInventaire = new Scene(inventaire, 1280, 720);



        DialogueController dialogueController = (DialogueController) dialogueLoader.getController();
        dialogueController.setScenePlateau(scenePlateau);
        dialogueController.texte(new ArrayList<String>(Arrays.asList("Bonjour, jeune humain !", "Je vois que tu as trouvé mon jeu !", "Il est un peu abîmé... \n Tu m'aiderais à le réparer ?", "La tour, l'horloge et la gare sont les pièces les plus importantes.", "Déplace-moi sur les cases correspondantes pour\n avancer les réparations !", "Mais Attention ! \n Si toutes les lumières en dessous du plateau s'éteignent...", "Tu resteras coincé ici à tout jamais !")));

        PlateauController plateauController = (PlateauController) plateauLoader.getController();
        plateauController.setSceneCarte(sceneCarte);
        plateauController.setSceneInventaire(sceneInventaire);

        CarteController carteController = (CarteController) carteLoader.getController();
        carteController.setScenePlateau(scenePlateau);

        InventaireController inventaireController = (InventaireController) inventaireLoader.getController();
        inventaireController.setScenePlateau(scenePlateau);



        primaryStage.setTitle("Le Jeu");
        primaryStage.setScene(sceneDialogue);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
