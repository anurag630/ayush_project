package Demo.States;

import java.awt.*;

/**
 * Created by user on 01-Nov-16.
 */
abstract public class State {
    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void keyPressed(int keyCode);
}
