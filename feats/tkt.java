package feats;

import java.util.ArrayList;
import java.util.Arrays;
public class tkt{
    // ticket obj attributes to be used when generating ticket jpg
    String customername;
    String moviename;
    String date;
    String time;
    ArrayList<Integer> seat = new ArrayList<Integer>();

    // constructor
    public tkt (String name, String mov, String date, String time, int [] arr){
        this.customername = name;
        this.moviename = mov;
        this.date = date;
        this.time = time;
        Arrays.sort(arr);
        for (int i : arr){
            this.seat.add(i);
        }

    }

}
