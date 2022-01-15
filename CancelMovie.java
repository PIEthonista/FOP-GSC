import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class CancelMovie implements ActionListener {
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label = new JLabel();
    ArrayList<ArrayList<String>> arr;
    JLabel pgnum=new JLabel(),l3,l4,l5,l6,l7,l8,l9;
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9;
    JLabel l33,l44,l55,l66,l77,l88,l99;
    JLabel l3l,l4l,l5l,l6l,l7l,l8l,l9l;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton prev = new JButton("Previous"), next = new JButton("Next");
    JButton myButton3, myButton4, myButton5, myButton6, myButton7, myButton8, myButton9;
    JButton done = new JButton("Delete");

    CancelMovie(int section){
        movi.hist.clear();
        arr = dbase.getHistory(cust.uname);
        int i=0;
        int sec;
        // 1D=Spec movie ArrList,  2D=Page ArrList, 3D=Page Container
        for(sec=0; sec<arr.size()/7; sec++){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int j=0; j<7; j++){
                temp.add(arr.get(i));
                i++;
            }
            movi.hist.add(temp);
        }
        if(arr.size()%7!=0){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int k=0; k<arr.size()%7; k++){
                temp.add(arr.get(i));
                i++;
            }
            movi.hist.add(temp);
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
        pgnum.setText("Page "+(movi.section3+1)+" / "+movi.hist.size());

        prevpage.setBounds(675,28,200,40);
        prevpage.setVerticalAlignment(JLabel.CENTER);
        prevpage.setBackground(design.dgray);
        prevpage.setForeground(design.lgray);
        prevpage.setFocusable(false);
        prevpage.setHorizontalAlignment(JLabel.CENTER);
        prevpage.setFont(design.ss15);    //yx
        prevpage.addActionListener(this);

        logout.setBounds(875, 28, 280, 40);    //yx
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

        done.setBounds(1126,610,100,38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.yellow);
        done.setForeground(design.dgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.sui15);    //yx
        done.addActionListener(this);

        int y=20;
        int y1=5; //10
        int y2=15;
        int c=0;
        if(movi.hist.size()!=0){
            c=movi.hist.get(movi.section3).size();
        }

        if(1<=c){
            myButton3 = new JButton("Cancel");
            myButton3.setBounds(1150,163+y,70,38);
            myButton3.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(0))>0){
                myButton3.setBackground(design.orange);
            } else {
                myButton3.setBackground(design.yellow);
            }
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
            //String t3=getText(movi.arr.get(movi.section).get(0).get(1));
            l3 = new JLabel(movi.hist.get(movi.section3).get(0).get(2));      // ##
            l3.setBounds(40, 163+y2, 500, 38);       // ##
            l3.setOpaque(true);
            l3.setBackground(design.dgray);
            l3.setForeground(design.lgray);
            l3.setFont(design.ss20i);
            frame.add(l3);
            l33 = new JLabel(movi.hist.get(movi.section3).get(0).get(3)+"     "+movi.hist.get(movi.section3).get(0).get(4)+"     Hall "+movi.hist.get(movi.section3).get(0).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(0).get(6).replace(';',' '));
            l33.setBounds(550, 163+2+y2, 580, 38);      // ##
            l33.setOpaque(true);
            l33.setBackground(design.dgray);
            l33.setForeground(design.lgray);
            l33.setFont(design.ss15);
            frame.add(l33);
        }
        if(2<=c){
            myButton4 = new JButton("Cancel");
            myButton4.setBounds(1150,225+y,70,38);
            myButton4.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(1))>0){
                myButton4.setBackground(design.orange);
            } else {
                myButton4.setBackground(design.yellow);
            }
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
            //String t4=getText(movi.arr.get(movi.section).get(1).get(1));
            l4 = new JLabel(movi.hist.get(movi.section3).get(1).get(2));
            l4.setBounds(40, 225+y2, 500, 38);
            l4.setOpaque(true);
            l4.setBackground(design.dgray);
            l4.setForeground(design.lgray);
            l4.setFont(design.ss20i);
            frame.add(l4);
            l44 = new JLabel(movi.hist.get(movi.section3).get(1).get(3)+"     "+movi.hist.get(movi.section3).get(1).get(4)+"     Hall "+movi.hist.get(movi.section3).get(1).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(1).get(6).replace(';',' '));
            l44.setBounds(550, 225+2+y2, 580, 38);
            l44.setOpaque(true);
            l44.setBackground(design.dgray);
            l44.setForeground(design.lgray);
            l44.setFont(design.ss15);
            frame.add(l44);
        }
        if(3<=c){
            myButton5 = new JButton("Cancel");
            myButton5.setBounds(1150,288+y,70,38);
            myButton5.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(2))>0){
                myButton5.setBackground(design.orange);
            } else {
                myButton5.setBackground(design.yellow);
            }
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
            //String t5=getText(movi.arr.get(movi.section).get(2).get(1));
            l5 = new JLabel(movi.hist.get(movi.section3).get(2).get(2));
            l5.setBounds(40, 288+y2, 500, 38);
            l5.setOpaque(true);
            l5.setBackground(design.dgray);
            l5.setForeground(design.lgray);
            l5.setFont(design.ss20i);
            frame.add(l5);
            l55 = new JLabel(movi.hist.get(movi.section3).get(2).get(3)+"     "+movi.hist.get(movi.section3).get(2).get(4)+"     Hall "+movi.hist.get(movi.section3).get(2).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(2).get(6).replace(';',' '));
            l55.setBounds(550, 288+2+y2, 580, 38);
            l55.setOpaque(true);
            l55.setBackground(design.dgray);
            l55.setForeground(design.lgray);
            l55.setFont(design.ss15);
            frame.add(l55);
        }
        if(4<=c){
            myButton6 = new JButton("Cancel");
            myButton6.setBounds(1150,350+y,70,38);
            myButton6.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(3))>0){
                myButton6.setBackground(design.orange);
            } else {
                myButton6.setBackground(design.yellow);
            }
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
            //String t6=getText(movi.arr.get(movi.section).get(3).get(1));
            l6 = new JLabel(movi.hist.get(movi.section3).get(3).get(2));
            l6.setBounds(40, 350+y2, 500, 38);
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss20i);
            frame.add(l6);
            l66 = new JLabel(movi.hist.get(movi.section3).get(3).get(3)+"     "+movi.hist.get(movi.section3).get(3).get(4)+"     Hall "+movi.hist.get(movi.section3).get(3).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(3).get(6).replace(';',' '));
            l66.setBounds(550, 350+2+y2, 580, 38);
            l66.setOpaque(true);
            l66.setBackground(design.dgray);
            l66.setForeground(design.lgray);
            l66.setFont(design.ss15);
            frame.add(l66);
        }
        if(5<=c){
            myButton7 = new JButton("Cancel");
            myButton7.setBounds(1150,413+y,70,38);
            myButton7.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(4))>0){
                myButton7.setBackground(design.orange);
            } else {
                myButton7.setBackground(design.yellow);
            }
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
            //String t7=getText(movi.arr.get(movi.section).get(4).get(1));
            l7 = new JLabel(movi.hist.get(movi.section3).get(4).get(2));
            l7.setBounds(40, 413+y2, 500, 38);
            l7.setOpaque(true);
            l7.setBackground(design.dgray);
            l7.setForeground(design.lgray);
            l7.setFont(design.ss20i);
            frame.add(l7);
            l77 = new JLabel(movi.hist.get(movi.section3).get(4).get(3)+"     "+movi.hist.get(movi.section3).get(4).get(4)+"     Hall "+movi.hist.get(movi.section3).get(4).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(4).get(6).replace(';',' '));
            l77.setBounds(550, 413+2+y2, 580, 38);
            l77.setOpaque(true);
            l77.setBackground(design.dgray);
            l77.setForeground(design.lgray);
            l77.setFont(design.ss15);
            frame.add(l77);
        }
        if(6<=c){
            myButton8 = new JButton("Cancel");
            myButton8.setBounds(1150,475+y,70,38);
            myButton8.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(5))>0){
                myButton8.setBackground(design.orange);
            } else {
                myButton8.setBackground(design.yellow);
            }
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
            //String t8=getText(movi.arr.get(movi.section).get(5).get(1));
            l8 = new JLabel(movi.hist.get(movi.section3).get(5).get(2));
            l8.setBounds(40, 475+y2, 500, 38);
            l8.setOpaque(true);
            l8.setBackground(design.dgray);
            l8.setForeground(design.lgray);
            l8.setFont(design.ss20i);
            frame.add(l8);
            l88 = new JLabel(movi.hist.get(movi.section3).get(5).get(3)+"     "+movi.hist.get(movi.section3).get(5).get(4)+"     Hall "+movi.hist.get(movi.section3).get(5).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(5).get(6).replace(';',' '));
            l88.setBounds(550, 475+2+y2, 580, 38);
            l88.setOpaque(true);
            l88.setBackground(design.dgray);
            l88.setForeground(design.lgray);
            l88.setFont(design.ss15);
            frame.add(l88);
        }
        if(7<=c){
            myButton9 = new JButton("Cancel");
            myButton9.setBounds(1150,538+y,70,38);
            myButton9.setVerticalAlignment(JLabel.CENTER);
            if(inTODEL(movi.hist.get(movi.section3).get(6))>0){
                myButton9.setBackground(design.orange);
            } else {
                myButton9.setBackground(design.yellow);
            }
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
            //String t9=getText(movi.arr.get(movi.section).get(6).get(1));
            l9 = new JLabel(movi.hist.get(movi.section3).get(6).get(2));
            l9.setBounds(40, 538+y2, 500, 38);
            l9.setOpaque(true);
            l9.setBackground(design.dgray);
            l9.setForeground(design.lgray);
            l9.setFont(design.ss20i);
            frame.add(l9);
            l99 = new JLabel(movi.hist.get(movi.section3).get(6).get(3)+"     "+movi.hist.get(movi.section3).get(6).get(4)+"     Hall "+movi.hist.get(movi.section3).get(6).get(5)+"     Seats: "+movi.hist.get(movi.section3).get(6).get(6).replace(';',' '));
            l99.setBounds(550, 538+2+y2, 580, 38);
            l99.setOpaque(true);
            l99.setBackground(design.dgray);
            l99.setForeground(design.lgray);
            l99.setFont(design.ss15);
            frame.add(l99);
        }


        label.add(prevpage); // prev page
        label.add(logout);
        label.add(done);
        if(movi.section3!=0){
            label.add(prev);
        }
        if(movi.hist.size()!=0){
            if(movi.section3!=movi.hist.size()-1){
                label.add(next);
            }
        }

        frame.add(pgnum);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            movi.section3=0;
            new BookandCancelMovie();
            frame.dispose();
        }
        if (e.getSource()==prev){
            if(movi.section3==0){
                new CancelMovie(0);
                frame.dispose();
            } else {
                movi.section3--;
                new CancelMovie(movi.section3);
                frame.dispose();
            }
        }
        if (e.getSource()==next){
            if(movi.section3==movi.hist.size()-1){
                new CancelMovie(movi.section3);
                frame.dispose();
            } else {
                movi.section3++;
                new CancelMovie(movi.section3);
                frame.dispose();
            }
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section3=0;
            new CoverPage();
            frame.dispose();
        }
        if(e.getSource()==done){
            if(cust.todel.size()!=0){
                new delConfirm(movi.section4);
                frame.dispose();
            }
        }

        //cancel
        if(e.getSource()==myButton3){
            if(inTODEL(movi.hist.get(movi.section3).get(0))>0){
                delTODEL(movi.hist.get(movi.section3).get(0));
                myButton3.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(0));
                myButton3.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton4){
            if(inTODEL(movi.hist.get(movi.section3).get(1))>0){
                delTODEL(movi.hist.get(movi.section3).get(1));
                myButton4.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(1));
                myButton4.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton5){
            if(inTODEL(movi.hist.get(movi.section3).get(2))>0){
                delTODEL(movi.hist.get(movi.section3).get(2));
                myButton5.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(2));
                myButton5.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton6){
            if(inTODEL(movi.hist.get(movi.section3).get(3))>0){
                delTODEL(movi.hist.get(movi.section3).get(3));
                myButton6.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(3));
                myButton6.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton7){
            if(inTODEL(movi.hist.get(movi.section3).get(4))>0){
                delTODEL(movi.hist.get(movi.section3).get(4));
                myButton7.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(4));
                myButton7.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton8){
            if(inTODEL(movi.hist.get(movi.section3).get(5))>0){
                delTODEL(movi.hist.get(movi.section3).get(5));
                myButton8.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(5));
                myButton8.setBackground(design.orange);
            }
        }
        if(e.getSource()==myButton9){
            if(inTODEL(movi.hist.get(movi.section3).get(6))>0){
                delTODEL(movi.hist.get(movi.section3).get(6));
                myButton9.setBackground(design.yellow);
            } else {
                addTODEL(movi.hist.get(movi.section3).get(6));
                myButton9.setBackground(design.orange);
            }
        }
        /*
        System.out.println("===========");
        for(ArrayList<String> i : cust.todel){
            System.out.println(i);
        }
        */
    }

    public static int inTODEL(ArrayList<String> arr){
        int status=0;
        if(cust.todel.size()>0){
            for(int i=0; i<cust.todel.size(); i++){
                if(arr.get(0).equals(cust.todel.get(i).get(0)) &&
                        arr.get(1).equals(cust.todel.get(i).get(1)) &&
                        arr.get(2).equals(cust.todel.get(i).get(2)) &&
                        arr.get(3).equals(cust.todel.get(i).get(3)) &&
                        arr.get(4).equals(cust.todel.get(i).get(4)) &&
                        arr.get(5).equals(cust.todel.get(i).get(5)) &&
                        arr.get(6).equals(cust.todel.get(i).get(6)) &&
                        arr.get(7).equals(cust.todel.get(i).get(7)) &&
                        arr.get(8).equals(cust.todel.get(i).get(8)) &&
                        arr.get(9).equals(cust.todel.get(i).get(9)) &&
                        arr.get(10).equals(cust.todel.get(i).get(10)) &&
                        arr.get(11).equals(cust.todel.get(i).get(11)) &&
                        arr.get(12).equals(cust.todel.get(i).get(12)) &&
                        arr.get(13).equals(cust.todel.get(i).get(13)) &&
                        arr.get(14).equals(cust.todel.get(i).get(14))){
                    status++;
                }
            }
        }
        return status;
    }

    public static void delTODEL(ArrayList<String> arr){
        if(cust.todel.size()>0){
            for(int i=0; i<cust.todel.size(); i++){
                if(arr.get(0).equals(cust.todel.get(i).get(0)) &&
                        arr.get(1).equals(cust.todel.get(i).get(1)) &&
                        arr.get(2).equals(cust.todel.get(i).get(2)) &&
                        arr.get(3).equals(cust.todel.get(i).get(3)) &&
                        arr.get(4).equals(cust.todel.get(i).get(4)) &&
                        arr.get(5).equals(cust.todel.get(i).get(5)) &&
                        arr.get(6).equals(cust.todel.get(i).get(6)) &&
                        arr.get(7).equals(cust.todel.get(i).get(7)) &&
                        arr.get(8).equals(cust.todel.get(i).get(8)) &&
                        arr.get(9).equals(cust.todel.get(i).get(9)) &&
                        arr.get(10).equals(cust.todel.get(i).get(10)) &&
                        arr.get(11).equals(cust.todel.get(i).get(11)) &&
                        arr.get(12).equals(cust.todel.get(i).get(12)) &&
                        arr.get(13).equals(cust.todel.get(i).get(13)) &&
                        arr.get(14).equals(cust.todel.get(i).get(14))){
                    cust.todel.remove(i);
                }
            }
        }
    }

    public static void addTODEL(ArrayList<String> arr){
        cust.todel.add(arr);
    }
}
