package breakout;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Level {

    public int number;
    private int[] wins = {0, 0};
    private int newLevel = 0;
    private final int DOUBLE_SPEED = 48;
    private final int DOUBLE_BALL = 300;
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
    private int[][] lvlTwoTeamOne = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2, 2, 2},
            {4, 4, 4, 4, 4, 4, 4, 4}
    };

    private int[][] lvlTwoTeamTwo = {
            {4, 4, 4, 4, 4, 4, 4, 4},
            {2, 2, 2, 2, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[][] lvlThreeTeamOne = {
            {1, 4, 3, 2, 2, 3, 4, 1},
            {4, 3, 2, 1, 1, 2, 3, 4},
            {1, 4, 3, 2, 2, 3, 4, 1}
    };

    private int[][] lvlThreeTeamTwo = {
            {1, 4, 3, 2, 2, 3, 4, 1},
            {4, 3, 2, 1, 1, 2, 3, 4},
            {1, 4, 3, 2, 2, 3, 4, 1}
    };

    private int[][][][] fullLvl = {
            {lvlOneTeamOne, lvlOneTeamTwo},
            {lvlTwoTeamOne, lvlTwoTeamTwo},
            {lvlThreeTeamOne, lvlThreeTeamTwo}
    };

    private Ball myBall;

    private Bouncer myBouncer0;
    private Bouncer myRoamer0;
    private Bouncer myBouncer1;
    private Bouncer myRoamer1;

    public Level (int level) {
        number = level;
    }

    public Level (int level, int winsOne, int winsTwo) {
        number = level;
        wins[0] = winsOne;
        wins[1] = winsTwo;
    }

    public Group LevelBegin() {

        if(number == 0) return beginGame();

        if(number == 4) return endOfGame();

        Group root = new Group();

        for(int i = 0; i < fullLvl[0][0].length; i++){
            for(int j = 0; j < fullLvl[0][0][i].length; j++){
                team1.add(new Block(j, 36 - i, BLOCK_WIDTH, BLOCK_HEIGHT, fullLvl[this.number - 1][0][i][j]));
                team2.add(new Block(j, 12 - i, BLOCK_WIDTH, BLOCK_HEIGHT, fullLvl[this.number - 1][1][i][j]));
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

        if(number >= 2) {
            myBouncer0.setSpeed(DOUBLE_SPEED);
            myBouncer1.setSpeed(DOUBLE_SPEED);
            myRoamer0.setSpeed(DOUBLE_SPEED);
            myBouncer1.setSpeed(DOUBLE_SPEED);
        }

        myBall = new Ball(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);

        if(number >= 3) {
            myBall = new Ball(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, DOUBLE_BALL);
        }

        root.getChildren().addAll(team1);
        root.getChildren().addAll(team2);

        root.getChildren().add(myBouncer0);
        root.getChildren().add(myRoamer0);
        root.getChildren().add(myBouncer1);
        root.getChildren().add(myRoamer1);
        root.getChildren().add(myBall);

        return root;
    }

    public int levelStep (double elapsedTime) {

        myBall.setCenterY(myBall.getCenterY() + myBall.getYSpeed() * elapsedTime);
        myBall.setCenterX(myBall.getCenterX() + myBall.getXSpeed() * elapsedTime);

        myBall.paddleCollision(myBouncer0);
        myBall.paddleCollision(myRoamer0);
        myBall.paddleCollision(myBouncer1);
        myBall.paddleCollision(myRoamer1);

        for(int i = team1.size() - 1; i >= 0; i--){
            team1.get(i).ballCollision(myBall);
            if(team1.get(i).dur == 0) team1.remove(i);
        }
        for(int i = team2.size() - 1; i >= 0; i--){
            team2.get(i).ballCollision(myBall);
            if(team2.get(i).dur == 0) team2.remove(i);
        }

        myBall.sideWallCollisions();

        if(myBall.getCenterY() <= 0){
            for(int i = team2.size() - 1; i >= 0; i--){
                team2.get(i).damage();
                if(team2.get(i).dur == 0) team2.remove(i);
            }
        } else if (myBall.getCenterY() >= SCREEN_HEIGHT){
            for(int i = team1.size() - 1; i >= 0; i--){
                team1.get(i).damage();
                if(team1.get(i).dur == 0) team1.remove(i);
            }
        }

        myBall.offScreen();

        if(team1.isEmpty()) return 2;
        if(team2.isEmpty()) return 1;
        return 0;
    }

    private Group endOfGame() {
        String message = new String();
        if(wins[0] > wins[1]) message = "Player one wins!";
        else message = "Player two wins!";
        Text text = new Text(SCREEN_WIDTH / 2 - BLOCK_WIDTH / 2, SCREEN_HEIGHT / 2, message);
        Group root = new Group();
        root.getChildren().add(text);
        return root;
    }

    private Group beginGame() {
        String message = new String();
        message = "Hi, welcome to defender. This is a two player game where each \n" +
                "player has two paddles. One paddle can float along the player's \n" +
                "half of the screen, and the other is anchored to the baseline of \n" +
                "the player's side. The blocks are your lives, run out of blocks \n" +
                "and you lose that round! Different color blocks can take more hits \n" +
                "than others, but if you let the ball go past the baseline all of \n" +
                "your blocks will get hurt! Player 1 uses the arrow keys, and \n" +
                "Player 2 uses W, A, S, D keys. Press B to begin!";
        Text text = new Text(BLOCK_WIDTH , SCREEN_HEIGHT * 1 / 4, message);
        Group root = new Group();
        root.getChildren().add(text);
        return root;
    }

    public void setWins(int one, int two) {
        wins[0] = one;
        wins[1] = two;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public void keyInput(KeyCode code) {

        if(number != 0 && number != 4) {
            myBouncer0.handleKeys(code);
            myRoamer0.handleKeys(code);
            myBouncer1.handleKeys(code);
            myRoamer1.handleKeys(code);
            myBall.handleKeys(code);
        }

        if(code == KeyCode.B) {
            newLevel = 3;
        }
    }
}
