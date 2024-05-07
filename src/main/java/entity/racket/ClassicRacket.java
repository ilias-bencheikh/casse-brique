package entity.racket;

import java.util.Set;

import javafx.scene.input.KeyCode;
import physics.entity.Racket;
import utils.GameConstants;

/**
 * raquette qui peut aller a droite et a gauche
 * 
 * @author Belhassen rayan
 */

public class ClassicRacket extends Racket {

    // creation de la raquette
    public ClassicRacket() {
        super(200, 20, "rectangle", 8, false, true);
    }

    // Mouvement a l'appui des touches
    public void handleKeyPress(Set<KeyCode> keysPressed) {
        for (KeyCode key : keysPressed) {
            if (key == GameConstants.LEFT) {
                if (this.mX() > -longueur / 2)
                    this.deplaceX(-speed);
            }
            if (key == GameConstants.RIGHT) {
                if (this.mX() < super.getWidth() - longueur - 70)
                    this.deplaceX(speed);
            }
            if (key == GameConstants.SPACE) {
                setlargeurP(true);
                setVitesseP(true);
            }
        }
    }

    // Mouvement au relachement des touches
    public void handleKeyRelease(KeyCode event) {
        /*
         * switch (event) {
         * }
         */
    }
}
