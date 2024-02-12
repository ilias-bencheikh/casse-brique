package utils;

import javafx.stage.Screen;

public final class GameConstants {

    // brick
    public static final int MAP_HEIGHT = 24;
    public static final int MAP_WIDTH = 15;
    public static final int ROWS_OF_BRICKS = 3;
    public static final int COLUMNS_OF_BRICKS = 13;
    public static final int MIN_SPACE_BETWEEN_RACKET_BRICKS = 5;
    public static final int BRICK_WIDTH = 60;
    public static final int BRICK_HEIGHT = 32;

    // ball
    public static final int DEFAULT_BALL_SPEED = 6;
    public static final int DEFAULT_BALL_DIAMETER = 10;

    // fenetre
    // public static final double DEFAULT_WINDOW_WIDTH = MAP_WIDTH * BRICK_WIDTH;
    // public static final double DEFAULT_WINDOW_HEIGHT = MAP_HEIGHT * BRICK_HEIGHT;
    public static final double DEFAULT_WINDOW_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();// 1000.0;
    public static final double DEFAULT_WINDOW_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();// 800.0;
    public static final int DEFAULT_FPS = 120;

    // particle de traînée
    public static final int DEFAULT_trailLength = 70; // taille de la trainée
    public static final double DEFAULT_PARTICLE_RADIUS = 1.4;
    public static final double DEFAULT_FLUCTUATION = 5;
    public static final int DEFAULT_PARTICLE = 10; // nombre de particules

}
