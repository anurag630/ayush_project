package Demo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by user on 31-Oct-16.
 */
public class Resources {
    public static Image bg = null;
    public static Image villain1 = null;
    public static Image villain2 = null;
    public static Image villain3 = null;
    public static Image villain4 = null;
    public static Image over = null;
    public static Image win = null;
    public static Image hero = null;
    public static Image coin = null;

    public static void load() {
        try {
            bg = ImageIO.read(Resources.class.getResource("images/desert.png"));
            win = ImageIO.read(Resources.class.getResource("images/win.png"));
            over = ImageIO.read(Resources.class.getResource("images/over.png"));
            coin = ImageIO.read(Resources.class.getResource("images/coin.png"));
            villain1= ImageIO.read(Resources.class.getResource("images/villain1.png"));
            villain2 = ImageIO.read(Resources.class.getResource("images/villain2.png"));
            villain3 = ImageIO.read(Resources.class.getResource("images/villain3.png"));
            villain4 = ImageIO.read(Resources.class.getResource("images/villain4.png"));
            hero = ImageIO.read(Resources.class.getResource("images/hero.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
