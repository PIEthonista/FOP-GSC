package feats;

import java.util.ArrayList;
public class movi{
    // mov obj attirbutes
    String name;
    String reldate;
    String showdate;
    ArrayList<String> casts = new ArrayList<String>();
    String synopsis;
    public static ArrayList<ArrayList<ArrayList<String>>> arr = new ArrayList<ArrayList<ArrayList<String>>>();
    public static int section=0;
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
    public static void arrRESET(){
        arr.clear();
    }
}
