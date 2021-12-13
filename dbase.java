import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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

    public static String[][] getInfo(){
        //predefined: url, uname, password, query
        String query = "SELECT * FROM customer";
        String data;
        String [][] arr = new String[4][6];
        String [] temp = new String[6];
        int j=0;
        try {
            ResultSet result = statement.executeQuery(query);
            System.out.println("Received Info: ");
            while (result.next()) {                       //each row of data from DB
                data = "";
                for (int i = 1; i <= 6; i++) {
                    data += result.getString(i) + ":";    // get data from row
                    temp[i-1]=result.getString(i);
                }
                arr[j] = temp;
                j+=1;
                System.out.println(data);
            }
        } catch(Exception e){
            System.out.println("ERROR: SOMETHING WRONG WITH EXECUTING QUERY!");
            e.printStackTrace();
        }
        return arr;
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
