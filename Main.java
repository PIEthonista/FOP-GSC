// main driver code
import java.util.ArrayList;

public class Main{
    public static void main(String [] args){
        /*
        dbase.addCustomer("Hing Hong Way", "waytheking@gmail.com","waytheking","123456789","0125003181");
        System.out.println(dbase.getCustomer("yx123"));
        dbase.delCustomer("yx123");
        dbase.updCustomer("Pyrexia02", "c_uname", "NewUsername");
        */
        System.out.println(dbase.getAllFNB());
        System.out.println(dbase.delFNB("Coca-Cola"));
        dbase.updFNB("Potato Chips", "f_price", "100");
        dbase.addFNB("Ice Cream", "chill out with our brand new ice cream!", 34);
        System.out.println(dbase.getAllFNB());
        try{
            QRcode.generateQRcode("HAHAHAHAHAA");
            Email2.sendMessage("gohyixian456@gmail.com", false);
            FP.delFile("qr.png");
        } catch(Exception e){
            e.printStackTrace();
        }



        System.out.println("-!DONE!-");
    }

    public static void sequence(){}
}
