package Demo.Entities;

import Demo.Resources;

import java.awt.*;

/**
 * Created by user on 01-Nov-16.
 */
public class Coin extends Entity {
    public Coin(int x, int y) {
        super(x, y);
    }


    @Override
    public Image getImage() {
        return Resources.coin;
    }

    @Override
    public int getWidth() {
        return 65;
    }

    @Override
    public int getHeight() {
        return 65;
    }

    @Override
    public void update() {
        super.update();


    }
}
