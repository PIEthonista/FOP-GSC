import java.io.*;
public class FP {
    public static String getPath(String relativeFileNamePath){
        String path="";
        try {
            String loc = ((System.getProperty("os.name")).toLowerCase().charAt(0) == 'w') ? (".\\" + relativeFileNamePath) : ("./" + relativeFileNamePath);
            //more on relative path: https://www.delftstack.com/howto/java/java-relative-path/
            File f = new File(loc);
            path = f.getAbsolutePath();
        }catch(Exception e){
            e.printStackTrace();
        }
        return path;
    }

    public static boolean deleteFile(String relativeFileNamePath){
        boolean status=true;
        try {
            String loc = ((System.getProperty("os.name")).toLowerCase().charAt(0) == 'w') ? (".\\" + relativeFileNamePath) : ("./" + relativeFileNamePath);
            //more on relative path: https://www.delftstack.com/howto/java/java-relative-path/
            File f2 = new File(new File(loc).getAbsolutePath());
            if(f2.delete()){}else{status=false;}
        }catch(Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }
}
