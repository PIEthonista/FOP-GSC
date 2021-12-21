import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


public class dbase{
    static Connection con;
    static Statement statement;
    private static String uname = "root";
    private static String password = "J0hnLegend";
    private static String url = "jdbc:mysql://database-1.cbv42i2cijkc.us-east-2.rds.amazonaws.com:3306/FOPGSC";
    //                                        ^Endpoint                                           ^Port^DB
    // Enabled inbound rules : ALL, IPv4 IPv6

    public static void getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //esentially checking if the required Driver is there.
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: 'com.mysql.cj.jdbc.Driver' MISSING!");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, uname, password);
            statement = con.createStatement();
            System.out.println("Con Established");
        } catch (SQLException e) {
            System.out.println("ERROR: FAILED TO ESTABLISH CONNECTION!\nCheck the below:\n - WiFi Connection\n - service url\n - Master username\n - Password");
            e.printStackTrace();
        }
    }
    public static void closeConnection(){
        try{
            con.close();
            System.out.println("Con Closed");
            System.out.println("----------");
        } catch (Exception e){
            System.out.println("ERROR: CONNECTION CANNOT BE CLOSED!");
            e.printStackTrace();
        }
    }

    //customer
    public static ArrayList<String> getCustomer(String uname){
        getConnection();
        String query = "SELECT * FROM customer WHERE c_uname=\'"+uname+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
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
            System.out.println("Information retrieved successfully");
            closeConnection();
        } catch(Exception e){
            closeConnection();
            System.out.println("ERROR: QUERY: SELECT");
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
                System.out.println("A new user was INSERTED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: INSERT");
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
                System.out.println("An old user was DELETED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: DELETE");
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updCustomer(String uname, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>5){
            System.out.println("ERROR: Option "+option+" out of bound 1-5");
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
                    System.out.println("An old user was UPDATED successfully!");
                }
                closeConnection();
            } catch(Exception e) {
                closeConnection();
                System.out.println("ERROR: QUERY: UPDATE");
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
                System.out.println("An old user was UPDATED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: UPDATE");
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //staff TO TEST
    public static ArrayList<String> getStaff(String uname){
        getConnection();
        String query = "SELECT * FROM staff WHERE s_uname=\'"+uname+"\'";
        ArrayList<String> arr = new ArrayList<String>();
        try {
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
            System.out.println("Information retrieved successfully");
            closeConnection();
        } catch(Exception e){
            closeConnection();
            System.out.println("ERROR: QUERY: SELECT");
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
                System.out.println("A new staff was INSERTED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: INSERT");
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
                System.out.println("An old staff was DELETED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: DELETE");
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updStaff(String uname, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>5){
            System.out.println("ERROR: Option "+option+" out of bound 1-5");
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
                    System.out.println("An old staff was UPDATED successfully!");
                }
                closeConnection();
            } catch(Exception e) {
                closeConnection();
                System.out.println("ERROR: QUERY: UPDATE");
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
                System.out.println("An old staff was UPDATED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: UPDATE");
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    //fnb
    public static ArrayList<ArrayList<String>> getFNB(){
        getConnection();
        String query = "SELECT * FROM fnb";
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            int col = rsmd.getColumnCount();
            //each row of data from DB
            while(result.next()){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(result.getString(1));
                temp.add(result.getString(2));
                temp.add(result.getString(3));
                temp.add(result.getString(4));
                arr.add(temp);
            }
            System.out.println("Information retrieved successfully");
            closeConnection();
        } catch(Exception e){
            closeConnection();
            System.out.println("ERROR: QUERY: SELECT");
            e.printStackTrace();
        }
        return arr;
    }
    public static int addFNB(String name, String desc, int price){
        String query = "INSERT INTO fnb(f_name, f_desc, f_price) VALUES(?,?,?);";
        int rowsInserted=0;
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setString(3, String.valueOf(price));
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new FNB was INSERTED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: INSERT");
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
                System.out.println("An old FNB was DELETED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: DELETE");
            e.printStackTrace();
        }
        return rowsDeleted;
    }
    public static int updFNB(String name, int option, String updateValue){
        String opt="";
        int rowsUpdated=0;
        if(option<1 || option>3){
            System.out.println("ERROR: Option "+option+" out of bound 1-3");
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
                    System.out.println("An old FNB was UPDATED successfully!");
                }
                closeConnection();
            } catch(Exception e) {
                closeConnection();
                System.out.println("ERROR: QUERY: UPDATE");
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
                System.out.println("An old FNB was UPDATED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: UPDATE");
            e.printStackTrace();
        }
        return rowsUpdated;
    }
    /*
    static void addmov(){}
    static void getmov(){}
    static void delmov(){}

    static void authacc(){}

    static void addtrans(){}
    static void gettrans(){}

    static void bookseat(){}
    static void getseat(){}
    static void editseat(){}
     */
}
