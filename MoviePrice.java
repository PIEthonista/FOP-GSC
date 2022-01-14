import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import feats.*;

public class MoviePrice implements ActionListener{

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Movie Price Setting");
    JLabel label = new JLabel();
    JLabel Adultplabel = new JLabel("Adult");
    JLabel Childrenplabel = new JLabel("Children");
    JLabel Studentplabel = new JLabel("Student");
    JTextField AdultpField1 = new JTextField();
    JTextField ChildrenpField1 = new JTextField();
    JTextField StudentpField1 = new JTextField();
    JTextField AdultpField2 = new JTextField();
    JTextField ChildrenpField2 = new JTextField();
    JTextField StudentpField2 = new JTextField();
    JTextField AdultpField3 = new JTextField();
    JTextField ChildrenpField3 = new JTextField();
    JTextField StudentpField3 = new JTextField();
    JTextField AdultpField4 = new JTextField();
    JTextField ChildrenpField4 = new JTextField();
    JTextField StudentpField4 = new JTextField();
    JTextField AdultpField5 = new JTextField();
    JTextField ChildrenpField5 = new JTextField();
    JTextField StudentpField5 = new JTextField();
    JTextField AdultpField6 = new JTextField();
    JTextField ChildrenpField6 = new JTextField();
    JTextField StudentpField6 = new JTextField();
    JTextField AdultpField7 = new JTextField();
    JTextField ChildrenpField7 = new JTextField();
    JTextField StudentpField7 = new JTextField();
    JTextField AdultpField8 = new JTextField();
    JTextField ChildrenpField8 = new JTextField();
    JTextField StudentpField8 = new JTextField();
    ArrayList<ArrayList<String>> arr;
    JLabel pgnum = new JLabel();
    JLabel l3,l4,l5,l6,l7,l8,l9,l10 = new JLabel();
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+staff.uname);
    JButton prev = new JButton("Previous");
    JButton next = new JButton("Next");
    JButton Done = new JButton("Done");

    public MoviePrice(int section){

        arr = dbase.getAllMovies();
        movi.arrRESET();
        int i=0;
        int sec;
        // 1D=Spec movie ArrList,  2D=Page ArrList, 3D=Page Container
        for(sec=0; sec<arr.size()/8; sec++){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int j=0; j<8; j++){
                temp.add(arr.get(i));
                i++;
            }
            movi.arr.add(temp);
        }
        if(arr.size()%8!=0){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int k=0; k<arr.size()%8; k++){
                temp.add(arr.get(i));
                i++;
            }
            movi.arr.add(temp);
        }

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        Adultplabel.setBounds(500, 130, 100, 30);
        Adultplabel.setBackground(new Color(50, 50, 50));
        Adultplabel.setOpaque(true);
        Adultplabel.setFont(design.sui20);
        Adultplabel.setForeground(design.lgray);
        Adultplabel.setHorizontalAlignment(JLabel.CENTER);

        Childrenplabel.setBounds(700, 130, 100, 30);
        Childrenplabel.setBackground(new Color(50, 50, 50));
        Childrenplabel.setOpaque(true);
        Childrenplabel.setFont(design.sui20);
        Childrenplabel.setForeground(design.lgray);
        Childrenplabel.setHorizontalAlignment(JLabel.CENTER);

        Studentplabel.setBounds(900, 130, 100, 30);
        Studentplabel.setBackground(new Color(50, 50, 50));
        Studentplabel.setOpaque(true);
        Studentplabel.setFont(design.sui20);
        Studentplabel.setForeground(design.lgray);
        Studentplabel.setHorizontalAlignment(JLabel.CENTER);

        pgnum.setBounds(130,80,990,30);
        pgnum.setBackground(design.dgray);
        pgnum.setOpaque(true);
        pgnum.setHorizontalAlignment(JLabel.CENTER);
        pgnum.setFont(design.ss13);
        pgnum.setForeground(design.mgray);
        pgnum.setText("Page "+(movi.section+1)+" / "+movi.arr.size());

        prevpage.setBounds(675,33,200,40);
        prevpage.setVerticalAlignment(JLabel.CENTER);
        prevpage.setBackground(design.dgray);
        prevpage.setForeground(design.lgray);
        prevpage.setFocusable(false);
        prevpage.setHorizontalAlignment(JLabel.CENTER);
        prevpage.setFont(design.ss15);    //yx
        prevpage.addActionListener(this);

        logout.setBounds(875, 33, 280, 40);    //yx
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);    //yx
        logout.addActionListener(this);

        prev.setBounds(24,120,100,38);
        prev.setVerticalAlignment(JLabel.CENTER);
        prev.setBackground(design.yellow);
        prev.setForeground(design.dgray);
        prev.setFocusable(false);
        prev.setHorizontalAlignment(JLabel.CENTER);
        prev.setFont(design.sui15);    //yx
        prev.addActionListener(this);

        next.setBounds(1140,120,80,38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);

        Done.setBounds(1050,120,80,38);
        Done.setVerticalAlignment(JLabel.CENTER);
        Done.setBackground(design.mgray);
        Done.setForeground(design.lgray);
        Done.setFocusable(false);
        Done.setHorizontalAlignment(JLabel.CENTER);
        Done.setFont(design.ss15);
        Done.addActionListener(this);

        int y=20;
        int y1=5; //10
        int y2=15;
        int c=movi.arr.get(movi.section).size();

        if(1<=c){
            AdultpField1.setBounds(500, 188 , 100, 30);
            AdultpField1.setFont(design.ss20i);
            AdultpField1.setForeground(design.mgray);
            AdultpField1.setBackground(design.lgray);
            ChildrenpField1.setBounds(700, 188 , 100, 30);
            ChildrenpField1.setFont(design.ss20i);
            ChildrenpField1.setForeground(design.mgray);
            ChildrenpField1.setBackground(design.lgray);
            StudentpField1.setBounds(900, 188 , 100, 30);
            StudentpField1.setFont(design.ss20i);
            StudentpField1.setForeground(design.mgray);
            StudentpField1.setBackground(design.lgray);
            frame.add(AdultpField1);
            frame.add(ChildrenpField1);
            frame.add(StudentpField1);
            ln3 = new JLabel();
            ln3.setBounds(25, 163+y1,1200, 1);
            ln3.setOpaque(true);
            ln3.setBackground(design.mgray);
            frame.add(ln3);
            //
            String t3=getText(movi.arr.get(movi.section).get(0).get(1));
            l3 = new JLabel(t3.substring(0,50));
            l3.setBounds(40, 163+y2, 600, 38);
            l3.setOpaque(true);
            l3.setBackground(design.dgray);
            l3.setForeground(design.lgray);
            l3.setFont(design.ss20i);
            frame.add(l3);
        }
        if(2<=c){
            AdultpField2.setBounds(500, 250 , 100, 30);
            AdultpField2.setFont(design.ss20i);
            AdultpField2.setForeground(design.mgray);
            AdultpField2.setBackground(design.lgray);
            ChildrenpField2.setBounds(700, 250 , 100, 30);
            ChildrenpField2.setFont(design.ss20i);
            ChildrenpField2.setForeground(design.mgray);
            ChildrenpField2.setBackground(design.lgray);
            StudentpField2.setBounds(900, 250 , 100, 30);
            StudentpField2.setFont(design.ss20i);
            StudentpField2.setForeground(design.mgray);
            StudentpField2.setBackground(design.lgray);
            frame.add(AdultpField2);
            frame.add(ChildrenpField2);
            frame.add(StudentpField2);
            ln4 = new JLabel();
            ln4.setBounds(25, 225+y1,1200, 1);
            ln4.setOpaque(true);
            ln4.setBackground(design.mgray);
            frame.add(ln4);
            String t4=getText(movi.arr.get(movi.section).get(1).get(1));
            l4 = new JLabel(t4.substring(0,50));
            l4.setBounds(40, 225+y2, 600, 38);
            l4.setOpaque(true);
            l4.setBackground(design.dgray);
            l4.setForeground(design.lgray);
            l4.setFont(design.ss20i);
            frame.add(l4);
        }
        if(3<=c){
            AdultpField3.setBounds(500, 313 , 100, 30);
            AdultpField3.setFont(design.ss20i);
            AdultpField3.setForeground(design.mgray);
            AdultpField3.setBackground(design.lgray);
            ChildrenpField3.setBounds(700, 313 , 100, 30);
            ChildrenpField3.setFont(design.ss20i);
            ChildrenpField3.setForeground(design.mgray);
            ChildrenpField3.setBackground(design.lgray);
            StudentpField3.setBounds(900, 313 , 100, 30);
            StudentpField3.setFont(design.ss20i);
            StudentpField3.setForeground(design.mgray);
            StudentpField3.setBackground(design.lgray);
            frame.add(AdultpField3);
            frame.add(ChildrenpField3);
            frame.add(StudentpField3);
            ln5 = new JLabel();
            ln5.setBounds(25, 288+y1,1200, 1);
            ln5.setOpaque(true);
            ln5.setBackground(design.mgray);
            frame.add(ln5);
            //
            String t5=getText(movi.arr.get(movi.section).get(2).get(1));
            l5 = new JLabel(t5.substring(0,50));
            l5.setBounds(40, 288+y2, 600, 38);
            l5.setOpaque(true);
            l5.setBackground(design.dgray);
            l5.setForeground(design.lgray);
            l5.setFont(design.ss20i);
            frame.add(l5);

        }
        if(4<=c){
            AdultpField4.setBounds(500, 375 , 100, 30);
            AdultpField4.setFont(design.ss20i);
            AdultpField4.setForeground(design.mgray);
            AdultpField4.setBackground(design.lgray);
            ChildrenpField4.setBounds(700, 375 , 100, 30);
            ChildrenpField4.setFont(design.ss20i);
            ChildrenpField4.setForeground(design.mgray);
            ChildrenpField4.setBackground(design.lgray);
            StudentpField4.setBounds(900, 375 , 100, 30);
            StudentpField4.setFont(design.ss20i);
            StudentpField4.setForeground(design.mgray);
            StudentpField4.setBackground(design.lgray);
            frame.add(AdultpField4);
            frame.add(ChildrenpField4);
            frame.add(StudentpField4);
            ln6 = new JLabel();
            ln6.setBounds(25, 350+y1,1200, 1);
            ln6.setOpaque(true);
            ln6.setBackground(design.mgray);
            frame.add(ln6);
            String t6=getText(movi.arr.get(movi.section).get(3).get(1));
            l6 = new JLabel(t6.substring(0,50));
            l6.setBounds(40, 350+y2, 600, 38);
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss20i);
            frame.add(l6);
        }
        if(5<=c){
            AdultpField5.setBounds(500, 438 , 100, 30);
            AdultpField5.setFont(design.ss20i);
            AdultpField5.setForeground(design.mgray);
            AdultpField5.setBackground(design.lgray);
            ChildrenpField5.setBounds(700, 438 , 100, 30);
            ChildrenpField5.setFont(design.ss20i);
            ChildrenpField5.setForeground(design.mgray);
            ChildrenpField5.setBackground(design.lgray);
            StudentpField5.setBounds(900, 438 , 100, 30);
            StudentpField5.setFont(design.ss20i);
            StudentpField5.setForeground(design.mgray);
            StudentpField5.setBackground(design.lgray);
            frame.add(AdultpField5);
            frame.add(ChildrenpField5);
            frame.add(StudentpField5);
            ln7 = new JLabel();
            ln7.setBounds(25, 413+y1,1200, 1);
            ln7.setOpaque(true);
            ln7.setBackground(design.mgray);
            frame.add(ln7);
            //
            String t7=getText(movi.arr.get(movi.section).get(4).get(1));
            l7 = new JLabel(t7.substring(0,50));
            l7.setBounds(40, 413+y2, 600, 38);
            l7.setOpaque(true);
            l7.setBackground(design.dgray);
            l7.setForeground(design.lgray);
            l7.setFont(design.ss20i);
            frame.add(l7);
        }
        if(6<=c){
            AdultpField6.setBounds(500, 500 , 100, 30);
            AdultpField6.setFont(design.ss20i);
            AdultpField6.setForeground(design.mgray);
            AdultpField6.setBackground(design.lgray);
            ChildrenpField6.setBounds(700, 500 , 100, 30);
            ChildrenpField6.setFont(design.ss20i);
            ChildrenpField6.setForeground(design.mgray);
            ChildrenpField6.setBackground(design.lgray);
            StudentpField6.setBounds(900, 500 , 100, 30);
            StudentpField6.setFont(design.ss20i);
            StudentpField6.setForeground(design.mgray);
            StudentpField6.setBackground(design.lgray);
            frame.add(AdultpField6);
            frame.add(ChildrenpField6);
            frame.add(StudentpField6);
            ln8 = new JLabel();
            ln8.setBounds(25, 475+y1,1200, 1);
            ln8.setOpaque(true);
            ln8.setBackground(design.mgray);
            frame.add(ln8);
            //
            String t8=getText(movi.arr.get(movi.section).get(5).get(1));
            l8 = new JLabel(t8.substring(0,50));
            l8.setBounds(40, 475+y2, 600, 38);
            l8.setOpaque(true);
            l8.setBackground(design.dgray);
            l8.setForeground(design.lgray);
            l8.setFont(design.ss20i);
            frame.add(l8);
        }
        if(7<=c){
            AdultpField7.setBounds(500, 563 , 100, 30);
            AdultpField7.setFont(design.ss20i);
            AdultpField7.setForeground(design.mgray);
            AdultpField7.setBackground(design.lgray);
            ChildrenpField7.setBounds(700, 563 , 100, 30);
            ChildrenpField7.setFont(design.ss20i);
            ChildrenpField7.setForeground(design.mgray);
            ChildrenpField7.setBackground(design.lgray);
            StudentpField7.setBounds(900, 563 , 100, 30);
            StudentpField7.setFont(design.ss20i);
            StudentpField7.setForeground(design.mgray);
            StudentpField7.setBackground(design.lgray);
            frame.add(AdultpField7);
            frame.add(ChildrenpField7);
            frame.add(StudentpField7);
            ln9 = new JLabel();
            ln9.setBounds(25, 538+y1,1200, 1);
            ln9.setOpaque(true);
            ln9.setBackground(design.mgray);
            frame.add(ln9);
            //
            String t9=getText(movi.arr.get(movi.section).get(6).get(1));
            l9 = new JLabel(t9.substring(0,50));
            l9.setBounds(40, 538+y2, 600, 38);
            l9.setOpaque(true);
            l9.setBackground(design.dgray);
            l9.setForeground(design.lgray);
            l9.setFont(design.ss20i);
            frame.add(l9);
        }
        if(8<=c){
            AdultpField8.setBounds(500, 625 , 100, 30);
            AdultpField8.setFont(design.ss20i);
            AdultpField8.setForeground(design.mgray);
            AdultpField8.setBackground(design.lgray);
            ChildrenpField8.setBounds(700, 625 , 100, 30);
            ChildrenpField8.setFont(design.ss20i);
            ChildrenpField8.setForeground(design.mgray);
            ChildrenpField8.setBackground(design.lgray);
            StudentpField8.setBounds(900, 625 , 100, 30);
            StudentpField8.setFont(design.ss20i);
            StudentpField8.setForeground(design.mgray);
            StudentpField8.setBackground(design.lgray);
            frame.add(AdultpField8);
            frame.add(ChildrenpField8);
            frame.add(StudentpField8);
            ln10 = new JLabel();
            ln10.setBounds(25, 600+y1,1200, 1);
            ln10.setOpaque(true);
            ln10.setBackground(design.mgray);
            frame.add(ln10);
            //
            String t10=getText(movi.arr.get(movi.section).get(7).get(1));
            l10 = new JLabel(t10.substring(0,50));
            l10.setBounds(40, 600+y2, 600, 38);
            l10.setOpaque(true);
            l10.setBackground(design.dgray);
            l10.setForeground(design.lgray);
            l10.setFont(design.ss20i);
            frame.add(l10);
        }

        label.add(prevpage); // prev page
        label.add(logout);
        if(movi.section!=0){
            label.add(Done);
            label.add(prev);
        }
        if(movi.section!=movi.arr.size()-1){
            label.add(next);
        }
        frame.add(Adultplabel);
        frame.add(Childrenplabel);
        frame.add(Studentplabel);
        frame.add(pgnum);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static String getText(String title){
        String re = "";
        ArrayList<ArrayList<String>> arr = dbase.getDTL_front(title);
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < arr.size(); i++) {
            h.put(arr.get(i).get(2), i);
        }
        String[] s = h.keySet().toArray(new String[0]);
        String[] m = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayList<String> a = dbase.getMovies(0, title);
        String mon = m[Integer.parseInt(a.get(2).substring(5, 7)) - 1];
        // YYYY-MM-DD
        // 0123456789        0-50  |-51              ||-73,74
        re += String.format("%-50s Released: %2s %-9s Showtimes: ", title, a.get(2).substring(8).charAt(0) == '0' ? " " + a.get(2).substring(9) : a.get(2).substring(8), mon);
        for (int i = 0; i < 3; i++) {
            if (i < s.length) {
                re += s[i].substring(8) + "/" + s[i].substring(5, 7) + "  ";
            }
        }
        //System.out.println(re);
        return re;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            movi.section=0;
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource()==prev) {
            if (movi.section == 0) {
                new MoviePrice(0);
                frame.dispose();
            } else {
                movi.section--;
                new MoviePrice(movi.section);
                frame.dispose();
            }
        }
        if (e.getSource() == Done) {
            if (movi.section == 0) {
            new SettingMovie();
            frame.dispose();
        } else {
               movi.section--;
               new SettingMovie();
               frame.dispose();
            }
        }
        if (e.getSource()==next){
            if(movi.section==movi.arr.size()-1){
                new MoviePrice(movi.section);
                frame.dispose();
            } else {
                movi.section++;
                new MoviePrice(movi.section);
                frame.dispose();
            }
        }
        if (e.getSource()==logout){
            staff.RESET();
            movi.section=0;
            new CoverPage();
            frame.dispose();
        }
    }
}
