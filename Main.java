// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){

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

        dbase.delCustomer("yx123");
        dbase.updCustomer("Pyrexia02", "c_pswd", "newpassword");
        /*
        arr = dbase.getEmailList();
        for(String i : arr){
            System.out.println(i);
        }
        */

        System.out.println("-!DONE!-");
    }

    public static void sequence(){}
}
