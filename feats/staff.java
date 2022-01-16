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
    public static String title;
    public static ArrayList<ArrayList<String>> casts = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> shows = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<ArrayList<String>>> movi = new ArrayList<ArrayList<ArrayList<String>>>();
    public static ArrayList<ArrayList<ArrayList<String>>> disp = new ArrayList<ArrayList<ArrayList<String>>>();
    public static ArrayList<ArrayList<String>> todel = new ArrayList<ArrayList<String>>();
    public static int section=0;
    public static int section2=0;
    public static ArrayList<ArrayList<ArrayList<String>>> fnb = new ArrayList<ArrayList<ArrayList<String>>>();
    public static ArrayList<ArrayList<ArrayList<String>>> fnbdisp = new ArrayList<ArrayList<ArrayList<String>>>();
    public static ArrayList<ArrayList<String>> fnbtodel = new ArrayList<ArrayList<String>>();
    public static int section3=0;
    public static int section4=0;


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
    public static void partialRESET(){
        title=null;
        section=0;
        section2=0;
        section3=0;
        section4=0;
        casts.clear();
        shows.clear();
        movi.clear();
        todel.clear();
        disp.clear();
        fnb.clear();
        fnbdisp.clear();
        fnbtodel.clear();
    }
}
