import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class BookMovie implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label = new JLabel();
    ArrayList<ArrayList<String>> arr;
    JLabel pgnum=new JLabel(),l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10;
    JLabel l33,l44,l55,l66,l77,l88,l99,l1010;
    JLabel l3l,l4l,l5l,l6l,l7l,l8l,l9l,l10l;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton prev = new JButton("Previous"), next = new JButton("Next");
    JButton myButton3, myButton4, myButton5, myButton6, myButton7, myButton8, myButton9, myButton10;


    BookMovie(int section){
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
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        pgnum.setBounds(130,130,990,30);
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

        next.setBounds(1126,120,100,38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);



        int y=20;
        int y1=5; //10
        int y2=15;
        int c=movi.arr.get(movi.section).size();

        if(1<=c){
            myButton3 = new JButton("Book");
            myButton3.setBounds(1150,163+y,70,38);
            myButton3.setVerticalAlignment(JLabel.CENTER);
            myButton3.setBackground(design.yellow);
            myButton3.setForeground(design.dgray);
            myButton3.setFocusable(false);
            myButton3.setHorizontalAlignment(JLabel.CENTER);
            myButton3.setFont(design.sui15);    //yx
            myButton3.addActionListener(this);
            label.add(myButton3);
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
            l33 = new JLabel(t3.substring(51,73));
            l33.setBounds(650, 163+2+y2, 200, 38);
            l33.setOpaque(true);
            l33.setBackground(design.dgray);
            l33.setForeground(design.lgray);
            l33.setFont(design.ss15);
            frame.add(l33);
            //
            l3l = new JLabel(t3.substring(74));
            l3l.setBounds(855, 163+2+y2, 290, 38);
            l3l.setOpaque(true);
            l3l.setBackground(design.dgray);
            l3l.setForeground(design.lgray);
            l3l.setFont(design.ss15);
            frame.add(l3l);
        }
        if(2<=c){
            myButton4 = new JButton("Book");
            myButton4.setBounds(1150,225+y,70,38);
            myButton4.setVerticalAlignment(JLabel.CENTER);
            myButton4.setBackground(design.yellow);
            myButton4.setForeground(design.dgray);
            myButton4.setFocusable(false);
            myButton4.setHorizontalAlignment(JLabel.CENTER);
            myButton4.setFont(design.sui15);    //yx
            myButton4.addActionListener(this);
            label.add(myButton4);
            ln4 = new JLabel();
            ln4.setBounds(25, 225+y1,1200, 1);
            ln4.setOpaque(true);
            ln4.setBackground(design.mgray);
            frame.add(ln4);
            //
            String t4=getText(movi.arr.get(movi.section).get(1).get(1));
            l4 = new JLabel(t4.substring(0,50));
            l4.setBounds(40, 225+y2, 600, 38);
            l4.setOpaque(true);
            l4.setBackground(design.dgray);
            l4.setForeground(design.lgray);
            l4.setFont(design.ss20i);
            frame.add(l4);
            l44 = new JLabel(t4.substring(51,73));
            l44.setBounds(650, 225+2+y2, 200, 38);
            l44.setOpaque(true);
            l44.setBackground(design.dgray);
            l44.setForeground(design.lgray);
            l44.setFont(design.ss15);
            frame.add(l44);
            //
            l4l = new JLabel(t4.substring(74));
            l4l.setBounds(855, 225+2+y2, 290, 38);
            l4l.setOpaque(true);
            l4l.setBackground(design.dgray);
            l4l.setForeground(design.lgray);
            l4l.setFont(design.ss15);
            frame.add(l4l);
        }
        if(3<=c){
            myButton5 = new JButton("Book");
            myButton5.setBounds(1150,288+y,70,38);
            myButton5.setVerticalAlignment(JLabel.CENTER);
            myButton5.setBackground(design.yellow);
            myButton5.setForeground(design.dgray);
            myButton5.setFocusable(false);
            myButton5.setHorizontalAlignment(JLabel.CENTER);
            myButton5.setFont(design.sui15);    //yx
            myButton5.addActionListener(this);
            label.add(myButton5);
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
            l55 = new JLabel(t5.substring(51,73));
            l55.setBounds(650, 288+2+y2, 200, 38);
            l55.setOpaque(true);
            l55.setBackground(design.dgray);
            l55.setForeground(design.lgray);
            l55.setFont(design.ss15);
            frame.add(l55);
            //
            l5l = new JLabel(t5.substring(74));
            l5l.setBounds(855, 288+2+y2, 290, 38);
            l5l.setOpaque(true);
            l5l.setBackground(design.dgray);
            l5l.setForeground(design.lgray);
            l5l.setFont(design.ss15);
            frame.add(l5l);
        }
        if(4<=c){
            myButton6 = new JButton("Book");
            myButton6.setBounds(1150,350+y,70,38);
            myButton6.setVerticalAlignment(JLabel.CENTER);
            myButton6.setBackground(design.yellow);
            myButton6.setForeground(design.dgray);
            myButton6.setFocusable(false);
            myButton6.setHorizontalAlignment(JLabel.CENTER);
            myButton6.setFont(design.sui15);    //yx
            myButton6.addActionListener(this);
            label.add(myButton6);
            ln6 = new JLabel();
            ln6.setBounds(25, 350+y1,1200, 1);
            ln6.setOpaque(true);
            ln6.setBackground(design.mgray);
            frame.add(ln6);
            //
            String t6=getText(movi.arr.get(movi.section).get(3).get(1));
            l6 = new JLabel(t6.substring(0,50));
            l6.setBounds(40, 350+y2, 600, 38);
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss20i);
            frame.add(l6);
            l66 = new JLabel(t6.substring(51,73));
            l66.setBounds(650, 350+2+y2, 200, 38);
            l66.setOpaque(true);
            l66.setBackground(design.dgray);
            l66.setForeground(design.lgray);
            l66.setFont(design.ss15);
            frame.add(l66);
            //
            l6l = new JLabel(t6.substring(74));
            l6l.setBounds(855, 350+2+y2, 290, 38);
            l6l.setOpaque(true);
            l6l.setBackground(design.dgray);
            l6l.setForeground(design.lgray);
            l6l.setFont(design.ss15);
            frame.add(l6l);
        }
        if(5<=c){
            myButton7 = new JButton("Book");
            myButton7.setBounds(1150,413+y,70,38);
            myButton7.setVerticalAlignment(JLabel.CENTER);
            myButton7.setBackground(design.yellow);
            myButton7.setForeground(design.dgray);
            myButton7.setFocusable(false);
            myButton7.setHorizontalAlignment(JLabel.CENTER);
            myButton7.setFont(design.sui15);    //yx
            myButton7.addActionListener(this);
            label.add(myButton7);
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
            l77 = new JLabel(t7.substring(51,73));
            l77.setBounds(650, 413+2+y2, 200, 38);
            l77.setOpaque(true);
            l77.setBackground(design.dgray);
            l77.setForeground(design.lgray);
            l77.setFont(design.ss15);
            frame.add(l77);
            //
            l7l = new JLabel(t7.substring(74));
            l7l.setBounds(855, 413+2+y2, 290, 38);
            l7l.setOpaque(true);
            l7l.setBackground(design.dgray);
            l7l.setForeground(design.lgray);
            l7l.setFont(design.ss15);
            frame.add(l7l);
        }
        if(6<=c){
            myButton8 = new JButton("Book");
            myButton8.setBounds(1150,475+y,70,38);
            myButton8.setVerticalAlignment(JLabel.CENTER);
            myButton8.setBackground(design.yellow);
            myButton8.setForeground(design.dgray);
            myButton8.setFocusable(false);
            myButton8.setHorizontalAlignment(JLabel.CENTER);
            myButton8.setFont(design.sui15);    //yx
            myButton8.addActionListener(this);
            label.add(myButton8);
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
            l88 = new JLabel(t8.substring(51,73));
            l88.setBounds(650, 475+2+y2, 200, 38);
            l88.setOpaque(true);
            l88.setBackground(design.dgray);
            l88.setForeground(design.lgray);
            l88.setFont(design.ss15);
            frame.add(l88);
            //
            l8l = new JLabel(t8.substring(74));
            l8l.setBounds(855, 475+2+y2, 290, 38);
            l8l.setOpaque(true);
            l8l.setBackground(design.dgray);
            l8l.setForeground(design.lgray);
            l8l.setFont(design.ss15);
            frame.add(l8l);
        }
        if(7<=c){
            myButton9 = new JButton("Book");
            myButton9.setBounds(1150,538+y,70,38);
            myButton9.setVerticalAlignment(JLabel.CENTER);
            myButton9.setBackground(design.yellow);
            myButton9.setForeground(design.dgray);
            myButton9.setFocusable(false);
            myButton9.setHorizontalAlignment(JLabel.CENTER);
            myButton9.setFont(design.sui15);    //yx
            myButton9.addActionListener(this);
            label.add(myButton9);
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
            l99 = new JLabel(t9.substring(51,73));
            l99.setBounds(650, 538+2+y2, 200, 38);
            l99.setOpaque(true);
            l99.setBackground(design.dgray);
            l99.setForeground(design.lgray);
            l99.setFont(design.ss15);
            frame.add(l99);
            //
            l9l = new JLabel(t9.substring(74));
            l9l.setBounds(855, 538+2+y2, 290, 38);
            l9l.setOpaque(true);
            l9l.setBackground(design.dgray);
            l9l.setForeground(design.lgray);
            l9l.setFont(design.ss15);
            frame.add(l9l);
        }
        if(8<=c){
            myButton10 = new JButton("Book");
            myButton10.setBounds(1150,600+y,70,38);
            myButton10.setVerticalAlignment(JLabel.CENTER);
            myButton10.setBackground(design.yellow);
            myButton10.setForeground(design.dgray);
            myButton10.setFocusable(false);
            myButton10.setHorizontalAlignment(JLabel.CENTER);
            myButton10.setFont(design.sui15);    //yx
            myButton10.addActionListener(this);
            label.add(myButton10);
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
            l1010 = new JLabel(t10.substring(51,73));
            l1010.setBounds(650, 600+2+y2, 200, 38);
            l1010.setOpaque(true);
            l1010.setBackground(design.dgray);
            l1010.setForeground(design.lgray);
            l1010.setFont(design.ss15);
            frame.add(l1010);
            //
            l10l = new JLabel(t10.substring(74));
            l10l.setBounds(855, 600+2+y2, 290, 38);
            l10l.setOpaque(true);
            l10l.setBackground(design.dgray);
            l10l.setForeground(design.lgray);
            l10l.setFont(design.ss15);
            frame.add(l10l);
        }

        label.add(prevpage); // prev page
        label.add(logout);
        if(movi.section!=0){
            label.add(prev);
        }
        if(movi.section!=movi.arr.size()-1){
            label.add(next);
        }


        frame.add(pgnum);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static String getText(String title){
        String re = "";
        ArrayList<ArrayList<String>> arr = dbase.getDTL_front(title);
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for(int i=0; i<arr.size(); i++){
            h.put(arr.get(i).get(2), i);
        }
        String [] s = h.keySet().toArray(new String[0]);
        String [] m = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String mon="";
        ArrayList<String> a = dbase.getMovies(0, title);
        switch(a.get(2).substring(5,7)){
            case "01":
                mon=m[0];
                break;
            case "02":
                mon=m[1];
                break;
            case "03":
                mon=m[2];
                break;
            case "04":
                mon=m[3];
                break;
            case "05":
                mon=m[4];
                break;
            case "06":
                mon=m[5];
                break;
            case "07":
                mon=m[6];
                break;
            case "08":
                mon=m[7];
                break;
            case "09":
                mon=m[8];
                break;
            case "10":
                mon=m[9];
                break;
            case "11":
                mon=m[10];
                break;
            case "12":
                mon=m[11];
        }
        // YYYY-MM-DD
        // 0123456789        0-50  |-51              ||-73,74
        re += String.format("%-50s Released: %2s %-9s Showtimes: ", title, a.get(2).substring(8).charAt(0)=='0'?" "+a.get(2).substring(9):a.get(2).substring(8), mon);
        for(int i=0; i<3; i++){
            if(i<s.length){
                re+=s[i].substring(8)+"/"+s[i].substring(5,7)+"  ";
            }
        }
        //System.out.println(re);
        return re;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            movi.section=0;
            new BookandCancelMovie();
            frame.dispose();
        }
        if (e.getSource()==prev){
            if(movi.section==0){
                new BookMovie(0);
                frame.dispose();
            } else {
                movi.section--;
                new BookMovie(movi.section);
                frame.dispose();
            }
        }
        if (e.getSource()==next){
            if(movi.section==movi.arr.size()-1){
                new BookMovie(movi.section);
                frame.dispose();
            } else {
                movi.section++;
                new BookMovie(movi.section);
                frame.dispose();
            }
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            new CoverPage();
            frame.dispose();
        }

        // book
        if (e.getSource()==myButton3){
            new Detail1(movi.arr.get(movi.section).get(0).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton4){
            new Detail1(movi.arr.get(movi.section).get(1).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton5){
            new Detail1(movi.arr.get(movi.section).get(2).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton6){
            new Detail1(movi.arr.get(movi.section).get(3).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton7){
            new Detail1(movi.arr.get(movi.section).get(4).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton8){
            new Detail1(movi.arr.get(movi.section).get(5).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton9){
            new Detail1(movi.arr.get(movi.section).get(6).get(1));
            frame.dispose();
        }
        if (e.getSource()==myButton10){
            new Detail1(movi.arr.get(movi.section).get(7).get(1));
            frame.dispose();
        }
    }
}
