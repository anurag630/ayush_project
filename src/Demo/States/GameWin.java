package Demo.States;

import Demo.Resources;

import java.awt.*;

/**
 * Created by user on 04-Nov-16.
 */
public class GameWin extends State {
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.win, 0, 0, null);
    }

    @Override
    public void keyPressed(int keyCode) {

    }
}
