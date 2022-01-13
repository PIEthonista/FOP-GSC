package feats;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class dbase{
    static Connection con;
    static Statement statement;
    private static String uname = "root";

    // CHANGE TO YOUR LOCAL MySQL Password
    private static String password = "J0hnLegend";

    private static String url = "jdbc:mysql://localhost:3306/FOPGSC";
    //private static String url = "jdbc:mysql://database-1.cbv42i2cijkc.us-east-2.rds.amazonaws.com:3306/FOPGSC";
    //                                        ^Endpoint                                           ^Port^DB
    // Enabled inbound rules : ALL, IPv4 IPv6
    public static void setUname(String u){
        uname = u;
    }
    public static void setPswd(String p){
        password = p;
    }
    public static void SQLsetup(int n){
        while(true){
            if(n==0){
                dbase.setUname(JOptionPane.showInputDialog("Username:"));
                dbase.setPswd(JOptionPane.showInputDialog("Password:"));
            } else {
                dbase.setUname(JOptionPane.showInputDialog("ERROR_Username:"));
                dbase.setPswd(JOptionPane.showInputDialog("Password:"));
            }
            if(updCustomer("yx123", 3, "yx123")>0) {
                JOptionPane.showMessageDialog(null, "You're good to go ;)");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: Check the following:\n - Username\n - Password\n - Database Configuration");
                SQLsetup(1);
            }
            break;
        }
    }

    public static int getConnection(){
        int status=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //esentially checking if the required Driver is there.
        } catch (ClassNotFoundException e) {
            status=1;
            System.out.print("ERROR:: 'com.mysql.cj.jdbc.Driver' MISSING!");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, uname, password);
            statement = con.createStatement();
            System.out.print("CE ~ ");
        } catch (SQLException e) {
            status=1;
            System.out.println("ERROR:: FAILED TO ESTABLISH CONNECTION!\nCheck the below:\n - WiFi Connection (for AWS RLDB)\n - Service URL\n - Master Username\n - Password");
            e.printStackTrace();
        }
        return status;
    }
    public static int closeConnection(){
        int status=0;
        try{
            con.close();
            System.out.println(" ~ CC");
        } catch (Exception e){
            status=1;
            System.out.println("ERROR:: CONNECTION CANNOT BE CLOSED!");
            e.printStackTrace();
        }
        return status;
    }

    //customer
    public static ArrayList<String> getCustomer(String uname){
        String query = "SELECT * FROM customer WHERE c_uname=\'"+uname+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            //each row of data from DB
            while(result.next()){
                arr.add(result.getString(1));
                arr.add(result.getString(2));
                arr.add(result.getString(3));
                arr.add(result.getString(4));
                arr.add(result.getString(5));
                arr.add(result.getString(6));
            }
            System.out.print("success - getCustomer()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getCustomer()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addCustomer(String name, String email, String uname, String pswd, String phno){
        String query = "INSERT INTO customer(c_name, c_email, c_uname, c_pswd, c_phno) VALUES(?,?,?,?,?);";
        int rowsInserted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, uname);
            statement.setString(4, pswd);
            statement.setString(5, phno);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("success - addCustomer()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addCustomer()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    }
    public static int delCustomer(String uname){
        String query = "DELETE FROM customer WHERE c_uname=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, uname);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delCustomer()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delCustomer()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updCustomer(String uname, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>5){
            System.out.print("ERROR:: Option "+option+" out of bound 1-5");
        } else {
            switch (option){
                case 1:
                    opt="c_name";
                    break;
                case 2:
                    opt="c_email";
                    break;
                case 3:
                    opt="c_uname";
                    break;
                case 4:
                    opt="c_pswd";
                    break;
                case 5:
                    opt="c_phno";
            }
            try {
                getConnection();
                String query = "UPDATE customer SET "+opt+"=? WHERE c_uname=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, updateValue);
                statement.setString(2, uname);
                rowsUpdated = statement.executeUpdate();
                if( rowsUpdated > 0) {
                    System.out.print("success - updCustomer()");
                }
                closeConnection();
            } catch(Exception e) {
                System.out.print("ERROR:: updCustomer()");
                closeConnection();
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    public static int updCustomer(String uname, String option, String updateValue){
        String query = "UPDATE customer SET "+option+"=? WHERE c_uname=?";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, uname);
            rowsUpdated = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updCustomer()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updCustomer()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //staff
    public static ArrayList<String> getStaff(String uname){
        String query = "SELECT * FROM staff WHERE s_uname=\'"+uname+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            //each row of data from DB
            while(result.next()){
                arr.add(result.getString(1));
                arr.add(result.getString(2));
                arr.add(result.getString(3));
                arr.add(result.getString(4));
                arr.add(result.getString(5));
                arr.add(result.getString(6));
            }
            System.out.print("success - getStaff()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getStaff()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addStaff(String name, String email, String uname, String pswd, String phno){
        String query = "INSERT INTO staff(s_name, s_email, s_uname, s_pswd, s_phno) VALUES(?,?,?,?,?);";
        int rowsInserted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, uname);
            statement.setString(4, pswd);
            statement.setString(5, phno);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("success - addStaff()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addStaff()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    }
    public static int delStaff(String uname){
        String query = "DELETE FROM staff WHERE s_uname=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, uname);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delStaff()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delStaff()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updStaff(String uname, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>5){
            System.out.print("ERROR:: Option "+option+" out of bound 1-5");
        } else {
            switch (option){
                case 1:
                    opt="s_name";
                    break;
                case 2:
                    opt="s_email";
                    break;
                case 3:
                    opt="s_uname";
                    break;
                case 4:
                    opt="s_pswd";
                    break;
                case 5:
                    opt="s_phno";
            }
            try {
                getConnection();
                String query = "UPDATE staff SET "+opt+"=? WHERE s_uname=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, updateValue);
                statement.setString(2, uname);
                rowsUpdated = statement.executeUpdate();
                if( rowsUpdated > 0) {
                    System.out.print("success - updStaff()");
                }
                closeConnection();
            } catch(Exception e) {
                System.out.print("ERROR:: updStaff()");
                closeConnection();
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    public static int updStaff(String uname, String option, String updateValue){
        String query = "UPDATE staff SET "+option+"=? WHERE s_uname=?";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, uname);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updStaff()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updStaff()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //fnb
    public static ArrayList<ArrayList<String>> getAllFNB(){
        String query = "SELECT * FROM fnb";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                arr.add(temp);
            }
            System.out.print("success - getAllFNB()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getAllFNB()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addFNB(String name, String desc, int price){
        String query = "INSERT INTO fnb(f_name, f_desc, f_price) VALUES(?,?,?)";
        int rowsInserted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setString(3, String.valueOf(price));
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("success - addFNB()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addFNB()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    }
    public static int delFNB(String name){
        String query = "DELETE FROM fnb WHERE f_name=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delFNB()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delFNB()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updFNB(String name, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>3){
            System.out.print("ERROR:: Option "+option+" out of bound 1-3");
        } else {
            switch (option){
                case 1:
                    opt="f_name";
                    break;
                case 2:
                    opt="f_desc";
                    break;
                case 3:
                    opt="f_price";
            }
            try {
                getConnection();
                String query = "UPDATE fnb SET "+opt+"=? WHERE f_name=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, updateValue);
                statement.setString(2, name);
                rowsUpdated = statement.executeUpdate();
                if( rowsUpdated > 0) {
                    System.out.print("success - updFNB()");
                }
                closeConnection();
            } catch(Exception e) {
                System.out.print("ERROR:: updFNB()");
                closeConnection();
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    public static int updFNB(String name, String option, String updateValue){
        String query = "UPDATE fnb SET "+option+"=? WHERE f_name=?";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, name);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updFNB()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updFNB()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //history
    public static ArrayList<ArrayList<String>> getHistory(String uname){
        String query = "SELECT * FROM history WHERE h_uname=\'"+uname+"\'";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                temp.add(result.getString(5));
                temp.add(result.getString(6));
                temp.add(result.getString(7));
                temp.add(result.getString(8));
                temp.add(result.getString(9));
                temp.add(result.getString(10));
                temp.add(result.getString(11));
                temp.add(result.getString(12));
                temp.add(result.getString(13));
                temp.add(result.getString(14));
                temp.add(result.getString(15));
                arr.add(temp);
            }
            System.out.print("success - getHistory()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getHistory()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addHistory(String uname, String title, String date, String time, String hallno, String seats, int adult, int student, int children, String f_id, String t_datetime, int t_amount, String t_cardtype, String t_cardnum){
        String query = "INSERT INTO history(h_uname, h_title, h_date, h_time, h_hallno, h_seats, adult, student, children, f_id, t_datetime, t_amount, t_cardtype, t_cardnum) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        int rowsInserted=0;
        Integer adult1 = adult, student1=student, children1=children, t_amount1=t_amount;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, uname);
            statement.setString(2, title);
            statement.setString(3, date);
            statement.setString(4, time);
            statement.setString(5, hallno);
            statement.setString(6, seats);
            statement.setString(7, adult1.toString());
            statement.setString(8, student1.toString());
            statement.setString(9, children1.toString());
            statement.setString(10, f_id);
            statement.setString(11, t_datetime);
            statement.setString(12, t_amount1.toString());
            statement.setString(13, t_cardtype);
            statement.setString(14, t_cardnum);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("success - addHistory()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addHistory()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    }
    public static int delHistory(String uname){
        String query = "DELETE FROM history WHERE h_uname=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, uname);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delHistory()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delHistory()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updHistory(String uname, int option, String updateValue){
        String[] arr = {"h_uname","h_title","h_date","h_time","h_hallno","h_seats","adult","student","children","f_id","t_datetime","t_amount","t_cardtype","t_cardnum"};
        int rowsUpdated=0;
        String opt = arr[option-1];
        if(option<1 || option>14){
            System.out.print("ERROR:: Option "+option+" out of bound 1-14");
        } else {
            try {
                getConnection();
                String query = "UPDATE history SET "+opt+"=? WHERE h_uname=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, updateValue);
                statement.setString(2, uname);
                rowsUpdated = statement.executeUpdate();
                if( rowsUpdated > 0) {
                    System.out.print("success - updHistory()");
                }
                closeConnection();
            } catch(Exception e) {
                System.out.print("ERROR:: updHistory()");
                closeConnection();
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    public static int updHistory(String uname, String option, String updateValue){
        String query = "UPDATE history SET "+option+"=? WHERE h_uname=?";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, uname);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updHistory()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updHistory()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //movies
    public static ArrayList<ArrayList<String>> getAllMovies(){

        String query = "SELECT * FROM movies";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                temp.add(result.getString(5));
                temp.add(result.getString(6));
                temp.add(result.getString(7));
                arr.add(temp);
            }
            System.out.print("success - getAllMovies()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getAllMovies()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static ArrayList<String> getMovies(int option, String searchValue){
        String[] listz = {"m_title","m_reldate","synopsis","adultp","studentp","childrenp"};
        String opt = listz[option];
        String query = "SELECT * FROM movies WHERE "+opt+"=\'"+searchValue+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                arr.add(result.getString(1));
                arr.add(result.getString(2));
                arr.add(result.getString(3));
                arr.add(result.getString(4));
                arr.add(result.getString(5));
                arr.add(result.getString(6));
                arr.add(result.getString(7));
            }
            System.out.print("success - getMovies()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getMovies()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addMovies(String m_title, String m_reldate, String synopsis, int adultp, int studentp, int childrenp){
        String query = "INSERT INTO movies(m_title, m_reldate, synopsis, adultp, studentp, childrenp) VALUES(?,?,?,?,?,?)";
        int rowsInserted=0;
        Integer adultp1 = adultp, studentp1=studentp, childrenp1=childrenp;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, m_title);
            statement.setString(2, m_reldate);
            statement.setString(3, synopsis);
            statement.setString(4, adultp1.toString());
            statement.setString(5, studentp1.toString());
            statement.setString(6, childrenp1.toString());
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("success - addMovies()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addMovies()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    }
    public static int delMovies(String m_title){
        String query = "DELETE FROM movies WHERE m_title=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, m_title);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delMovies()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delMovies()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updMovies(String m_title, int option, String updateValue){
        String[] arr = {"m_title","m_reldate","synopsis","adultp","studentp","childrenp"};
        int rowsUpdated=0;
        String opt = arr[option-1];
        if(option<1 || option>6){
            System.out.print("ERROR:: Option "+option+" out of bound 1-6");
        } else {
            try {
                getConnection();
                String query = "UPDATE movies SET "+opt+"=? WHERE m_title=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, updateValue);
                statement.setString(2, m_title);
                rowsUpdated = statement.executeUpdate();
                if( rowsUpdated > 0) {
                    System.out.print("success - updMovies");
                }
                closeConnection();
            } catch(Exception e) {
                System.out.print("ERROR:: updMovies()");
                closeConnection();
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    public static int updMovies(String m_title, String option, String updateValue){
        String query = "UPDATE movies SET "+option+"=? WHERE m_title=?";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, m_title);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updMovies()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updMovies()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //casts
    public static ArrayList<ArrayList<String>> getCasts(String m_title){
        String query = "SELECT * FROM casts WHERE m_title=\'"+m_title+"\'";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                arr.add(temp);
            }
            System.out.print("success - getCasts()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getCasts()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    }
    public static int addCasts(String m_title, ArrayList<ArrayList<String>> arr){
        int rowsInserted=0;
        try {
            getConnection();
            for(int i=0; i<arr.size(); i++) {
                String query = "INSERT INTO casts(m_title, c_name, c_char) VALUES(?,?,?)";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, m_title);
                statement.setString(2, arr.get(i).get(0));
                statement.setString(3, arr.get(i).get(1));
                rowsInserted += statement.executeUpdate();
            }
            if (rowsInserted > 0) {
                System.out.print("success - addCasts()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addCasts()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    } // pass in arr ((c_name1, c_char1), (c_name2, c_char2), ...)
    public static int delCasts(String m_title){
        String query = "DELETE FROM casts WHERE m_title=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, m_title);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delCasts()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delCasts()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }

    //datetimeloc
    public static ArrayList<ArrayList<String>> getDTL_front(String m_title){
        String query = "SELECT m_id, m_title, m_date, m_time, m_hallno, m_capacity FROM datetimeloc WHERE m_title=\'"+m_title+"\'";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                temp.add(result.getString(5));
                temp.add(result.getString(6));
                arr.add(temp);
            }
            System.out.print("success - getDTL_front()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getDTL_front()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    } // returns ALL ::{ ID, Title, Date, Time, HallNo, Capacity }:: of that MOVIE
    public static ArrayList<String> getSpecDTL_all(String m_title, String m_date, String m_time, String m_hallno){
        String query = "SELECT * FROM datetimeloc WHERE m_title=\'"+m_title+"\' AND m_date=\'"+m_date+"\' AND m_time=\'"+m_time+"\' AND m_hallno=\'"+m_hallno+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                for(int i=1; i<=166; i++){
                    arr.add(result.getString(i));
                }
            }
            System.out.print("success - getSpecDTL_all()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getSpecDTL_all()");
            closeConnection();
            e.printStackTrace();
        }
        return arr;
    } // returns All info related to that occurrence (row)
    public static int getDTL_hallmin(String m_hallno){
        String query = "SELECT * FROM datetimeloc WHERE m_hallno=\'"+m_hallno+"\'";
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int max=0;
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                int row=0;
                for(int i=1; i<=160; i++){
                    if(Integer.parseInt(result.getString(i+6))>=1){
                        row++;
                    }
                }
                arr.add(row);
            }
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i)>max){
                    max=arr.get(i);
                }
            }
            System.out.print("success - getDTL_hallmin()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getDTL_hallmin()");
            closeConnection();
            e.printStackTrace();
        }
        return max;
    } // DECICATED TO the update hall capacity function
    public static int getSpecDTL_hallcap(String m_title, String m_date, String m_time, String m_hallno){
        String query = "SELECT * FROM datetimeloc WHERE m_title=\'"+m_title+"\' AND m_date=\'"+m_date+"\' AND m_time=\'"+m_time+"\' AND m_hallno=\'"+m_hallno+"\'";
        int cap=0;
        try {
            getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            //each row of data from DB
            while(result.next()){
                for(int i=1; i<=160; i++){
                    if(Integer.parseInt(result.getString(i+6))==1){
                        cap++;
                    }
                }
            }
            System.out.print("success - getDTL_hallmin()");
            closeConnection();
        } catch(Exception e){
            System.out.print("ERROR:: getDTL_hallmin()");
            closeConnection();
            e.printStackTrace();
        }
        return cap;
    }
    public static int addDTL_all(String m_title, ArrayList<ArrayList<String>> arr){
        int rowsInserted=0;
        try {
            getConnection();
            for(int i=0; i<arr.size(); i++) {
                String query = "INSERT INTO datetimeloc(m_title, m_date, m_time, m_hallno, m_capacity) VALUES(?,?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, m_title);
                statement.setString(2, arr.get(i).get(0));
                statement.setString(3, arr.get(i).get(1));
                statement.setString(3, arr.get(i).get(2));
                statement.setString(3, arr.get(i).get(3));
                statement.setString(3, arr.get(i).get(4));
                rowsInserted += statement.executeUpdate();
            }
            if (rowsInserted > 0) {
                System.out.print("success - addDTL_all()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: addDTL_all()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsInserted;
    } // pass in arr ((m_title1, m_date1, m_time1, m_hallno1, m_capacity1), (2-2-2), ...)
    public static int delDTL_all(String m_title){
        String query = "DELETE FROM datetimeloc WHERE m_title=?";
        int rowsDeleted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, m_title);
            rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.print("success - delDTL_all()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: delDTL_all()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updSpecDTL_front(String m_title, String m_date, String m_time, String m_hallno, String option, String updateValue){
        String query = "UPDATE datetimeloc SET "+option+"=? WHERE m_title=\'"+m_title+"\' AND m_date=\'"+m_date+"\' AND m_time=\'"+m_time+"\' AND m_hallno=\'"+m_hallno+"\'";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updSpecDTL_front()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updSpecDTL_front()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }
    public static int updSpecDTL_back(String m_title, String m_date, String m_time, String m_hallno, ArrayList<String> seatnums, int Book_1_Cancel_0){
        String seats="";
        Integer yn = Book_1_Cancel_0;
        for(int i=0; i<seatnums.size(); i++){
            seats = seats + seatnums.get(i) + "=" + yn.toString();
            if(i<seatnums.size()-1){
                seats+=",";
            }
        }
        String query = "UPDATE datetimeloc SET "+seats+" WHERE m_title=\'"+m_title+"\' AND m_date=\'"+m_date+"\' AND m_time=\'"+m_time+"\' AND m_hallno=\'"+m_hallno+"\'";
        int rowsUpdated=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            rowsUpdated  = statement.executeUpdate();
            if( rowsUpdated > 0) {
                System.out.print("success - updSpecDTL_back()");
            }
            closeConnection();
        } catch(Exception e) {
            System.out.print("ERROR:: updSpecDTL_back()");
            closeConnection();
            e.printStackTrace();
        }
        return rowsUpdated;
    }
}
