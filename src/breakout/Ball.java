package breakout;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Ball extends Circle {

    private int mySpeed;
    private float myXSpeed;
    private float myYSpeed;
    public static final int BALL_SIZE = 5;
    public static final Paint ballColor = Color.WHITE;

    public Ball(int x_val, int y_val) {
        super(x_val,y_val, BALL_SIZE, ballColor);
        myXSpeed = 75;
        myYSpeed = 75;
    }

    public int getSpeed() {
        return mySpeed;
    }

    public void setSpeed(int speed) {
        mySpeed = speed;
    }

    public float getXSpeed() {
        return myXSpeed;
    }

    public void setXSpeed(int speed) {
        myXSpeed = speed;
    }

    public float getYSpeed() {
        return myYSpeed;
    }

    public void setYSpeed(int speed) {
        myYSpeed = speed;
    }

    public void sideWallCollisions() {
        if(this.getCenterX() <= BALL_SIZE || this.getCenterX() >= InitialScreen.SCREEN_WIDTH - BALL_SIZE){
            myXSpeed *= -1;
        }
    }

}
