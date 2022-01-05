// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){

        /*
        this line is added in branch bla
        */

        //this section is added in branch testing-01
        ArrayList<ArrayList<String>> arr = dbase.getAllFNB();
        for (ArrayList<String> i : arr){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");

        }

    }

    public static void sequence(){}
}
