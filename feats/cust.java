// customer
package feats;

import java.util.ArrayList;

public class cust{
    int id;
    String name;
    String email;
    String uname;
    String pswd;
    String phoneno;
    /*
    ArrayList<String> shows = new ArrayList<String>();
    ArrayList<String> dates = new ArrayList<String>();
    ArrayList<String> times = new ArrayList<String>();
    ArrayList<String> seats = new ArrayList<String>();
    ArrayList<String> food = new ArrayList<String>();
    ArrayList<String> bev = new ArrayList<String>();
    ArrayList<String> trans_datetimes = new ArrayList<String>();
    ArrayList<String> trans_amount = new ArrayList<String>();
    ArrayList<String> trans_cardnum = new ArrayList<String>();
    ArrayList<String> trans_cardtype = new ArrayList<String>();
    */

    // constructor 2 + 10 args
    public cust (int id,
                 String name,
                 String email,
                 String uname,
                 String pswd,
                 String phoneno
                 /*
                 String [] shows,
                 String [] dates,
                 String [] times,
                 String [] seats,
                 String [] food,
                 String [] bev,
                 String [] trans_datetimes,
                 String [] trans_amount,
                 String [] trans_cardnum,
                 String [] trans_cardtype
                 */){
        this.id = id;
        this.name = name;
        this.email = email;
        this.uname = uname;
        this.pswd = pswd;
        this.phoneno = phoneno;
        /*
        for(String i : shows){
            this.shows.add(i);
        }
        for(String i : dates){
            this.dates.add(i);
        }
        for(String i : times){
            this.times.add(i);
        }
        for(String i : seats){
            this.seats.add(i);
        }
        for(String i : food){
            this.food.add(i);
        }
        for(String i : bev){
            this.bev.add(i);
        }
        for(String i : trans_datetimes){
            this.trans_datetimes.add(i);
        }
        for(String i : trans_amount){
            this.trans_amount.add(i);
        }
        for(String i : trans_cardnum){
            this.trans_cardnum.add(i);
        }
        for(String i : trans_cardtype){
            this.trans_cardtype.add(i);
        }
        */

    }

    static void getshow(){
        // read & display available movies, provide +info on request
    }
    static void book(){
        // select movie, day, time, seat
    }
    static void food(){
        // display food & bev options
    }
    static void pay(){
        // display ttl expense, accept credit/debit
    }
    static void ticket(){
        // display ticket
    }
    static void sendmail(){}
}
