import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class dbase{
    static Connection con;
    static Statement statement;
    private static String uname = "root";
    private static String password = "J0hnLegend";
    private static String url = "jdbc:mysql://database-1.cbv42i2cijkc.us-east-2.rds.amazonaws.com:3306/FOPGSC";
    //                                        ^Endpoint                                           ^Port^DB
    // Enabled inbound rules : ALL, IPv4 IPv6

    public static void getConnection() {
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

    public static ArrayList<String> getEmailList(){
        //predefined: url, uname, password, query
        getConnection();
        String query = "SELECT c_email FROM customer";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {                       //each row of data from DB
                arr.add(result.getString(1));
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

    public static void addCustomer(String name, String email, String uname, String pswd, String phno){
        String query = "INSERT INTO customer(c_name, c_email, c_uname, c_pswd, c_phno) VALUES(?,?,?,?,?);";
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, uname);
            statement.setString(4, pswd);
            statement.setString(5, phno);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was INSERTED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: INSERT");
            e.printStackTrace();
        }
    }
    public static void delCustomer(String uname){
        String query = "DELETE FROM customer WHERE c_uname=?";
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, uname);
            int rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.println("An old user was DELETED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: DELETE");
            e.printStackTrace();
        }
    }
    public static void updCustomer(String uname, int option, String updateValue){
        String opt="";
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
                int rowsDeleted = statement.executeUpdate();
                if( rowsDeleted > 0) {
                    System.out.println("An old user was UPDATED successfully!");
                }
                closeConnection();
            } catch(Exception e) {
                closeConnection();
                System.out.println("ERROR: QUERY: UPDATE");
                e.printStackTrace();
            }
        }
    }
    public static void updCustomer(String uname, String option, String updateValue){
        String query = "UPDATE customer SET "+option+"=? WHERE c_uname=?";
        try {
            getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, updateValue);
            statement.setString(2, uname);
            int rowsDeleted = statement.executeUpdate();
            if( rowsDeleted > 0) {
                System.out.println("An old user was UPDATED successfully!");
            }
            closeConnection();
        } catch(Exception e) {
            closeConnection();
            System.out.println("ERROR: QUERY: UPDATE");
            e.printStackTrace();
        }
    }

    /*
    static void addmov(){}
    static void getmov(){}
    static void delmov(){}

    static void addacc(){}
    static void delacc(){}
    static void authacc(){}

    static void addtrans(){}
    static void gettrans(){}

    static void bookseat(){}
    static void getseat(){}
    static void editseat(){}

    static void addfnb(){}
    static void editfnb(){}
    static void delfnb(){}
     */
}
