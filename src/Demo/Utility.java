package Demo;

import java.util.Random;

/**
 * Created by user on 31-Oct-16.
 */
public class Utility {
    public static Random random=new Random();

    public static int generate(int a)
    {

        int r;
        r=random.nextInt(a);
        return r;
    }
}
