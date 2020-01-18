package breakout;

import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {

    public static final int MAX_DUR = 5;
    public static int dur;

    public static final int SCREEN_WIDTH = 432;
    public static final int SCREEN_HEIGHT = 768;
    public static final int BLOCK_WIDTH = SCREEN_WIDTH / 8;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / 48;

    public Block(int x_val, int y_val, int width_val, int height_val, int durability) {

        // by multiplying by consts it turns the board into a coordinate system
        // total grid is 8 x 48
        super(x_val * BLOCK_WIDTH, y_val * BLOCK_HEIGHT, width_val, height_val);

        this.dur = durability;
    }

    public void damage(){
        this.dur--;
    }

}
