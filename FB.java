import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class FB implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label = new JLabel();
    JLabel pgnum=new JLabel(),l3,l4,l5,l6,l7,l8,l9;
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9;
    JLabel l33,l44,l55,l66,l77,l88,l99;
    JLabel l3l,l4l,l5l,l6l,l7l,l8l,l9l;
    JLabel l3ll,l4ll,l5ll,l6ll,l7ll,l8ll,l9ll;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton prev = new JButton("Previous"), next = new JButton("Next");
    JButton done = new JButton("Done");
    JTextField myButton3, myButton4, myButton5, myButton6, myButton7, myButton8, myButton9;

    FB(int section){
        ArrayList<ArrayList<String>> arr = dbase.getAllFNB();
        movi.fb.clear();
        int i=0;
        int sec;
        // 1D=Spec movie ArrList,  2D=Page ArrList, 3D=Page Container
        for(sec=0; sec<arr.size()/7; sec++){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int j=0; j<7; j++){
                temp.add(arr.get(i));
                i++;
            }
            movi.fb.add(temp);
        }
        if(arr.size()%7!=0){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int k=0; k<arr.size()%7; k++){
                temp.add(arr.get(i));
                i++;
            }
            movi.fb.add(temp);
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
        pgnum.setText("Page "+(movi.fnb+1)+" / "+movi.fb.size());

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
        int c=movi.fb.get(movi.fnb).size();

        if(1<=c){
            myButton3 = new JTextField();
            myButton3.setBounds(1150,163+y,70,38);
            myButton3.setBackground(design.lgray);
            myButton3.setForeground(design.mgray);
            myButton3.setHorizontalAlignment(JLabel.CENTER);
            myButton3.setFont(design.sui15);    //yx
            myButton3.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(0).get(0))).toString());
            label.add(myButton3);
            ln3 = new JLabel();
            ln3.setBounds(25, 163+y1,1200, 1);
            ln3.setOpaque(true);
            ln3.setBackground(design.mgray);
            frame.add(ln3);
            //
            //String t3=getText(movi.arr.get(movi.section).get(0).get(1));
            //l3 = new JLabel(t3.substring(0,50));
            l3 = new JLabel(movi.fb.get(movi.fnb).get(0).get(1));    //###
            l3.setBounds(40, 163+y2, 250, 38);    //###
            l3.setOpaque(true);
            l3.setBackground(design.dgray);
            l3.setForeground(design.lgray);
            l3.setFont(design.ss20i);
            frame.add(l3);
            //l33 = new JLabel(t3.substring(51,73));
            l33 = new JLabel(movi.fb.get(movi.fnb).get(0).get(2));    //###
            l33.setBounds(300, 163+2+y2, 500, 38);    //###
            l33.setOpaque(true);
            l33.setBackground(design.dgray);
            l33.setForeground(design.lgray);
            l33.setFont(design.ss15);
            frame.add(l33);
            //
            //l3l = new JLabel(t3.substring(74));
            l3l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(0).get(3));    //###
            l3l.setBounds(810, 163+2+y2, 200, 38);    //###
            l3l.setOpaque(true);
            l3l.setBackground(design.dgray);
            l3l.setForeground(design.lgray);
            l3l.setFont(design.ss15);
            frame.add(l3l);
            //
            l3ll = new JLabel("Amount: ");    //###
            l3ll.setBounds(1020, 163+2+y2, 125, 38);    //###
            l3ll.setOpaque(true);
            l3ll.setBackground(design.dgray);
            l3ll.setForeground(design.lgray);
            l3ll.setHorizontalAlignment(JLabel.RIGHT);
            l3ll.setFont(design.ss15);
            frame.add(l3ll);
        }
        if(2<=c){
            myButton4 = new JTextField();
            myButton4.setBounds(1150,225+y,70,38);
            myButton4.setBackground(design.lgray);
            myButton4.setForeground(design.mgray);
            myButton4.setHorizontalAlignment(JLabel.CENTER);
            myButton4.setFont(design.sui15);    //yx
            myButton4.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(1).get(0))).toString());
            label.add(myButton4);
            ln4 = new JLabel();
            ln4.setBounds(25, 225+y1,1200, 1);
            ln4.setOpaque(true);
            ln4.setBackground(design.mgray);
            frame.add(ln4);
            //
            l4 = new JLabel(movi.fb.get(movi.fnb).get(1).get(1));    //###
            l4.setBounds(40, 225+y2, 250, 38);    //###
            l4.setOpaque(true);
            l4.setBackground(design.dgray);
            l4.setForeground(design.lgray);
            l4.setFont(design.ss20i);
            frame.add(l4);
            l44 = new JLabel(movi.fb.get(movi.fnb).get(1).get(2));    //###
            l44.setBounds(300, 225+2+y2, 500, 38);    //###
            l44.setOpaque(true);
            l44.setBackground(design.dgray);
            l44.setForeground(design.lgray);
            l44.setFont(design.ss15);
            frame.add(l44);
            //
            l4l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(1).get(3));    //###
            l4l.setBounds(810, 225+2+y2, 200, 38);    //###
            l4l.setOpaque(true);
            l4l.setBackground(design.dgray);
            l4l.setForeground(design.lgray);
            l4l.setFont(design.ss15);
            frame.add(l4l);
            //
            l4ll = new JLabel("Amount: ");    //###
            l4ll.setBounds(1020, 225+2+y2, 125, 38);    //###
            l4ll.setOpaque(true);
            l4ll.setBackground(design.dgray);
            l4ll.setForeground(design.lgray);
            l4ll.setHorizontalAlignment(JLabel.RIGHT);
            l4ll.setFont(design.ss15);
            frame.add(l4ll);
        }
        if(3<=c){
            myButton5 = new JTextField();
            myButton5.setBounds(1150,288+y,70,38);
            myButton5.setBackground(design.lgray);
            myButton5.setForeground(design.mgray);
            myButton5.setHorizontalAlignment(JLabel.CENTER);
            myButton5.setFont(design.sui15);    //yx
            myButton5.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(2).get(0))).toString());
            label.add(myButton5);
            ln5 = new JLabel();
            ln5.setBounds(25, 288+y1,1200, 1);
            ln5.setOpaque(true);
            ln5.setBackground(design.mgray);
            frame.add(ln5);
            //
            l5 = new JLabel(movi.fb.get(movi.fnb).get(2).get(1));    //###
            l5.setBounds(40, 288+y2, 250, 38);    //###
            l5.setOpaque(true);
            l5.setBackground(design.dgray);
            l5.setForeground(design.lgray);
            l5.setFont(design.ss20i);
            frame.add(l5);
            l55 = new JLabel(movi.fb.get(movi.fnb).get(2).get(2));    //###
            l55.setBounds(300, 288+2+y2, 500, 38);    //###
            l55.setOpaque(true);
            l55.setBackground(design.dgray);
            l55.setForeground(design.lgray);
            l55.setFont(design.ss15);
            frame.add(l55);
            //
            l5l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(2).get(3));    //###
            l5l.setBounds(810, 288+2+y2, 200, 38);    //###
            l5l.setOpaque(true);
            l5l.setBackground(design.dgray);
            l5l.setForeground(design.lgray);
            l5l.setFont(design.ss15);
            frame.add(l5l);
            //
            l5ll = new JLabel("Amount: ");    //###
            l5ll.setBounds(1020, 288+2+y2, 125, 38);    //###
            l5ll.setOpaque(true);
            l5ll.setBackground(design.dgray);
            l5ll.setForeground(design.lgray);
            l5ll.setHorizontalAlignment(JLabel.RIGHT);
            l5ll.setFont(design.ss15);
            frame.add(l5ll);
        }
        if(4<=c){
            myButton6 = new JTextField();
            myButton6.setBounds(1150,350+y,70,38);
            myButton6.setBackground(design.lgray);
            myButton6.setForeground(design.mgray);
            myButton6.setHorizontalAlignment(JLabel.CENTER);
            myButton6.setFont(design.sui15);    //yx
            myButton6.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(3).get(0))).toString());
            label.add(myButton6);
            ln6 = new JLabel();
            ln6.setBounds(25, 350+y1,1200, 1);
            ln6.setOpaque(true);
            ln6.setBackground(design.mgray);
            frame.add(ln6);
            //
            l6 = new JLabel(movi.fb.get(movi.fnb).get(3).get(1));    //###
            l6.setBounds(40, 350+y2, 250, 38);    //###
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss20i);
            frame.add(l6);
            l66 = new JLabel(movi.fb.get(movi.fnb).get(3).get(2));    //###
            l66.setBounds(300, 350+2+y2, 500, 38);    //###
            l66.setOpaque(true);
            l66.setBackground(design.dgray);
            l66.setForeground(design.lgray);
            l66.setFont(design.ss15);
            frame.add(l66);
            //
            l6l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(3).get(3));    //###
            l6l.setBounds(810, 350+2+y2, 200, 38);    //###
            l6l.setOpaque(true);
            l6l.setBackground(design.dgray);
            l6l.setForeground(design.lgray);
            l6l.setFont(design.ss15);
            frame.add(l6l);
            //
            l6ll = new JLabel("Amount: ");    //###
            l6ll.setBounds(1020, 350+2+y2, 125, 38);    //###
            l6ll.setOpaque(true);
            l6ll.setBackground(design.dgray);
            l6ll.setForeground(design.lgray);
            l6ll.setHorizontalAlignment(JLabel.RIGHT);
            l6ll.setFont(design.ss15);
            frame.add(l6ll);
        }
        if(5<=c){
            myButton7 = new JTextField();
            myButton7.setBounds(1150,413+y,70,38);
            myButton7.setBackground(design.lgray);
            myButton7.setForeground(design.mgray);
            myButton7.setHorizontalAlignment(JLabel.CENTER);
            myButton7.setFont(design.sui15);    //yx
            myButton7.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(4).get(0))).toString());
            label.add(myButton7);
            ln7 = new JLabel();
            ln7.setBounds(25, 413+y1,1200, 1);
            ln7.setOpaque(true);
            ln7.setBackground(design.mgray);
            frame.add(ln7);
            //
            l7 = new JLabel(movi.fb.get(movi.fnb).get(4).get(1));    //###
            l7.setBounds(40, 413+y2, 250, 38);    //###
            l7.setOpaque(true);
            l7.setBackground(design.dgray);
            l7.setForeground(design.lgray);
            l7.setFont(design.ss20i);
            frame.add(l7);
            l77 = new JLabel(movi.fb.get(movi.fnb).get(4).get(2));    //###
            l77.setBounds(300, 413+2+y2, 500, 38);    //###
            l77.setOpaque(true);
            l77.setBackground(design.dgray);
            l77.setForeground(design.lgray);
            l77.setFont(design.ss15);
            frame.add(l77);
            //
            l7l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(4).get(3));    //###
            l7l.setBounds(810, 413+2+y2, 200, 38);    //###
            l7l.setOpaque(true);
            l7l.setBackground(design.dgray);
            l7l.setForeground(design.lgray);
            l7l.setFont(design.ss15);
            frame.add(l7l);
            //
            l7ll = new JLabel("Amount: ");    //###
            l7ll.setBounds(1020, 413+2+y2, 125, 38);    //###
            l7ll.setOpaque(true);
            l7ll.setBackground(design.dgray);
            l7ll.setForeground(design.lgray);
            l7ll.setHorizontalAlignment(JLabel.RIGHT);
            l7ll.setFont(design.ss15);
            frame.add(l7ll);
        }
        if(6<=c){
            myButton8 = new JTextField();
            myButton8.setBounds(1150,475+y,70,38);
            myButton8.setBackground(design.lgray);
            myButton8.setForeground(design.mgray);
            myButton8.setHorizontalAlignment(JLabel.CENTER);
            myButton8.setFont(design.sui15);    //yx
            myButton8.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(5).get(0))).toString());
            label.add(myButton8);
            ln8 = new JLabel();
            ln8.setBounds(25, 475+y1,1200, 1);
            ln8.setOpaque(true);
            ln8.setBackground(design.mgray);
            frame.add(ln8);
            //
            l8 = new JLabel(movi.fb.get(movi.fnb).get(5).get(1));    //###
            l8.setBounds(40, 475+y2, 250, 38);    //###
            l8.setOpaque(true);
            l8.setBackground(design.dgray);
            l8.setForeground(design.lgray);
            l8.setFont(design.ss20i);
            frame.add(l8);
            l88 = new JLabel(movi.fb.get(movi.fnb).get(5).get(2));    //###
            l88.setBounds(300, 475+2+y2, 500, 38);    //###
            l88.setOpaque(true);
            l88.setBackground(design.dgray);
            l88.setForeground(design.lgray);
            l88.setFont(design.ss15);
            frame.add(l88);
            //
            l8l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(5).get(3));    //###
            l8l.setBounds(810, 475+2+y2, 200, 38);    //###
            l8l.setOpaque(true);
            l8l.setBackground(design.dgray);
            l8l.setForeground(design.lgray);
            l8l.setFont(design.ss15);
            frame.add(l8l);
            //
            l8ll = new JLabel("Amount: ");    //###
            l8ll.setBounds(1020, 475+2+y2, 125, 38);    //###
            l8ll.setOpaque(true);
            l8ll.setBackground(design.dgray);
            l8ll.setForeground(design.lgray);
            l8ll.setHorizontalAlignment(JLabel.RIGHT);
            l8ll.setFont(design.ss15);
            frame.add(l8ll);
        }
        if(7<=c){
            myButton9 = new JTextField();
            myButton9.setBounds(1150,538+y,70,38);
            myButton9.setBackground(design.lgray);
            myButton9.setForeground(design.mgray);
            myButton9.setHorizontalAlignment(JLabel.CENTER);
            myButton9.setFont(design.sui15);    //yx
            myButton9.setText(getFreq(Integer.parseInt(movi.fb.get(movi.fnb).get(6).get(0))).toString());
            label.add(myButton9);
            ln9 = new JLabel();
            ln9.setBounds(25, 538+y1,1200, 1);
            ln9.setOpaque(true);
            ln9.setBackground(design.mgray);
            frame.add(ln9);
            //
            l9 = new JLabel(movi.fb.get(movi.fnb).get(6).get(1));    //###
            l9.setBounds(40, 538+y2, 250, 38);    //###
            l9.setOpaque(true);
            l9.setBackground(design.dgray);
            l9.setForeground(design.lgray);
            l9.setFont(design.ss20i);
            frame.add(l9);
            l99 = new JLabel(movi.fb.get(movi.fnb).get(6).get(2));    //###
            l99.setBounds(300, 538+2+y2, 500, 38);    //###
            l99.setOpaque(true);
            l99.setBackground(design.dgray);
            l99.setForeground(design.lgray);
            l99.setFont(design.ss15);
            frame.add(l99);
            //
            l9l = new JLabel("Price: MYR "+movi.fb.get(movi.fnb).get(6).get(3));    //###
            l9l.setBounds(810, 538+2+y2, 200, 38);    //###
            l9l.setOpaque(true);
            l9l.setBackground(design.dgray);
            l9l.setForeground(design.lgray);
            l9l.setFont(design.ss15);
            frame.add(l9l);
            //
            l9ll = new JLabel("Amount: ");    //###
            l9ll.setBounds(1020, 538+2+y2, 125, 38);    //###
            l9ll.setOpaque(true);
            l9ll.setBackground(design.dgray);
            l9ll.setForeground(design.lgray);
            l9ll.setHorizontalAlignment(JLabel.RIGHT);
            l9ll.setFont(design.ss15);
            frame.add(l9ll);
        }


        label.add(prevpage); // prev page
        label.add(logout);
        label.add(done);
        if(movi.fnb!=0){
            label.add(prev);
        }
        if(movi.fnb!=movi.fb.size()-1){
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


    public static Integer getFreq(int n){
        Integer f=0;
        Integer n1=n;
        for(int i=0; i<cust.f_id.size(); i++){
            if(cust.f_id.get(i).equals(n1.toString())){
                f++;
            }
        }
        return f;
    }

    public static void updfb(int sub, int f){
        Integer subj = sub;
        String subject = subj.toString();
        for(int i=0; i<cust.f_id.size(); i++){
            if(cust.f_id.get(i).equals(subject)){
                cust.f_id.remove(i);
            }
        }
        for(int j=1; j<=f; j++){
            cust.f_id.add(subject);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            movi.fnb=0;
            new seat1(cust.title, cust.date, cust.time, cust.hallno);
            frame.dispose();
        }
        if (e.getSource()==prev){
            int aa=0,bb=0,cc=0,dd=0,ee=0,ff=0,gg=0;
            try{
                if(1<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton3.getText().equals(""))){
                        aa = Integer.parseInt(myButton3.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(0).get(0)), aa);
                    }
                }
                if(2<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton4.getText().equals(""))){
                        bb = Integer.parseInt(myButton4.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(1).get(0)), bb);
                    }
                }
                if(3<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton5.getText().equals(""))){
                        cc = Integer.parseInt(myButton5.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(2).get(0)), cc);
                    }
                }
                if(4<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton6.getText().equals(""))){
                        dd = Integer.parseInt(myButton6.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(3).get(0)), dd);
                    }
                }
                if(5<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton7.getText().equals(""))){
                        ee = Integer.parseInt(myButton7.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(4).get(0)), ee);
                    }
                }
                if(6<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton8.getText().equals(""))){
                        ff = Integer.parseInt(myButton8.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(5).get(0)), ff);
                    }
                }
                if(7<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton9.getText().equals(""))){
                        gg = Integer.parseInt(myButton9.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(6).get(0)), gg);
                    }
                }
                if(movi.fnb==0){
                    new FB(0);
                    frame.dispose();
                } else {
                    movi.fnb--;
                    new FB(movi.fnb);
                    frame.dispose();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers!");
            }
        }
        if (e.getSource()==next){
            int aa=0,bb=0,cc=0,dd=0,ee=0,ff=0,gg=0;
            try{
                if(1<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton3.getText().equals(""))){
                        aa = Integer.parseInt(myButton3.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(0).get(0)), aa);
                    }
                }
                if(2<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton4.getText().equals(""))){
                        bb = Integer.parseInt(myButton4.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(1).get(0)), bb);
                    }
                }
                if(3<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton5.getText().equals(""))){
                        cc = Integer.parseInt(myButton5.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(2).get(0)), cc);
                    }
                }
                if(4<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton6.getText().equals(""))){
                        dd = Integer.parseInt(myButton6.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(3).get(0)), dd);
                    }
                }
                if(5<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton7.getText().equals(""))){
                        ee = Integer.parseInt(myButton7.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(4).get(0)), ee);
                    }
                }
                if(6<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton8.getText().equals(""))){
                        ff = Integer.parseInt(myButton8.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(5).get(0)), ff);
                    }
                }
                if(7<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton9.getText().equals(""))){
                        gg = Integer.parseInt(myButton9.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(6).get(0)), gg);
                    }
                }
                if(movi.fnb==movi.fb.size()-1){
                    new FB(movi.fnb);
                    frame.dispose();
                } else {
                    movi.fnb++;
                    new FB(movi.fnb);
                    frame.dispose();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers!");
            }
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.fnb=0;
            new CoverPage();
            frame.dispose();
        }
        if(e.getSource()==done){
            int aa=0,bb=0,cc=0,dd=0,ee=0,ff=0,gg=0;
            try{
                if(1<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton3.getText().equals(""))){
                        aa = Integer.parseInt(myButton3.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(0).get(0)), aa);
                    }
                }
                if(2<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton4.getText().equals(""))){
                        bb = Integer.parseInt(myButton4.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(1).get(0)), bb);
                    }
                }
                if(3<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton5.getText().equals(""))){
                        cc = Integer.parseInt(myButton5.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(2).get(0)), cc);
                    }
                }
                if(4<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton6.getText().equals(""))){
                        dd = Integer.parseInt(myButton6.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(3).get(0)), dd);
                    }
                }
                if(5<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton7.getText().equals(""))){
                        ee = Integer.parseInt(myButton7.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(4).get(0)), ee);
                    }
                }
                if(6<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton8.getText().equals(""))){
                        ff = Integer.parseInt(myButton8.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(5).get(0)), ff);
                    }
                }
                if(7<=movi.fb.get(movi.fnb).size()){
                    if(!(myButton9.getText().equals(""))){
                        gg = Integer.parseInt(myButton9.getText());
                        updfb(Integer.parseInt(movi.fb.get(movi.fnb).get(6).get(0)), gg);
                    }
                }
                new Confirm();
                frame.dispose();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers!");
            }
        }
        System.out.println(cust.f_id);
    }
}
