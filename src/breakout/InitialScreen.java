package breakout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javafx.scene.shape.Rectangle;

public class InitialScreen extends Application {

    private Scene myScene;
    public static final String TITLE = "Fight!";
    public static final int SCREEN_WIDTH = 432;
    public static final int SCREEN_HEIGHT = 768;
    public static final int BLOCK_WIDTH = SCREEN_WIDTH / 8;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / 48;
    public static final Paint BACKGROUND = Color.DARKGRAY;

    private Block myBlock0;
    private Block myBlock1;
    private Block myBlock2;
    private Block myBlock3;
    private Block myBlock4;
    private Block myBlock5;
    private Block myBlock6;
    private Block myBlock7;

    private Rectangle myBouncer;

    @Override
    public void start (Stage stage) {
        myScene = setupGame(SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
    }

    private Scene setupGame (int width, int height, Paint background){

        Group root = new Group();

        myBlock0 = new Block(0, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock0.setFill(Color.RED);

        myBlock1 = new Block(1, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock1.setFill(Color.ORANGE);

        myBlock2 = new Block(2, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock2.setFill(Color.YELLOW);

        myBlock3 = new Block(3, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock3.setFill(Color.GREEN);

        myBlock4 = new Block(4, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock4.setFill(Color.BLUE);

        myBlock5 = new Block(5, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock5.setFill(Color.INDIGO);

        myBlock6 = new Block(6, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock6.setFill(Color.VIOLET);

        myBlock7 = new Block(7, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
        myBlock7.setFill(Color.PINK);

        myBouncer = new Rectangle(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*47, BLOCK_WIDTH, BLOCK_HEIGHT);
        myBouncer.setFill(Color.BLACK);

        root.getChildren().add(myBlock0);
        root.getChildren().add(myBlock1);
        root.getChildren().add(myBlock2);
        root.getChildren().add(myBlock3);
        root.getChildren().add(myBlock4);
        root.getChildren().add(myBlock5);
        root.getChildren().add(myBlock6);
        root.getChildren().add(myBlock7);
        root.getChildren().add(myBouncer);

        Scene scene = new Scene(root, width, height, background);

        return scene;
    }

    private void step (double elapsedTime){

    }

    public static void main (String[] args) { launch(args); }

}