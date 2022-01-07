// staff class to store staff related info throughout the process
package feats;

import java.util.ArrayList;

public class staff{
    public static String id;
    public static String name;
    public static String email;
    public static String uname;
    public static String pswd;
    public static String phoneno;


    // basic constructor
    public staff (String ID, String Name, String Email, String Uname, String Pswd, String PhoneNo){
        id = ID;
        name = Name;
        email = Email;
        uname = Uname;
        pswd = Pswd;
        phoneno = PhoneNo;
    }
    // RESET staff obj's attributes to null/0
    public static void RESET(){
        id=null;
        name=null;
        email=null;
        uname=null;
        pswd=null;
        phoneno=null;
    }
}
