package Demo;

import javax.swing.*;

/**
 * Created by user on 31-Oct-16.
 */
public class Demo {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        GamePanel gamepanel=new GamePanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gamepanel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
