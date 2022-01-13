import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import feats.*;

public class seat1 extends JFrame implements ActionListener {
    String title,date,time,hall;
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label = new JLabel(), pgnum = new JLabel();
    ArrayList<ArrayList<String>> sop = new ArrayList<ArrayList<String>>();
    // JButton 1-160
    String [] lval = {"a01","a02","a03",
                      "b01","b02","b03",
                      "c01","c02","c03",
                      "d01","d02","d03",
                      "e01","e02","e03",
                      "f01","f02","f03",
                      "g01","g02","g03",
                      "h01","h02","h03",
                      "i01","i02","i03",
                      "j01","j02","j03"};
    JButton [] sl = new JButton[60];

    String [] mval = {"a04","a05","a06","a07","a08","a09","a10","a11","a12","a13",
                      "b04","b05","b06","b07","b08","b09","b10","b11","b12","b13",
                      "c04","c05","c06","c07","c08","c09","c10","c11","c12","c13",
                      "d04","d05","d06","d07","d08","d09","d10","d11","d12","d13",
                      "e04","e05","e06","e07","e08","e09","e10","e11","e12","e13",
                      "f04","f05","f06","f07","f08","f09","f10","f11","f12","f13",
                      "g04","g05","g06","g07","g08","g09","g10","g11","g12","g13",
                      "h04","h05","h06","h07","h08","h09","h10","h11","h12","h13",
                      "i04","i05","i06","i07","i08","i09","i10","i11","i12","i13",
                      "j04","j05","j06","j07","j08","j09","j10","j11","j12","j13"};
    JButton [] sm = new JButton[100];

    String [] rval = {"a14","a15","a16",
                      "b14","b15","b16",
                      "c14","c15","c16",
                      "d14","d15","d16",
                      "e14","e15","e16",
                      "f14","f15","f16",
                      "g14","g15","g16",
                      "h14","h15","h16",
                      "i14","i15","i16",
                      "j14","j15","j16"};
    JButton [] sr = new JButton[30];

    JTextField adult = new JTextField();
    JTextField child = new JTextField();
    JTextField student = new JTextField();
    JLabel ad = new JLabel();
    JLabel ch = new JLabel();
    JLabel st = new JLabel();
    JLabel num = new JLabel();
    JButton next = new JButton("Next");
    JPanel panelL;
    JPanel panelM;
    JPanel panelR;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);


    seat1(String title, String date, String time, String hall){
        this.title=title;
        this.date=date;
        this.time=time;
        this.hall=hall;

        ArrayList<String> arr = dbase.getSpecDTL_all(title, date, time, hall);

        sop.clear();
        sop = SOP(arr);

        //test grounds
        /*
        System.out.println("===== LEFT"+sop.get(0).size());
        int ind=0;
        for(int i=1; i<=10; i++){

            for(int j=0; j<3; j++){
                System.out.print(sop.get(0).get(j+ind)+"  ");
            }
            System.out.println("");
            ind+=3;
        }
        System.out.println("===== MIDDLE"+sop.get(1).size());
        ind=0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<9; j++){
                System.out.print(sop.get(1).get(j+ind)+"  ");
            }
            System.out.println("");
            ind+=10;
        }
        System.out.println("===== RIGHT"+sop.get(2).size());
        ind=0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<3; j++){
                System.out.print(sop.get(2).get(j+ind)+"  ");
            }
            System.out.println("");
            ind+=3;
        }
        //END test grounds
        */


        int x=42;
        int y=-20;
        //Button Size, x=48, y=48
        // Left Panel
        panelL = new JPanel();    //  895, 495
        panelL.setBackground(design.dgray);
        panelL.setBounds(150+x, 150+y, 144, 480);
        panelL.setLayout(new GridLayout(10, 3, 2, 10));
        for(int k=0; k<30; k++){
            sl[k] = new JButton();
            sl[k].addActionListener(this);
            sl[k].setBackground(design.yellow);
            panelL.add(sl[k]);
        }
        for(int k=0; k<30; k++){
            if(sop.get(0).get(k).equals("1") || sop.get(0).get(k).equals("#")){
                sl[k].setBackground(design.mgray);
            }
            if(check(lval[k])){
                sl[k].setBackground(design.orange);
            }
        }
        // Mid Panel
        panelM = new JPanel();
        panelM.setBackground(design.dgray);
        panelM.setBounds(344+x, 150+y, 480,480);
        panelM.setLayout(new GridLayout(10, 10, 2, 10));
        for(int k=0; k<100; k++){
            sm[k] = new JButton();
            sm[k].addActionListener(this);
            sm[k].setBackground(design.yellow);
            panelM.add(sm[k]);
        }
        for(int k=0; k<100; k++){
            if(sop.get(1).get(k).equals("1") || sop.get(1).get(k).equals("#")){
                sm[k].setBackground(design.mgray);
            }
            if(check(mval[k])){
                sm[k].setBackground(design.orange);
            }
        }
        // Right Panel
        panelR = new JPanel();    //  895, 495
        panelR.setBackground(design.dgray);
        panelR.setBounds(874+x, 150+y, 144, 480);
        panelR.setLayout(new GridLayout(10, 3, 2, 10));
        for(int k=0; k<30; k++){
            sr[k] = new JButton();
            sr[k].addActionListener(this);
            sr[k].setBackground(design.yellow);
            panelR.add(sr[k]);
        }
        for(int k=0; k<30; k++){
            if(sop.get(2).get(k).equals("1") || sop.get(2).get(k).equals("#")){
                sr[k].setBackground(design.mgray);
            }
            if(check(rval[k])){
                sr[k].setBackground(design.orange);
            }
        }

        pgnum.setBounds(130,98,990,30);
        pgnum.setBackground(design.dgray);
        pgnum.setOpaque(true);
        pgnum.setHorizontalAlignment(JLabel.CENTER);
        pgnum.setFont(design.ss15);
        pgnum.setForeground(design.lgray);
        pgnum.setText("FRONT");

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

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

        num.setBounds(193, 620, 190, 30);
        num.setOpaque(true);
        num.setBackground(design.dgray);
        num.setFont(design.ss17);
        num.setForeground(design.lgray);
        num.setHorizontalAlignment(JLabel.LEFT);
        num.setText("Selected Seats: "+cust.select.size());

        ad.setBounds(400, 620, 200, 30);
        ad.setOpaque(true);
        ad.setFont(design.ss15);
        ad.setForeground(design.lgray);
        ad.setBackground(design.dgray);
        ad.setHorizontalAlignment(JLabel.RIGHT);
        ad.setText("Enter quantity for Adult:");

        adult.setBounds(600, 620, 50, 30);
        adult.setOpaque(true);
        adult.setFont(design.ss17);
        adult.setForeground(design.lgray);
        adult.setBackground(design.mdgray);
        adult.setText("0");

        ch.setBounds(680, 620, 70, 30);
        ch.setOpaque(true);
        ch.setFont(design.ss15);
        ch.setForeground(design.lgray);
        ch.setBackground(design.dgray);
        ch.setHorizontalAlignment(JLabel.RIGHT);
        ch.setText("Children:");

        child.setBounds(750, 620, 50, 30);
        child.setOpaque(true);
        child.setFont(design.ss17);
        child.setForeground(design.lgray);
        child.setBackground(design.mdgray);
        child.setText("0");

        st.setBounds(830, 620, 70, 30);
        st.setOpaque(true);
        st.setFont(design.ss15);
        st.setForeground(design.lgray);
        st.setBackground(design.dgray);
        st.setHorizontalAlignment(JLabel.RIGHT);
        st.setText("Student:");

        student.setBounds(900, 620, 50, 30);
        student.setOpaque(true);
        student.setFont(design.ss17);
        student.setForeground(design.lgray);
        student.setBackground(design.mdgray);
        student.setText("0");

        next.setBounds(1126,610,100,38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);


        label.add(prevpage); // prev page
        label.add(logout);
        label.add(next);
        frame.add(panelL);
        frame.add(panelM);
        frame.add(panelR);
        frame.add(pgnum);
        frame.add(num);
        frame.add(adult);
        frame.add(student);
        frame.add(child);
        frame.add(ad);
        frame.add(st);
        frame.add(ch);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<30; i++){
            if(e.getSource()==sl[i]){
                if (sop.get(0).get(i).equals("0")) {
                    if(!check(lval[i])){
                        sl[i].setBackground(design.orange);
                        cust.select.add(lval[i]);
                    } else {
                        if(remove(lval[i])){
                            sl[i].setBackground(design.yellow);
                        }
                    }
                    num.setText("Selected Seats: "+cust.select.size());
                }
            }
        }
        for(int i=0; i<30; i++){
            if(e.getSource()==sr[i]){
                if (sop.get(2).get(i).equals("0")){
                    if(!check(rval[i])){
                        sr[i].setBackground(design.orange);
                        cust.select.add(rval[i]);
                    } else {
                        if(remove(rval[i])){
                            sr[i].setBackground(design.yellow);
                        }
                    }
                    num.setText("Selected Seats: "+cust.select.size());
                }
            }
        }
        for(int i=0; i<100; i++){
            if(e.getSource()==sm[i]){
                if (sop.get(1).get(i).equals("0")){
                    if(!check(mval[i])){
                        sm[i].setBackground(design.orange);
                        cust.select.add(mval[i]);
                    } else {
                        if(remove(mval[i])){
                            sm[i].setBackground(design.yellow);
                        }
                    }
                    num.setText("Selected Seats: "+cust.select.size());
                }
            }
        }
        //System.out.println(cust.select);
        if (e.getSource()==prevpage){
            new Detail1(title, movi.section2);
            cust.select.clear();
            frame.dispose();
        }
        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            movi.section2=0;
            new CoverPage();
            frame.dispose();
        }
        if (e.getSource()==next){
            int adn=0, chn=0, stn=0;
            try{
                if(!(adult.getText().equals(""))){
                    adn = Integer.parseInt(adult.getText());
                }
                if(!(child.getText().equals(""))){
                    chn = Integer.parseInt(child.getText());
                }
                if(!(student.getText().equals(""))){
                    stn = Integer.parseInt(student.getText());
                }
                if((adn+stn+chn)!=cust.select.size()){
                    JOptionPane.showMessageDialog(null, "The numbers don't add up to the\namount of selected seats!");
                } else{
                    cust.adult=adn;
                    cust.children=chn;
                    cust.student=stn;
                    cust.title = this.title;
                    cust.date = this.date;
                    cust.time = this.time;
                    cust.hallno = this.hall;
                    new FB(movi.fnb);
                    frame.dispose();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers!");
            }
        }
    }

    public static ArrayList<ArrayList<String>> SOP(ArrayList<String> ori){
        ArrayList<String> arr =  new ArrayList<String>();
        for(int i=6; i<=165; i++){
            arr.add(ori.get(i));
        }
        //separate to section L=30, M=100, R=30
        int lm=3, rm=12, bound=15;
        ArrayList<String> left = new ArrayList<String>();   // 30
        ArrayList<String> mid = new ArrayList<String>();    // 100
        ArrayList<String> right = new ArrayList<String>();  // 30
        for(int i=0; i<160; i++){
            if(i<lm){
                left.add(arr.get(i));
            } else if(i>=lm && i<=rm){
                mid.add(arr.get(i));
            } else if(i>rm){
                right.add(arr.get(i));
            }
            if(i==bound){
                lm+=16;
                rm+=16;
                bound+=16;
            }
        }
        // 0=available, 1=taken, #=SOP
        // ====== operation on LEFT 10 rows (3 col each), separately
        int ind=0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<2; j++){
                if(left.get(ind+j).equals("1") && left.get(ind+j+1).equals("0")){
                    left.set(ind+j+1, "#");
                }
                if(left.get(ind+j).equals("0") && left.get(ind+j+1).equals("1")){
                    left.set(ind+j, "#");
                }
            }
            ind+=3;
        }
        // ====== operation on RIGHT 10 rows (3 col each), separately
        ind=0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<2; j++){
                if(right.get(ind+j).equals("1") && right.get(ind+j+1).equals("0")){
                    right.set(ind+j+1, "#");
                }
                if(right.get(ind+j).equals("0") && right.get(ind+j+1).equals("1")){
                    right.set(ind+j, "#");
                }
            }
            ind+=3;
        }
        // ====== operation on MIDDLE 10 rows (10 col each), separately
        ind=0;
        for(int i=1; i<=10; i++){
            for(int j=0; j<9; j++){
                if(mid.get(ind+j).equals("1") && mid.get(ind+j+1).equals("0")){
                    mid.set(ind+j+1, "#");
                }
                if(mid.get(ind+j).equals("0") && mid.get(ind+j+1).equals("1")){
                    mid.set(ind+j, "#");
                }
            }
            ind+=10;
        }
        ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        re.add(left);
        re.add(mid);
        re.add(right);
        return re;
    }

    public static boolean check(String s){
        boolean status=false;
        if(cust.select.size()!=0){
            for(int i=0; i<cust.select.size(); i++){
                if(cust.select.get(i).equals(s)){
                    status=true;
                    break;
                }
            }
        }
        return status;
    }

    public static boolean remove(String s){
        boolean status=false;
        if(cust.select.size()!=0){
            int index=0;
            for(int i=0; i<cust.select.size(); i++){
                if (cust.select.get(i).equals(s)){
                    index=i;
                    status=true;
                }
            }
            cust.select.remove(index);
        }
        return status;
    }
}
