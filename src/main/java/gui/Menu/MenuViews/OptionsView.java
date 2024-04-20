package gui.Menu.MenuViews;

import gui.Menu.Menu;
import gui.Menu.MenuControllers.OptionsController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import utils.GameConstants;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;

/**
 * Classe OptionsView qui implémente l'interface Menu pour représenter la vue
 * des options.
 * 
 * @author Benmalek Majda
 * @author Bencheikh Ilias
 */
public class OptionsView implements Menu {
    private Stage primaryStage;
    private static HBox root = new HBox();
    private static Scene scene = new Scene(root, GameConstants.DEFAULT_WINDOW_WIDTH,
            GameConstants.DEFAULT_WINDOW_HEIGHT);
    private Button btnBack;
    private ToggleButton buttonfps;
    private ToggleButton buttonpath;
    private ToggleButton buttonparticles;
    private Slider volumemusic;
    private Slider volumesound;
    private Button buttonleft;
    private Button buttonright;
    private Button buttonpower;
    private List<String> textureNames = loadTextureNames();
    private ComboBox<String> listTheme;
    private ComboBox<String> textureComboBox;
    private ImageView textureImageView;



    public final String TEXTURE_FOLDER = "src/main/ressources/Texture";

    /**
     * Constructeur de OptionsView.
     * 
     * @param p Le stage principal sur lequel la vue des options est affichée.
     */
    public OptionsView(Stage p) {
        this.primaryStage = p;
        btnBack = createButton("Retour", 0, 0);

        // VBox 1: FPS, Chemain de la balle,Particules
        VBox v1 = new VBox();
        // Bouton pour afficher les FPS
        Label labelfps = createLabel("Afficher les FPS", 0, 0);
        if(GameConstants.FPS){
            buttonfps = createToggleButton("ON", false);
        }else{
            buttonfps = createToggleButton("OFF", false);
        }
        // Bouton pour afficher le chemin de la balle
        Label labelpath = createLabel("Afficher le chemin de la balle", 0, 0);
        if(GameConstants.PATH){
            buttonpath = createToggleButton("ON", false);
        }else{
            buttonpath = createToggleButton("OFF", false);
        }

        // Bouton pour afficher les trainées de particules
        Label labelparticles = createLabel("Afficher les particules", 0, 0);
        if(GameConstants.PARTICLES){
            buttonparticles = createToggleButton("ON", false);
        }else{
            buttonparticles = createToggleButton("OFF", false);
        }

        v1.getChildren().addAll(labelfps, buttonfps, labelpath, buttonpath, labelparticles, buttonparticles);

        // VBox 2: Volume de la musique, Volume des sons
        VBox v2 = new VBox();
        // Slider pour le volume de la musique
        Label labelmusic = createLabel("Volume de la musique", 0, 0);
        volumemusic = createSlider(0, 100, GameConstants.MUSIC, 200);

        // Slider pour le volume des sons
        Label labelsound = createLabel("Volume des sons", 0, 0);
        volumesound = createSlider(0, 100, GameConstants.SOUND, 200);

        // ComboBox pour choisir le thème
        Label labeltheme = createLabel("Themes: ", 0, 0);
        listTheme = new ComboBox<String>();
        listTheme.setPromptText("Choisissez un theme");

        listTheme.getItems().addAll("dark", "pink", "light", "protanopie", "deuteranopie", "tritanopie","achromatopsie","black");

        v2.getChildren().addAll(labelmusic, volumemusic, labelsound, volumesound, labeltheme, listTheme);

        // VBox 3: Modif des : Touche gauche, Touche droite, Touche pour activer le
        // pouvoir
        VBox v3 = new VBox();
        // Bouton pour configurer la touche gauche
        Label labelleft = createLabel("Touche pour aller a gauche", 0, 0);
        buttonleft = createButton(GameConstants.LEFT.getName(), 0, 0);

        // Bouton pour configurer la touche droite
        Label labelright = createLabel("Touche pour aller a droite", 0, 0);
        buttonright = createButton(GameConstants.RIGHT.getName(), 0, 0);

        // Bouton pour configure la touche pour activer le pouvoir
        Label labelpower = createLabel("Touche pour activer le pouvoir", 0, 0);
        buttonpower = createButton(GameConstants.SPACE.getName(), 0, 0);

        v3.getChildren().addAll(labelleft, buttonleft, labelright, buttonright, labelpower, buttonpower);


        VBox v4 = new VBox();
        textureComboBox = new ComboBox<>();
        textureComboBox.getItems().addAll(textureNames);
        if (GameConstants.TEXTURE.equals("Null")) {
            textureComboBox.setPromptText("Choisir une texture");
        } else {
            textureComboBox.setValue(GameConstants.TEXTURE);
        }
        textureImageView = new ImageView();
        if (!GameConstants.TEXTURE.equals("Null")) {
            textureImageView.setImage(new Image(new File(TEXTURE_FOLDER + "/" + GameConstants.TEXTURE).toURI().toString()));
        }
        textureImageView.setFitWidth(100); 
        textureImageView.setPreserveRatio(true); 

        // a deplacer dans le controller
        textureComboBox.setOnAction(event -> {
            String selectedTexture = textureComboBox.getValue();
            if (selectedTexture != null) {
                String texturePath = TEXTURE_FOLDER + "/" +selectedTexture;
                Image textureImage = new Image(new File(texturePath).toURI().toString());
                textureImageView.setImage(textureImage);
                GameConstants.TEXTURE = selectedTexture;
            }
            System.out.println(selectedTexture + " selected");
        });

        v4.getChildren().addAll(textureComboBox, textureImageView);

        

        v1.getStyleClass().add("vbox");
        v2.getStyleClass().add("vbox");
        v3.getStyleClass().add("vbox");
        v4.getStyleClass().add("vbox");
        root.getStyleClass().add("root-option");
        root.getChildren().addAll(v1, v2, v3, v4, btnBack);
        new OptionsController(p, this);
    }



     // Méthode pour charger les noms des textures 

    public List<String> loadTextureNames() {
        List<String> textureNames = new ArrayList<>();
        File folder = new File(TEXTURE_FOLDER);
        if (folder.exists() && folder.isDirectory()) {
            File[] fichiers = folder.listFiles();
            if (fichiers != null) {
                for (File fichier : fichiers) {
                    if (fichier.isFile()) {
                        textureNames.add(fichier.getName());
                    }
                }
            }
        }
        textureNames.add("Null");
        return textureNames;
    }

    // Getters

    public HBox getRoot() {
        return root;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public ToggleButton getButtonfps() {
        return buttonfps;
    }

    public ToggleButton getButtonpath() {
        return buttonpath;
    }

    public ToggleButton getButtonparticles() {
        return buttonparticles;
    }

    public Slider getVolumemusic() {
        return volumemusic;
    }

    public Slider getVolumesound() {
        return volumesound;
    }

    public Button getButtonleft() {
        return buttonleft;
    }

    public Button getButtonright() {
        return buttonright;
    }

    public Button getButtonpower() {
        return buttonpower;
    }

    public ComboBox<String> getListTheme() {
        return listTheme;
    }

    public ComboBox<String> getTextureComboBox() {
        return textureComboBox;
    }

    public ImageView getTextureImageView() {
        return textureImageView;
    }


}