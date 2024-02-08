package utils;

import geometry.Coordinates;
import geometry.Vector;

public final class GameConstants {

    //brick
    public static final int MAP_HEIGHT = 24;
    public static final int MAP_WIDTH = 15;
    public static final int ROWS_OF_BRICKS = 12;
    public static final int COLUMNS_OF_BRICKS = 13;
    public static final int MIN_SPACE_BETWEEN_RACKET_BRICKS = 5;

    //ball
    public static final int DEFAULT_BALL_SPEED = 5; 
    public static final int DEFAULT_BALL_RADIUS= 10; 
    public static final Vector DEFAULT_BALL_START_DIRECTION=new Vector( new Coordinates(1, 1));
    public static final Coordinates DEFAULT_BALL_START_COORDINATES = new Coordinates(GameConstants.DEFAULT_WINDOW_WIDTH/2, GameConstants.DEFAULT_WINDOW_HEIGHT/2);

    //fenetre
    public static final double DEFAULT_WINDOW_WIDTH = 1000.0; 
    public static final double DEFAULT_WINDOW_HEIGHT = 800.0; 
    public static final int DEFAULT_FPS = 120;

    //particle de traînée
    public static final int DEFAULT_trailLength = 70; // taille de la trainée 
    public static final double DEFAULT_PARTICLE_RADIUS = 1.4;
    public static final double DEFAULT_FLUCTUATION = 5;
    public static final int DEFAULT_PARTICLE = 10; // nombre de particules
    
}

