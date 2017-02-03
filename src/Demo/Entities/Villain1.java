package Demo.Entities;

import Demo.Resources;

import java.awt.*;

/**
 * Created by user on 02-Nov-16.
 */
public class Villain1 extends  Entity{
    public Villain1(int x, int y) {
        super(x, y);
    }

    @Override
    public Image getImage() {
        return Resources.villain1;
    }

    @Override
    public int getWidth() {
        return 65;
    }

    @Override
    public int getHeight() {
        return 63;
    }

    @Override
    public void update() {
        super.update();
        if(this.x<=0)
            this.x=0;
        if(this.x>=900)
            this.x=900;
        if(this.y<=0)
            this.y=0;
        if(this.y>=500)
            this.y=500;

    }
}
