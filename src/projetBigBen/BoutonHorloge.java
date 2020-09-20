package projetBigBen;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class BoutonHorloge extends Parent {
    private int clockwise;
    private Integer minutes;
    private ImageView petiteAiguille;
    private ImageView grandeAiguille;
    public int positionX = 0;
    public int positionY = 0;
    Rotate rotateMinute = new Rotate(0, 100, 100);
    Rotate rotateHeure = new Rotate(0, 100, 100);
    Rectangle base_touche = new Rectangle(75,75, Color.BLUE);
    Text lettre_touche = new Text();
    public String lettre = new String("$");

    public BoutonHorloge(String l, int posX, int posY, int clockwise, ImageView petiteA, ImageView grandeA, Integer minutes){
        this.clockwise = clockwise;
        petiteAiguille = petiteA;
        grandeAiguille = grandeA;
        this.minutes = minutes;
        positionX = posX;
        positionY = posY;
        lettre = l;

        this.getChildren().add(base_touche);

        lettre_touche.setText(lettre);
        lettre_touche.setFill(Color.GRAY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);

        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        this.setOnMousePressed(mouseEvent -> appuyer());
        this.setOnMouseReleased(mouseEvent -> relacher());
    }

    public void appuyer(){
        minutes = (minutes + 5*clockwise) % 720;
        rotateMinute.setAngle(6*clockwise);
        rotateHeure.setAngle(90*clockwise);
        petiteAiguille.getTransforms().add(rotateHeure);
    }

    public void relacher(){

    }


}
