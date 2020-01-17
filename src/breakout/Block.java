package breakout;

import java.awt.*;

public class Block extends Rectangle {

    public static final int MAX_DUR = 5;
    public static int dur;

    public Block(int x_val, int y_val, int width_val, int height_val, int durability) {


        this.x = x_val;
        this.y = y_val;
        this.width = width_val;
        this.height = height_val;
        this.dur = durability;

        //this(x_val, y_val, width_val, height_val, duration);

        //^ try and implement to remove redundancies
    }

    public void damage(){
        this.dur--;
    }

}
