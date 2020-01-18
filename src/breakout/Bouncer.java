package breakout;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class Bouncer extends Rectangle {

    private int mySpeed = 10;
    private boolean roam;

    public Bouncer(int x_val, int y_val, int width_val, int height_val, boolean roamer) {
        super(x_val, y_val, width_val, height_val);
        roam = roamer;
    }

    public void handleKeys(KeyCode code) {
        if (code == KeyCode.RIGHT) {
            this.setX(this.getX() + mySpeed);
        } else if (code == KeyCode.LEFT) {
            this.setX(this.getX() - mySpeed);
        } else if (code == KeyCode.UP && roam) {
            this.setY(this.getY() - mySpeed);
        } else if (code == KeyCode.DOWN && roam) {
            this.setY(this.getY() + mySpeed);
        }
    }

    public int getSpeed(){
        return mySpeed;
    }

    public void setSpeed(int speed){
        mySpeed = speed;
    }

    public boolean isRoam() {
        return roam;
    }
}
