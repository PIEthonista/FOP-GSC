package feats;

import java.util.ArrayList;
public class movi{
    // mov obj attirbutes
    String name;
    String reldate;
    String showdate;
    ArrayList<String> casts = new ArrayList<String>();
    String synopsis;

    // constructor
    public movi (String name, String reldate, String showdate, String [] arr, String synopsis){
        this.name = name;
        this.reldate = reldate;
        this.showdate = showdate;
        this.synopsis = synopsis;
        for (String i : arr){
            this.casts.add(i);
        }
    }

    static void getmovi(){}
    static void addmovi(){}
}
