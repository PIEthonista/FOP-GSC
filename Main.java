// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){

<<<<<<< Updated upstream
        /*
        this line is added in branch bla
        */
        System.out.println(dbase.getDTL_hallmin("05"));
=======
        ArrayList<String> arr = dbase.getStaff("root");
        for(String i : arr){
            System.out.print(i+" : ");
        }
        System.out.println("");

        ArrayList<ArrayList<String>> arr2 = dbase.getAllFNB();
        for(ArrayList<String> i : arr2){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }

        ArrayList<ArrayList<String>> arr3 = dbase.getHistory("Pyrexia02");
        for(ArrayList<String> i : arr3){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }

        ArrayList<ArrayList<String>> arr4 = dbase.getAllMovies();
        for(ArrayList<String> i : arr4){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }

        ArrayList<ArrayList<String>> arr5 = dbase.getCasts("Spider-Man: No Way Home");
        for(ArrayList<String> i : arr5){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }
>>>>>>> Stashed changes

        ArrayList<ArrayList<String>> arr6 = dbase.getDTL_front("Spider-Man: No Way Home");
        for(ArrayList<String> i : arr6){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }

        ArrayList<String> arr7 = dbase.getSpecDTL_all(arr6.get(0).get(1), arr6.get(0).get(2), arr6.get(0).get(3), arr6.get(0).get(4));
        for(String i : arr7){
            System.out.print(i+" : ");
        }
        System.out.println("");

        System.out.println(dbase.getDTL_hallmin("05"));

        System.out.println("-!DONE!-");
    }

    public static void sequence(){}
}
