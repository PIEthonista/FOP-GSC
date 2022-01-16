// main driver code

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import feats.*;

public class Main{
    public static void main(String [] args){
        CoverPage coverpage = new CoverPage();
        JOptionPane.showMessageDialog(null,"In order for the program to run, please run 'FOPGSC Setup.sql' in MySQL workbench\nor any other MySQL Database editor to setup the required local database.\nYou will be prompted to enter your local MySQL username & password.\nAlso, remember to turn on the WIFI connection!");
        dbase.SQLsetup(0);
    }
}
