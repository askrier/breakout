package breakout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class InitialScreen extends Application {

    private Scene myScene;
    public static final String TITLE = "Fight!";
    public static final int SCREEN_WIDTH = 1080;
    public static final int SCREEN_HEIGHT = 1920;
    public static final Paint BACKGROUND = Color.DARKGRAY;

    @Override
    public void start (Stage stage) {
        myScene = setupGame(SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND);
        stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
    }

    private Scene setupGame (int width, int height, Paint background){

        Group root = new Group();

        Scene scene = new Scene(root, width, height, background);

        return scene;
    }

    public static void main (String[] args) { launch(args); }

}