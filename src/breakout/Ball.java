package breakout;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Ball extends Circle {

    private float mySpeed;
    private float myXSpeed;
    private float myYSpeed;
    public static final int BALL_SIZE = 5;
    public static final Paint ballColor = Color.WHITE;

    public Ball(int x_val, int y_val) {
        super(x_val,y_val, BALL_SIZE, ballColor);
        myXSpeed = 75;
        myYSpeed = 75;
    }

    public float getSpeed() {
        return mySpeed;
    }

    public void setSpeed(int speed) {
        mySpeed = speed;
    }

    public float getXSpeed() {
        return myXSpeed;
    }

    public void setXSpeed(float speed) {
        myXSpeed = speed;
    }

    public float getYSpeed() {
        return myYSpeed;
    }

    public void setYSpeed(float speed) {
        myYSpeed = speed;
    }

    public void sideWallCollisions() {
        if(this.getCenterX() <= BALL_SIZE || this.getCenterX() >= InitialScreen.SCREEN_WIDTH - BALL_SIZE){
            myXSpeed *= -1;
        }
    }

    public void paddleCollision(Bouncer bounce) {
        Shape intersection = Shape.intersect(this, bounce);
        if(intersection.getBoundsInLocal().getWidth() != -1){
            myYSpeed *= -1;
        }
    }

}
