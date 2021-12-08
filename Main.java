// main driver code
public class Main{
    public static void main(String [] args){
        dbase.getConnection();
        dbase.closeConnection();
        System.out.println("-!DONE!-");
        /*
        try{
            for(String i : dbase.getData(1)){
                System.out.println(i);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        */

    }

    public static void sequence(){}
}
