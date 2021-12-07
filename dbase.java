import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbase{
    // SQL methods
    public static void getConnection(){
        String url = "jdbc:mysql://database-2.cbv42i2cijkc.us-east-2.rds.amazonaws.com:3306/database-2";
        String uname = "CuteNigga";
        String password = "J0hnLegend";
        //String query = "CREATE TABLE movie(No INT AUTO_INCREMENT, title VARCHAR(100), reldate DATE, showdate DATE, casts VARCHAR(1000), synopsis VARCHAR(10000));";
        String data = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("classforname");
            //esentially checking if the required Driver is there.
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, uname, password);
            System.out.println("con");
            Statement statement = con.createStatement();
            System.out.println("statement");
            con.close();
            //ResultSet result = statement.executeQuery(query);
            /*
            while(result.next()){  //each row of data from DB
                data = "";
                for(int i=1; i<=8; i++){
                    data += result.getString(i) + ":";  // get data from row
                }
                System.out.println(data);
            }
            */
        } catch (SQLException e){
            e.printStackTrace();
        }

    /*
    static void createmovTBL(){

    }
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


    static String[] getData(int i) throws Exception{   // =========Used for printing title when given number
        // No,Title,ReleaseDate,ShowDate,Actor1:Character1|Actor2:Charater2... ,synopsis
        File f = new File("./movi.csv");
        Scanner sc = new Scanner(new File(f.getAbsolutePath()));
        // "/Users/gohyixian/Documents/jvprojects/GSC/movi.csv"
        sc.useDelimiter(",");   //sets the delimiter pattern
        String [] data = {"No", "Title", "RelDate", "ShowDate", "Casts", "Synopsis"};
        //                 1     2        3          4           5        6
        int count = 1;
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if (count==i){
                data[0]=dbase.getInfo(str, 1, ',');
                data[1]=dbase.getInfo(str, 2, ',');
                data[2]=dbase.getInfo(str, 3, ',');
                data[3]=dbase.getInfo(str, 4, ',');
                data[4]=dbase.getInfo(str, 5, ',');
                data[5]=dbase.getInfo(str, 6, ',');
            }
            count+=1;
        }
        sc.close();
        return data;
    }


    static String getInfo(String str, int j, char sep) throws Exception {
        ArrayList<String> arr = new ArrayList<String>();
        int st=0;
        int en=0;
        int c=1;
        for (int i=0; i<str.length(); i++){
            if (i==(str.length()-1)){
                arr.add(str.substring((st+1), i) + str.charAt(i));
                break;
            }
            if (str.charAt(i)==sep){
                en=i;
                if(c!=1){
                    st+=1;
                }
                arr.add(str.substring(st, en));
                st=en;
                c++;
            }
        }
        return arr.get(j-1);
        /*  //Doesn't work why??
        if (i>5){
            throw new Exception("ERROR: range 1-5 only.");
        }
        Pattern pat = Pattern.compile("[0-9]++,([A-Za-z0-9 ][\\_\'-]++),([A-Za-z0-9 ][\\_\'-]++),([A-Za-z0-9 ][\\_\'-]++),([A-Za-z0-9 ][\\_\'-]++),");
                                              // paste ,([A-za-z0-9 -+=_~!@#$%^&8<>./\']+?) after adding synopsis
        System.out.println("Hi");
        Matcher mat = pat.matcher(str);

        return mat.group(i);

        if(mat.find()){
            return mat.group(i);
        } else {
            return "N/A";
        }
        */
    }
}