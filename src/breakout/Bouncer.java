package breakout;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class Bouncer extends Rectangle {

    private int myXSpeed = 24;
    private int myYSpeed = 24;
    private boolean roam;
    private boolean team;

    public Bouncer(int x_val, int y_val, int width_val, int height_val, boolean roamer, boolean enemy) {
        super(x_val, y_val, width_val, height_val);
        roam = roamer;
        team = enemy;
    }

    public void handleKeys(KeyCode code) {
        if(team) {
            if (code == KeyCode.RIGHT) {            // Could likely implement as a switch block given more time
                this.setX(this.getX() + myXSpeed);
                if(this.getX() >= InitialScreen.SCREEN_WIDTH - InitialScreen.BLOCK_WIDTH / 2) this.setX(-1 * InitialScreen.BLOCK_WIDTH / 2);
                // Above and the other similar blocks implement the teleporting from side-to-side aspect
            } else if (code == KeyCode.LEFT) {
                this.setX(this.getX() - myXSpeed);
                if(this.getX() <= -1 * InitialScreen.BLOCK_WIDTH / 2) this.setX(InitialScreen.SCREEN_WIDTH - InitialScreen.BLOCK_WIDTH / 2);
            } else if (code == KeyCode.UP && roam && this.getY() > (InitialScreen.SCREEN_HEIGHT / 2 + InitialScreen.BLOCK_HEIGHT)) {
                this.setY(this.getY() - myYSpeed);
            } else if (code == KeyCode.DOWN && roam && this.getY() < InitialScreen.SCREEN_HEIGHT - InitialScreen.BLOCK_HEIGHT) {
                this.setY(this.getY() + myYSpeed);
            }
        } else {
            if (code == KeyCode.D) {
                this.setX(this.getX() + myXSpeed);
                if(this.getX() >= InitialScreen.SCREEN_WIDTH - InitialScreen.BLOCK_WIDTH / 2) this.setX(-1 * InitialScreen.BLOCK_WIDTH / 2);
            } else if (code == KeyCode.A) {
                this.setX(this.getX() - myXSpeed);
                if(this.getX() <= -1 * InitialScreen.BLOCK_WIDTH / 2) this.setX(InitialScreen.SCREEN_WIDTH - InitialScreen.BLOCK_WIDTH / 2);
            } else if (code == KeyCode.W && roam && this.getY() > InitialScreen.BLOCK_HEIGHT) {
                this.setY(this.getY() - myYSpeed);
            } else if (code == KeyCode.S && roam && this.getY() < (InitialScreen.SCREEN_HEIGHT / 2 - InitialScreen.BLOCK_HEIGHT)) {
                this.setY(this.getY() + myYSpeed);
            }
        }
    }

    public boolean isTeam() {
        return team;
    }

    public void setSpeed(int speed){
        myXSpeed = speed;
    }
}
