package gui.Menu.MenuControllers;

import config.Game;
import gui.App;
import gui.Menu.MenuViews.StartMenuView;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Classe contrôleur pour le menu de démarrage.
 * Elle gère les interactions de l'utilisateur avec la vue StartMenuView.
 * Elle permet de démarrer le jeu, afficher les options, quitter le jeu et
 * afficher le tutoriel.
 * 
 * @see StartMenuView
 * @author Benmalek Majda
 */
public class StartMenuController {
    private StartMenuView view;

    /**
     * Constructeur de StartMenuController.
     * 
     * @param p Le stage principal sur lequel le menu de démarrage est affiché.
     */
    public StartMenuController(Stage p, StartMenuView view) {
        this.view = view;
        this.view.getBtnPlay().setOnAction(e -> {
            play();
        });
        this.view.getBtnOptions().setOnAction(e -> {
            options();
        });
        this.view.getBtnQuit().setOnAction(e -> {
            quit();
        });
        this.view.getBtnTuto().setOnAction(e -> {
            tuto();
        });
        this.view.getBtnSave().setOnAction(e -> {
            sauvegarde();
        });
    }

    /**
     * Méthode pour choisir le mode de jeu.
     */
    private void play() {
        Platform.runLater(() -> {
            Game.score = 0;
            App.sceneManager.changeScene(view.getPrimaryStage(), "GameModeView");
        });

    }

    /**
     * Méthode pour afficher les options.
     */
    private void options() {
        Platform.runLater(() -> {
            App.sceneManager.changeScene(view.getPrimaryStage(), "OptionsView");
        });
    }

    /**
     * Méthode pour quitter le jeu.
     */
    private void quit() {
        view.getPrimaryStage().close();
        Platform.exit();
        System.exit(0);
    }

    /**
     * Méthode pour afficher le tutoriel.
     */
    private void tuto() {
        Platform.runLater(() -> {
            App.sceneManager.changeScene(view.getPrimaryStage(), "TutoView");
        });
    }

    /**
     * Méthode pour sauvegarder le jeu.
     */
    private void sauvegarde() {
        Platform.runLater(() -> {
            App.sceneManager.changeScene(view.getPrimaryStage(), "SaveView");
        });
    }

}