package Demo;

import Demo.States.GameState;
import Demo.States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by user on 31-Oct-16.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static State currentState;

    public GamePanel() {
        this.setPreferredSize(new Dimension(1000, 600));
        this.setFocusable(true);
        this.addKeyListener(this);

    }

    @Override
    public void addNotify() {
        super.addNotify();
        Resources.load();
        GamePanel.currentState = new GameState();
        this.addKeyListener(this);
        Thread thread = new Thread(this);
        thread.setName("game thread");
        thread.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        GamePanel.currentState.keyPressed(keyEvent.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics imageGraphics;
            Graphics panelGraphics;
            Image mainImage = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_RGB);
            GamePanel.currentState.update();
            imageGraphics = mainImage.getGraphics();
            imageGraphics.clearRect(0, 0, 1000, 600);
            GamePanel.currentState.render(imageGraphics);
            imageGraphics.dispose();

            panelGraphics = this.getGraphics();
            panelGraphics.drawImage(mainImage, 0, 0, null);
            panelGraphics.dispose();
        }
    }
}
