package config;

import java.util.ArrayList;
import entite.*;
import geometry.*;

public class Game {
    
    ArrayList<Entite> listebriques;
    Balle balle;
    Racket racket;
    

    public Game(int level) {
        listebriques = new ArrayList<Entite>();
        balle = new Balle();
        racket = new Racket(1);

        // TODO implement here

    }

    public void update(long deltaT) {
        // TODO implement here

    }
}
