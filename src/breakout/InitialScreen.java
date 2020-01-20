package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class InitialScreen extends Application {

    private Scene myScene;
    private Level currLevel;
    private int winsOne = 0;
    private int winsTwo = 0;
    private int level = 0;
    private int newLevel = 0;
    private Group root;
    public static final String TITLE = "Defender";
    public static final int SCREEN_WIDTH = 432;         // Same aspect proportions to an iPhone
    public static final int SCREEN_HEIGHT = 768;
    public static final int BLOCK_WIDTH = SCREEN_WIDTH / 8;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / 48;
    public static final Paint BACKGROUND = Color.DARKGRAY;

    public static final int FRAMES_PER_SECOND = 60;
    public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

    @Override
    public void start (Stage stage) throws FileNotFoundException {
        myScene = setupGame(SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();

        // attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> {
            try {
                step(SECOND_DELAY, stage);
            } catch (FileNotFoundException ex) {
                //
            }
        });
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    public Scene setupGame (int width, int height, Paint background) throws FileNotFoundException {

        currLevel = new Level(level); // Updates the level

        if(level >= 4) currLevel = new Level(level, winsOne, winsTwo); // Triggers end of game and passes info

        root = currLevel.LevelBegin();

        Scene scene = new Scene(root, width, height, background);

        scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));

        return scene;
    }

    private void step (double elapsedTime, Stage stage) throws FileNotFoundException {

        stage.setScene(myScene); // Making sure it isn't one of the text slides
        if(level < 4 && level != 0) {
            newLevel = currLevel.levelStep(elapsedTime);
        }

        if(level == 0) { // Update works in tandem to sense the B press
            newLevel = currLevel.getNewLevel();
        }

        if(newLevel != 0) { // Iterates to the next level
            if(newLevel == 1) winsOne++;
            if(newLevel == 2) winsTwo++;
            newLevel = 0;
            level++;
            if(level == 4) {
                //System.out.println(winsOne + " " + winsTwo);
                currLevel.setWins(winsOne, winsTwo);
            }
            myScene = setupGame(SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
        }

    }

    private void handleKeyInput(KeyCode code) {

        currLevel.keyInput(code);

    }

    public static void main (String[] args) { launch(args); }

}