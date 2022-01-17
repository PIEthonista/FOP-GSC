import java.util.Timer;
import java.util.TimerTask;

//ref: https://www.geeksforgeeks.org/java-util-timer-class-java/
public class TimeKeeper3 extends TimerTask
{
    public static long i = 0;
    public void run()
    {
        i=SettingMovie.setImage(i);
    }
}
