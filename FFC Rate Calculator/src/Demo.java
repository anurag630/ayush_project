import javax.swing.*;

/**
 * Created by user on 02-Jan-17.
 */
public class Demo {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        RateCalculator calculator=new RateCalculator();
        frame.add(calculator.panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
