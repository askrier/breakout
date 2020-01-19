package breakout;

import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Block extends Rectangle {

    public static final int MAX_DUR = 5;
    public int dur;

    public static final int SCREEN_WIDTH = 432;
    public static final int SCREEN_HEIGHT = 768;
    public static final int BLOCK_WIDTH = SCREEN_WIDTH / 8;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / 48;
    public static final Paint[] DURABILITY_COLOR = {null, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};

    public Block(int x_val, int y_val, int width_val, int height_val, int durability) {

        // by multiplying by consts it turns the board into a coordinate system
        // total grid is 8 x 48
        super(x_val * BLOCK_WIDTH, y_val * BLOCK_HEIGHT, width_val, height_val);
        dur = durability;
        this.setFill(DURABILITY_COLOR[dur]);
    }

    public void damage(){
        if(dur != 0) {
            dur--;
            this.setFill(DURABILITY_COLOR[dur]);
        }
    }

    public void ballCollision(Ball ball) {
        Shape intersection = Shape.intersect(this, ball);
        if(intersection.getBoundsInLocal().getWidth() != -1){
            if(this.getX() <= ball.getCenterX() && ball.getCenterX()<= (this.getX() + BLOCK_WIDTH)){
                ball.setYSpeed(ball.getYSpeed() * -1);
            } else {
                ball.setXSpeed(ball.getXSpeed() * -1);
            }

            this.damage();
        }
    }

}
