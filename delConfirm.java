import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class delConfirm implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label1 = new JLabel();
    ArrayList<ArrayList<String>> arr;
    JLabel pgnum = new JLabel(), l6, l7, l8, l9, l10;
    JLabel ln6, ln7, ln8, ln9, ln10;
    JLabel l66, l77, l88, l99, l1010;
    JLabel ttl, cst, syn;
    JTextArea rel;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  " + cust.uname);
    JButton prev = new JButton("Previous"), next = new JButton("Next");
    JButton done = new JButton("Confirm");

    delConfirm(int n) {
        arr = cust.todel;
        movi.disp.clear();
        int i = 0;
        int sec;
        // 1D=Spec movie ArrList,  2D=Page ArrList, 3D=Page Container
        for (sec = 0; sec < arr.size() / 4; sec++) {
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for (int j = 0; j < 4; j++) {
                temp.add(arr.get(i));
                i++;
            }
            movi.disp.add(temp);
        }
        if (arr.size() % 4 != 0) {
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for (int k = 0; k < arr.size() % 4; k++) {
                temp.add(arr.get(i));
                i++;
            }
            movi.disp.add(temp);
        }

        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 1250, 750);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(JLabel.CENTER);

        ttl = new JLabel("Delete Confirmation");
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.white);
        ttl.setBounds(24, 100, 1000, 60);

        rel = new JTextArea("Are you sure to delete the following bookings?\nThere will be no refundings.\nYou can head back to the previous page to edit your delete selections.");
        rel.setBackground(design.dgray);
        rel.setOpaque(true);
        rel.setFocusable(false);
        //rel.setHorizontalAlignment(JLabel.LEFT);
        //rel.setVerticalAlignment(JLabel.TOP);
        rel.setFont(design.ss15);
        rel.setForeground(design.lgray);
        rel.setBounds(30, 165, 1000, 140);
        pgnum.setBounds(130, 320, 990, 30);
        pgnum.setBackground(design.dgray);
        pgnum.setOpaque(true);
        pgnum.setHorizontalAlignment(JLabel.CENTER);
        pgnum.setFont(design.ss13);
        pgnum.setForeground(design.mgray);
        pgnum.setText("Page " + (movi.section4 + 1) + " / " + movi.disp.size());

        prevpage.setBounds(675, 33, 200, 40);
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

        prev.setBounds(24, 310, 100, 38);
        prev.setVerticalAlignment(JLabel.CENTER);
        prev.setBackground(design.yellow);
        prev.setForeground(design.dgray);
        prev.setFocusable(false);
        prev.setHorizontalAlignment(JLabel.CENTER);
        prev.setFont(design.sui15);    //yx
        prev.addActionListener(this);

        next.setBounds(1126, 310, 100, 38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);

        done.setBounds(1126, 610, 100, 38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.yellow);
        done.setForeground(design.dgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.sui15);    //yx
        done.addActionListener(this);

        int y = 20;
        int y1 = 5; //10
        int y2 = 15;
        int c = movi.disp.get(movi.section4).size();


        if(1<=c){
            ln6 = new JLabel();
            ln6.setBounds(25, 350+y1,1200, 1);
            ln6.setOpaque(true);
            ln6.setBackground(design.mgray);
            frame.add(ln6);
            //
            //String t6=getText(movi.arr.get(movi.section).get(3).get(1));
            l6 = new JLabel(movi.disp.get(movi.section4).get(0).get(2));
            l6.setBounds(40, 350+y2, 500, 38);
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss20i);
            frame.add(l6);
            int q=0;
            l66 = new JLabel(movi.disp.get(movi.section4).get(q).get(3)+"     "+movi.disp.get(movi.section4).get(q).get(4)+"     Hall "+movi.disp.get(movi.section4).get(q).get(5)+"     Seats: "+movi.disp.get(movi.section4).get(q).get(6).replace(';',' '));
            l66.setBounds(550, 350+2+y2, 580, 38);
            l66.setOpaque(true);
            l66.setBackground(design.dgray);
            l66.setForeground(design.lgray);
            l66.setFont(design.ss15);
            frame.add(l66);
        }
        if(2<=c){
            ln7 = new JLabel();
            ln7.setBounds(25, 413+y1,1200, 1);
            ln7.setOpaque(true);
            ln7.setBackground(design.mgray);
            frame.add(ln7);
            //
            //String t7=getText(movi.arr.get(movi.section).get(4).get(1));
            l7 = new JLabel(movi.disp.get(movi.section4).get(1).get(2));
            l7.setBounds(40, 413+y2, 500, 38);
            l7.setOpaque(true);
            l7.setBackground(design.dgray);
            l7.setForeground(design.lgray);
            l7.setFont(design.ss20i);
            frame.add(l7);
            int q=1;
            l77 = new JLabel(movi.disp.get(movi.section4).get(q).get(3)+"     "+movi.disp.get(movi.section4).get(q).get(4)+"     Hall "+movi.disp.get(movi.section4).get(q).get(5)+"     Seats: "+movi.disp.get(movi.section4).get(q).get(6).replace(';',' '));
            l77.setBounds(550, 413+2+y2, 580, 38);
            l77.setOpaque(true);
            l77.setBackground(design.dgray);
            l77.setForeground(design.lgray);
            l77.setFont(design.ss15);
            frame.add(l77);
        }
        if(3<=c){
            ln8 = new JLabel();
            ln8.setBounds(25, 475+y1,1200, 1);
            ln8.setOpaque(true);
            ln8.setBackground(design.mgray);
            frame.add(ln8);
            //
            //String t8=getText(movi.arr.get(movi.section).get(5).get(1));
            l8 = new JLabel(movi.disp.get(movi.section4).get(2).get(2));
            l8.setBounds(40, 475+y2, 500, 38);
            l8.setOpaque(true);
            l8.setBackground(design.dgray);
            l8.setForeground(design.lgray);
            l8.setFont(design.ss20i);
            frame.add(l8);
            int q=2;
            l88 = new JLabel(movi.disp.get(movi.section4).get(q).get(3)+"     "+movi.disp.get(movi.section4).get(q).get(4)+"     Hall "+movi.disp.get(movi.section4).get(q).get(5)+"     Seats: "+movi.disp.get(movi.section4).get(q).get(6).replace(';',' '));
            l88.setBounds(550, 475+2+y2, 580, 38);
            l88.setOpaque(true);
            l88.setBackground(design.dgray);
            l88.setForeground(design.lgray);
            l88.setFont(design.ss15);
            frame.add(l88);
        }
        if(4<=c){
            ln9 = new JLabel();
            ln9.setBounds(25, 538+y1,1200, 1);
            ln9.setOpaque(true);
            ln9.setBackground(design.mgray);
            frame.add(ln9);
            //
            //String t9=getText(movi.arr.get(movi.section).get(6).get(1));
            l9 = new JLabel(movi.disp.get(movi.section4).get(3).get(2));
            l9.setBounds(40, 538+y2, 500, 38);
            l9.setOpaque(true);
            l9.setBackground(design.dgray);
            l9.setForeground(design.lgray);
            l9.setFont(design.ss20i);
            frame.add(l9);
            int q=3;
            l99 = new JLabel(movi.disp.get(movi.section4).get(q).get(3)+"     "+movi.disp.get(movi.section4).get(q).get(4)+"     Hall "+movi.disp.get(movi.section4).get(q).get(5)+"     Seats: "+movi.disp.get(movi.section4).get(q).get(6).replace(';',' '));
            l99.setBounds(550, 538+2+y2, 580, 38);
            l99.setOpaque(true);
            l99.setBackground(design.dgray);
            l99.setForeground(design.lgray);
            l99.setFont(design.ss15);
            frame.add(l99);
        }

        label1.add(prevpage);
        label1.add(logout);
        label1.add(done);
        if (movi.section4 != 0) {
            label1.add(prev);
        }
        if (movi.section4 != movi.disp.size() - 1) {
            label1.add(next);
        }
        frame.add(pgnum);
        frame.add(ttl);
        frame.add(rel);
        frame.add(label1);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==prevpage){
            new CancelMovie(movi.section3);
            frame.dispose();
        }
        if (e.getSource()==prev){
            if(movi.section4==0){
                new delConfirm(0);
                frame.dispose();
            } else {
                movi.section4--;
                new delConfirm(movi.section4);
                frame.dispose();
            }
        }
        if (e.getSource()==next){
            if(movi.section4==movi.disp.size()-1){
                new delConfirm(movi.section4);
                frame.dispose();
            } else {
                movi.section4++;
                new delConfirm(movi.section4);
                frame.dispose();
            }
        }
        if(e.getSource()==done){
            for(ArrayList<String> p : cust.todel){
                dbase.delHistory(p.get(1), p.get(2), p.get(3), p.get(4), p.get(5), p.get(6));
                addBackSeats(p.get(2), p.get(3),p.get(4),p.get(5),p.get(6));
            }
            movi.section3=0;
            movi.section4=0;
            cust.partialRESET();
            new BookandCancelMovie();
            frame.dispose();
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section3=0;
            movi.section4=0;
            new CoverPage();
            frame.dispose();
        }
    }

    public static void addBackSeats(String title, String date, String time, String hall, String seat){
        ArrayList<String> seats = genArr(seat);
        if(seats.size()>0){
            if(!(seats.get(0).equals(""))){
                dbase.updSpecDTL_back(title, date, time, hall, seats, 0);
            }
        }
    }

    public static ArrayList<String> genArr(String lis){
        ArrayList<String> arr = new ArrayList<String>();
        if(lis.length()>0){
            while(lis.length()>3){
                arr.add(lis.substring(0,3));
                lis=lis.substring(4);
            }
            arr.add(lis);
        }
        return arr;
    }
}
