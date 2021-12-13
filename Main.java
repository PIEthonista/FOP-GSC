// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){

        dbase.getConnection();
        dbase.addCustomer("Hing Hong Way", "waytheking@gmail.com","waytheking","123456789","0125003181");
        ArrayList<String> arr = dbase.getEmailList();
        String subject="Here are your tickets!", message="*inserts ticket*";
        for(String i: arr){
            try{
                System.out.println(i);
                //Email2.sendMail(i, subject, message);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        dbase.closeConnection();
        System.out.println("-!DONE!-");
    }

    public static void sequence(){}
}
