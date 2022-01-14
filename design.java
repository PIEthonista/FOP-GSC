import javax.swing.*;
import java.awt.*;
import feats.*;

public class design {
    // GSC Gray : 20,20,20
    // GSC Yellow: 255,245,6
    // abs Black: 0,0,0
    public static Color black = new Color(0,0,0);
    public static Color dgray = new Color(20,20,20);
    public static Color mdgray = new Color(40, 40, 40, 255);
    public static Color mgray = new Color(92,92,92);
    public static Color lgray = new Color(217,217,217);
    public static Color white = new Color(255, 255, 255);

    public static Color yellow = new Color(255,245,6);
    public static Color orange = new Color(243, 122, 0, 255);
    public static Color lred = new Color(217,87,78);

    // Font
    public static Font ss13 = new Font("Sans Serif",Font.PLAIN, 13);
    public static Font ss15 = new Font("Sans Serif",Font.PLAIN, 15);
    public static Font ss17 = new Font("Sans Serif",Font.PLAIN, 17);
    public static Font ss20 = new Font("Sans Serif",Font.PLAIN, 20);
    public static Font ss23 = new Font("Sans Serif",Font.PLAIN, 23);
    public static Font ss26i = new Font("Sans Serif",Font.ITALIC, 26);
    public static Font ss20i = new Font("Sans Serif",Font.ITALIC, 20);
    public static Font ss30i = new Font("Sans Serif",Font.ITALIC, 30);

    public static Font sui20 = new Font("Segoe UI",Font.PLAIN,20);
    public static Font sui15 = new Font("Segoe UI",Font.PLAIN,15);

    public static Font erri = new Font(null,Font.ITALIC,12);


    // Backgroud Movie Covers
    public static ImageIcon s[] = {
            new ImageIcon(FP.getPath("01.png")), //0
            new ImageIcon(FP.getPath("02.png")), //1
            new ImageIcon(FP.getPath("03.png")), //2
            new ImageIcon(FP.getPath("04.png")), //3
            new ImageIcon(FP.getPath("05.png")), //4
            new ImageIcon(FP.getPath("06.png")), //5
            new ImageIcon(FP.getPath("07.png")), //6
            new ImageIcon(FP.getPath("08.png"))  //7
    };
    public static ImageIcon img[]={
            new ImageIcon(FP.getPath("user-xxl.png")), //0
            new ImageIcon(FP.getPath("movie_list.png")) //1
    };
    public static ImageIcon s1[] = {
            new ImageIcon(FP.getPath("01+.png")), //0
            new ImageIcon(FP.getPath("02+.png")), //1
            new ImageIcon(FP.getPath("03+.png")), //2
            new ImageIcon(FP.getPath("04+.png")), //3
            new ImageIcon(FP.getPath("05+.png")), //4
            new ImageIcon(FP.getPath("06+.png")), //5
            new ImageIcon(FP.getPath("07+.png")), //6
            new ImageIcon(FP.getPath("08+.png"))  //7
    };
}
