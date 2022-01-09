import java.util.Timer;
import java.util.TimerTask;

//ref: https://www.geeksforgeeks.org/java-util-timer-class-java/
public class TimeKeeper2 extends TimerTask
{
    public void run()
    {
        TimeKeeper.i=BookandCancelMovie.setImage(TimeKeeper.i);
    }
}
