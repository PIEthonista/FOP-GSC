// customer class to store customer related info throughout the process
package feats;

import java.util.ArrayList;

public class cust{
    public static String id;
    public static String name;
    public static String email;
    public static String uname;
    public static String pswd;
    public static String phoneno;

    public static String title;        // movie title  ##
    public static String date;         // YYYY-MM-DD   ##
    public static String time;         // 18:30        ##
    public static String hallno;       // 01           ##
    public static ArrayList<String> select = new ArrayList<String>();  // i01,i05,i04   ##
    public static ArrayList<ArrayList<String>> todel = new ArrayList<ArrayList<String>>();
    public static int adult;           // 2            ##
    public static int student;         // 0            ##
    public static int children;        // 1            ##
    public static ArrayList<String> f_id = new ArrayList<String>();   // 1,1,2,4   ##
    public static String t_date;       // YYYY-MM-DD             ##
    public static double t_amount;     // 66                     ##
    public static String t_cardtype="";   // credit/debit
    public static String t_cardnum;    // 0000-0000-0000-0000    ##
    public static String t_time;       // HH:mm:ss

    // basic constructor (actually object not required, just summarise basic params to one method)
    public cust (String ID, String Name, String Email, String Uname, String Pswd, String PhoneNo){
        id = ID;
        name = Name;
        email = Email;
        uname = Uname;
        pswd = Pswd;
        phoneno = PhoneNo;
    }

    // RESET cust obj's attributes to null/0
    public static void RESET(){
        id=null;
        name=null;
        email=null;
        uname=null;
        pswd=null;
        phoneno=null;
        partialRESET();
    }

    public static void partialRESET(){
        title=null;
        date=null;
        time=null;
        hallno=null;
        select.clear();
        adult=0;
        student=0;
        children=0;
        f_id.clear();
        t_date=null;
        t_amount=0;
        t_cardtype="";
        t_cardnum=null;
        t_time=null;
        todel.clear();
    }
}
