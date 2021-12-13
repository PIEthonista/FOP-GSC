// main driver code
public class Main{
    public static void main(String [] args){
        System.out.println("=== Database ===");
        dbase.getConnection();
        String [][] arr = dbase.getInfo();
        for(String[] i : arr){
            for(String j : i){
                System.out.print(j+" : ");
            }
            System.out.println("");
        }
        dbase.closeConnection();
        System.out.println("=== Email ===");
        try{
            Email2.sendMail("waytheking@gmail.com", "Here are your tickets!", "*inserts ticket*");
        } catch (Exception e){
            e.printStackTrace();
        }


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
