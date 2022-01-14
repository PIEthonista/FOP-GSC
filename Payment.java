import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import feats.*;

public class Payment implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("cust_confirm.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label1 = new JLabel();
    JLabel ttl, ln3, content;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton done = new JButton("Pay"), credit=new JButton("Credit Card"), debit=new JButton("Debit Card");
    String txt;
    JLabel card= new JLabel("Card No. (XXXX-XXXX-XXXX-XXXX)");
    JTextField cardnum = new JTextField();

    Payment(String text){

        cust.t_amount=getPay();
        this.txt=text;

        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 1250, 750);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(JLabel.CENTER);

        ttl = new JLabel("Payment Information");
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.white);
        ttl.setBounds(500, 100, 750, 60);

        int y1=5; //10
        ln3 = new JLabel();
        ln3.setBounds(500, 163+y1,500, 1);
        ln3.setOpaque(true);
        ln3.setBackground(design.mgray);
        frame.add(ln3);

        content = new JLabel("Amount to pay: MYR "+getPay().toString());
        content.setHorizontalAlignment(JLabel.LEFT);
        content.setVerticalAlignment(JLabel.BOTTOM);
        content.setBackground(design.dgray);
        content.setOpaque(true);
        content.setFocusable(false);
        content.setFont(design.ss23);
        content.setForeground(design.lgray);
        content.setBounds(520, 188, 600, 50);

        credit.setBounds(520, 320, 200, 100);
        credit.setVerticalAlignment(JLabel.CENTER);
        credit.setBackground(design.yellow);
        credit.setForeground(design.dgray);
        credit.setFocusable(false);
        credit.setHorizontalAlignment(JLabel.CENTER);
        credit.setFont(design.ss20);
        credit.addActionListener(this);

        debit.setBounds(730, 320, 200, 100);
        debit.setVerticalAlignment(JLabel.CENTER);
        debit.setBackground(design.yellow);
        debit.setForeground(design.dgray);
        debit.setFocusable(false);
        debit.setHorizontalAlignment(JLabel.CENTER);
        debit.setFont(design.ss20);
        debit.addActionListener(this);

        card.setHorizontalAlignment(JLabel.LEFT);
        card.setVerticalAlignment(JLabel.BOTTOM);
        card.setBackground(design.dgray);
        card.setOpaque(true);
        card.setFocusable(false);
        card.setFont(design.sui20);
        card.setForeground(design.lgray);
        card.setBounds(520, 460, 600, 30);

        cardnum.setBounds(520, 505, 600, 30);
        cardnum.setFont(design.ss20i);
        cardnum.setForeground(design.mgray);
        cardnum.setBackground(design.lgray);

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

        done.setBounds(1126,610,100,38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.yellow);
        done.setForeground(design.dgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.sui15);    //yx
        done.addActionListener(this);


        label1.add(prevpage);
        label1.add(logout);
        label1.add(done);
        label1.add(credit);
        label1.add(debit);
        frame.add(cardnum);
        frame.add(card);
        frame.add(content);
        frame.add(ttl);
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
            new Confirm();
            frame.dispose();
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            movi.section2=0;
            new CoverPage();
            frame.dispose();
        }
        if(e.getSource()==credit){
            credit.setBackground(design.orange);
            debit.setBackground(design.yellow);
            cust.t_cardtype="Credit";
        }
        if(e.getSource()==debit){
            debit.setBackground(design.orange);
            credit.setBackground(design.yellow);
            cust.t_cardtype="Debit";
        }
        if(e.getSource()==done){
            String card = cardnum.getText();
            if(checkCard(card)){
                cust.t_cardnum=card;
                boolean status=false;
                try{
                    LocalDate ld = LocalDate.now();
                    cust.t_date=ld.toString();

                    LocalDateTime DateTimeObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String HHmm = DateTimeObj.format(myFormatObj);
                    cust.t_time = HHmm;

                    // TODO GENERATE QR & SEND EMAIL
                    TicketImage.genTicket();
                    JOptionPane.showMessageDialog(null, "Please allow some time for us to\ngenerate and email you your ticket!");
                    if(Email2.sendMessage(cust.email, true)){
                        JOptionPane.showMessageDialog(null, "Your ticket has been sent to your\nemail: "+cust.email+"!\nCheck your MailBox!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error sending ticket to your\nemail:"+cust.email+"!\nPlease check your WIFI connection\nor email validity.");
                    }
                    FP.delFile("movieticket.png");
                    FP.delFile("qr.png");

                    status=true;
                    new Summary(status, this.txt);
                    frame.dispose();
                } catch (Exception ex){}
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Card Number.\nPlease re-enter again.");
            }

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

    public static Integer getPrice(Integer id){
        Integer re=0;
        ArrayList<ArrayList<String>> fnb = dbase.getAllFNB();
        for(int i=0; i<fnb.size(); i++){
            if(fnb.get(i).get(0).equals(id.toString())){
                re=Integer.parseInt(fnb.get(i).get(3));
            }
        }
        return re;
    }

    public static ArrayList<Integer> getASCprice(String title){
        ArrayList<ArrayList<String>> mov = dbase.getAllMovies();
        ArrayList<Integer> re = new ArrayList<Integer>();
        re.add(0);
        re.add(0);
        re.add(0);
        for(int i=0; i<mov.size(); i++){
            if(mov.get(i).get(1).equals(title)){
                re.clear();
                re.add(Integer.parseInt(mov.get(i).get(4)));
                re.add(Integer.parseInt(mov.get(i).get(5)));
                re.add(Integer.parseInt(mov.get(i).get(6)));
            }
        }
        return re;
    }

    public static Integer getPay(){  // 0=text, 1=pay value
        Integer re=0;
        ArrayList<ArrayList<String>> fnb = dbase.getAllFNB();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if(cust.f_id.size()!=0){
            for(String i : cust.f_id){
                hm.put(Integer.parseInt(i), getFreq(Integer.parseInt(i)));
            }
            for(Integer i : hm.keySet()){
                re+=getPrice(i)*(hm.get(i));
            }
        }
        ArrayList<Integer> asc = getASCprice(cust.title);
        re+=(cust.adult)*(asc.get(0));
        re+=(cust.student)*(asc.get(1));
        re+=(cust.children)*(asc.get(2));
        return re;
    }
    // |         |
    // 0123456789012345678
    // xxxx-xxxx-xxxx-xxxx
    public static boolean checkCard(String card){
        boolean status=false;
        try{
            if(card.length()==19){
                if(card.charAt(4)=='-' && card.charAt(9)=='-' && card.charAt(14)=='-'){
                    Integer.parseInt(card.substring(0,4));
                    Integer.parseInt(card.substring(5,9));
                    Integer.parseInt(card.substring(10,14));
                    Integer.parseInt(card.substring(15));
                    status=true;
                }
            }
        } catch (Exception e){}
        return status;
    }
}
