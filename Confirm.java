import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.HashMap;
import feats.*;

public class Confirm extends JFrame implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("cust_confirm.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label1 = new JLabel();
    JLabel ttl, ln3;
    JTextArea content;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton next = new JButton("Checkout");
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    String text;
    Confirm(){
        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 1250, 750);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(JLabel.CENTER);

        ttl = new JLabel("Booking Confirmation");
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.white);
        ttl.setBounds(500, 100, 750, 60);
        // x+450

        String txt = "Movie: "+cust.title+"\nDate:  "+cust.date+"\nTime: "+cust.time+"\nHall:  "+cust.hallno+"\nSeats: ";
        if(cust.select.size()!=0){
            for(String i : cust.select){
                txt+=i+"  ";
            }
            txt+="\n          (  ";
            if(cust.adult!=0){
                txt+=cust.adult+"-Adult  ";
            }
            if(cust.children!=0){
                txt+=cust.children+"-Children  ";
            }
            if(cust.student!=0){
                txt+=cust.student+"-Student  ";
            }
            txt+=")";
        } else {
            txt+="Not Selected";
        }

        txt+="\n\nFood & Beverages: ";
        if(cust.f_id.size()!=0){
            for(String i : cust.f_id){
                hm.put(Integer.parseInt(i), getFreq(Integer.parseInt(i)));
            }
            for(Integer i : hm.keySet()){
                txt+="\n    - "+getName(i)+" x"+hm.get(i);
            }
        } else {
            txt+="Not Selected";
        }
        this.text=txt;
        int y1=5; //10

        ln3 = new JLabel();
        ln3.setBounds(500, 163+y1,500, 1);
        ln3.setOpaque(true);
        ln3.setBackground(design.mgray);
        frame.add(ln3);

        content = new JTextArea(txt);
        content.setBackground(design.dgray);
        content.setOpaque(true);
        content.setFocusable(false);
        content.setFont(design.ss26i);
        content.setForeground(design.lgray);
        content.setBounds(500, 188, 1000, 400);

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

        next.setBounds(1126,610,100,38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);

        label1.add(prevpage);
        label1.add(logout);
        label1.add(next);
        frame.add(ttl);
        frame.add(content);
        frame.add(label1);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==prevpage){
            movi.section2=0;
            new FB(movi.fnb);
            frame.dispose();
        }
        if(e.getSource()==next){
            new Payment(this.text);
            frame.dispose();
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            movi.section2=0;
            new CoverPage();
            frame.dispose();
        }
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

    public static String getName(Integer n){
        String re="";
        ArrayList<ArrayList<String>> arr = dbase.getAllFNB();
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).get(0).equals(n.toString())){
                re=arr.get(i).get(1);
            }
        }
        return re;
    }
}
