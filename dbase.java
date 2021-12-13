import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("ERROR: FAILED TO ESTABLISH CONNECTION!\nCheck the below:\n - WiFi Connection\n - service url\n - Master username\n - Password");
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try{
            con.close();
            System.out.println("Connection Closed");
        } catch (Exception e){
            System.out.println("ERROR: CONNECTION CANNOT BE CLOSED!");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getEmailList(){
        //predefined: url, uname, password, query
        String query = "SELECT c_email FROM customer";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            ResultSet result = statement.executeQuery(query);
            System.out.println("Received Info: ");
            while (result.next()) {                       //each row of data from DB
                arr.add(result.getString(1));
            }
        } catch(Exception e){
            System.out.println("ERROR: SOMETHING WRONG WITH EXECUTING QUERY!");
            e.printStackTrace();
        }
        return arr;
    }

    public static void addCustomer(String name, String email, String uname, String pswd, String phno){
        String query = "INSERT INTO customer(c_name, c_email, c_uname, c_pswd, c_phno) VALUES(\'"+name+"\',\'"+email+"\',\'"+uname+"\',\'"+pswd+"\',\'"+phno+"\');";
        try {
            con.setAutoCommit(false);
            statement.addBatch(query);
            System.out.println("Succesfully added to database!");
        } catch(Exception e){
            System.out.println("ERROR: SOMETHING WRONG WITH EXECUTING QUERY!");
            e.printStackTrace();
        } finally {
            try{
                con.setAutoCommit(true);
            } catch (Exception e){
                e.printStackTrace();
            }
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
