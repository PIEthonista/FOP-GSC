// Java program to demonstrate
//schedule method calls of Timer class

import java.util.Timer;
import java.util.TimerTask;

//ref: https://www.geeksforgeeks.org/java-util-timer-class-java/
public class TimeKeeper extends TimerTask
{
    public static long i = 0;
    public void run()
    {
        i=CoverPage.setImage(i);
    }
}
