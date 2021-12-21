// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){

        dbase.addCustomer("Hing Hong Way", "waytheking@gmail.com","waytheking","123456789","0125003181");

        //String subject="Here are your tickets!", message="*inserts ticket*";
        System.out.println(dbase.getCustomer("yx123"));

        dbase.delCustomer("yx123");
        dbase.updCustomer("Pyrexia02", "c_uname", "NewUsername");

        System.out.println("-!DONE!-");
    }

    public static void sequence(){}
}
