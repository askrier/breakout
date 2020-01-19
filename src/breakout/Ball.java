package breakout;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Ball extends Circle {

    private float mySpeed = 10;
    private float myXSpeed;
    private float myYSpeed;
    private boolean hasStart;
    public static final int BALL_SIZE = 5;
    public static final Paint ballColor = Color.WHITE;

    public Ball(int x_val, int y_val) {
        super(x_val, y_val, BALL_SIZE, ballColor);
        hasStart = false;
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
        if(bounce.isTeam()) {
            if (intersection.getBoundsInLocal().getWidth() != -1 && (((InitialScreen.SCREEN_HEIGHT / 2) - this.getCenterY()) * this.getYSpeed() < 0)) {
                myYSpeed *= -1;
            }
        } else {
            if (intersection.getBoundsInLocal().getWidth() != -1 && (((InitialScreen.SCREEN_HEIGHT / 2) - this.getCenterY()) * this.getYSpeed() < 0)) {
                myYSpeed *= -1;
            }
        }
    }

    public void handleKeys(KeyCode code) {
        if(!hasStart){
            if (code == KeyCode.SPACE) {
                myXSpeed = 150;
                myYSpeed = -150;
                hasStart = true;
            } else if (code == KeyCode.RIGHT) {
                this.setCenterX(this.getCenterX() + mySpeed);
            } else if (code == KeyCode.LEFT) {
                this.setCenterX(this.getCenterX() - mySpeed);
            }
        }
    }

    public void offScreen() {
        if(this.getCenterY() <= 0 || this.getCenterY() >= InitialScreen.SCREEN_HEIGHT) {
            myXSpeed = 0;
            myYSpeed = 0;
            super.setCenterX(InitialScreen.SCREEN_WIDTH / 2);
            super.setCenterY(InitialScreen.SCREEN_HEIGHT / 2);
            hasStart = false;
        }
    }

}
