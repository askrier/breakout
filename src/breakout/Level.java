package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Level {

    public int number;
    private ArrayList<Block> team1 = new ArrayList<>();
    private ArrayList<Block> team2 = new ArrayList<>();
    public static final int SCREEN_WIDTH = 432;
    public static final int SCREEN_HEIGHT = 768;
    public static final int BLOCK_WIDTH = SCREEN_WIDTH / 8;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / 48;
    private int[][] lvlOneTeamOne = {
            {2, 1, 4, 3, 3, 4, 1, 2},
            {1, 4, 3, 2, 2, 3, 4, 1},
            {4, 3, 2, 1, 1, 2, 3, 4}
    };

    private int[][] lvlOneTeamTwo = {
            {4, 3, 2, 1, 1, 2, 3, 4},
            {1, 4, 3, 2, 2, 3, 4, 1},
            {2, 1, 4, 3, 3, 4, 1, 2}
    };

    private Ball myBall;

    private Bouncer myBouncer0;
    private Bouncer myRoamer0;
    private Bouncer myBouncer1;
    private Bouncer myRoamer1;

    public Level (int level) {
        number = level;
    }

    public Group LevelBegin() {
        Group root = new Group();

        for(int i = 0; i < lvlOneTeamOne.length; i++){
            for(int j = 0; j < lvlOneTeamOne[i].length; j++){
                team1.add(new Block(j, 36 - i, BLOCK_WIDTH, BLOCK_HEIGHT, lvlOneTeamOne[i][j]));
                team2.add(new Block(j, 12 - i, BLOCK_WIDTH, BLOCK_HEIGHT, lvlOneTeamTwo[i][j]));
            }
        }

        myBouncer0 = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*47, BLOCK_WIDTH, BLOCK_HEIGHT / 2, false, true);
        myBouncer0.setFill(Color.BLACK);

        myRoamer0 = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*46, BLOCK_WIDTH, BLOCK_HEIGHT / 2, true, true);
        myRoamer0.setFill(Color.BLACK);

        myBouncer1 = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT / 2, false, false);
        myBouncer1.setFill(Color.BLACK);

        myRoamer1 = new Bouncer(SCREEN_WIDTH/2 - BLOCK_WIDTH/2, BLOCK_HEIGHT*2, BLOCK_WIDTH, BLOCK_HEIGHT / 2, true, false);
        myRoamer1.setFill(Color.BLACK);

        myBall = new Ball(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);

        root.getChildren().addAll(team1);
        root.getChildren().addAll(team2);

        root.getChildren().add(myBouncer0);
        root.getChildren().add(myRoamer0);
        root.getChildren().add(myBouncer1);
        root.getChildren().add(myRoamer1);
        root.getChildren().add(myBall);

        return root;
    }

    public void levelStep (double elapsedTime) {
        myBall.setCenterY(myBall.getCenterY() + myBall.getYSpeed() * elapsedTime);
        myBall.setCenterX(myBall.getCenterX() + myBall.getXSpeed() * elapsedTime);

        myBall.paddleCollision(myBouncer0);
        myBall.paddleCollision(myRoamer0);
        myBall.paddleCollision(myBouncer1);
        myBall.paddleCollision(myRoamer1);

        for(int i = 0; i < team1.size(); i++){
            team1.get(i).ballCollision(myBall);
            team2.get(i).ballCollision(myBall);
        }

        myBall.sideWallCollisions();


        if(myBall.getCenterY() <= 0){
            for(int i = 0; i < team1.size(); i++){
                team2.get(i).damage();
            }
        } else if (myBall.getCenterY() >= SCREEN_HEIGHT){
            for(int i = 0; i < team2.size(); i++){
                team1.get(i).damage();
            }
        }

        myBall.offScreen();
    }

    public void keyInput(KeyCode code) {
        myBouncer0.handleKeys(code);
        myRoamer0.handleKeys(code);
        myBouncer1.handleKeys(code);
        myRoamer1.handleKeys(code);
        myBall.handleKeys(code);
    }
}
