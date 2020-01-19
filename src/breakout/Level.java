package breakout;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Level {

    public int number;

    public Level (int level) {
        number = level;
    }

    public Group LevelBegin() {
        if (number == 1) {
            /*
            myBlock0 = new Block(0, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
            myBlock1 = new Block(1, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
            myBlock2 = new Block(2, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 4);
            myBlock3 = new Block(3, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 5);
            myBlock4 = new Block(4, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 5);
            myBlock5 = new Block(5, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 4);
            myBlock6 = new Block(6, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);
            myBlock7 = new Block(7, 1, BLOCK_WIDTH, BLOCK_HEIGHT, 3);

            myBouncer = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*47, BLOCK_WIDTH, BLOCK_HEIGHT / 2, false);
            myBouncer.setFill(Color.BLACK);

            myRoamer = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*46, BLOCK_WIDTH, BLOCK_HEIGHT / 2, true);
            myRoamer.setFill(Color.BLACK);

            myBall = new Ball(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);

            root.getChildren().add(myBlock0);
            root.getChildren().add(myBlock1);
            root.getChildren().add(myBlock2);
            root.getChildren().add(myBlock3);
            root.getChildren().add(myBlock4);
            root.getChildren().add(myBlock5);
            root.getChildren().add(myBlock6);
            root.getChildren().add(myBlock7);
            root.getChildren().add(myBouncer);
            root.getChildren().add(myRoamer);
            root.getChildren().add(myBall);
             */
        }
        return null;
    }

}
