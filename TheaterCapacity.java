import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;            //yx
import java.util.TimerTask;        //yx
import java.util.ArrayList;
import feats.*;

public class TheaterCapacity implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Staff: LOGGED IN");
    static ArrayList<String> arr = new ArrayList<String>();                               // occupied/open for booking halls' unique array
    static ArrayList<Integer> arrno=new ArrayList<Integer>();   // min assignable SOP seat cap for each hall above
    JLabel label = new JLabel();
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton done = new JButton("Confirm");
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10;          // sep lines
    JLabel l3,l4,l5,l6,l7,l8,l9,l10;                  // Hall 01-08
    JLabel l32, l42, l52, l62, l72, l82, l92, l102;   // Hall 09-16
    // not used
    JLabel l33,l44,l55,l66,l77,l88,l99,l1010;         // left /160
    JLabel l332,l442,l552,l662,l772,l882,l992,l10102; // right /160
    JLabel text = new JLabel();

    JTextField l3l,l4l,l5l,l6l,l7l,l8l,l9l,l10l;          //
    JTextField l3l2,l4l2,l5l2,l6l2,l7l2,l8l2,l9l2,l10l2;  //


    TheaterCapacity(){
        arr.clear();
        arrno.clear();
        arr=dbase.getDTL_uniquehall();
        for(String i : arr){
            arrno.add(dbase.getDTL_hallmin(i));
        }

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

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

        done.setBounds(1126,120,100,38);
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

        // sep lines
        ln3 = new JLabel();
        ln3.setBounds(25, 163+y1,1200, 1);
        ln3.setOpaque(true);
        ln3.setBackground(design.mgray);
        frame.add(ln3);
        ln4 = new JLabel();
        ln4.setBounds(25, 225+y1,1200, 1);
        ln4.setOpaque(true);
        ln4.setBackground(design.mgray);
        frame.add(ln4);
        ln5 = new JLabel();
        ln5.setBounds(25, 288+y1,1200, 1);
        ln5.setOpaque(true);
        ln5.setBackground(design.mgray);
        frame.add(ln5);
        ln6 = new JLabel();
        ln6.setBounds(25, 350+y1,1200, 1);
        ln6.setOpaque(true);
        ln6.setBackground(design.mgray);
        frame.add(ln6);
        ln7 = new JLabel();
        ln7.setBounds(25, 413+y1,1200, 1);
        ln7.setOpaque(true);
        ln7.setBackground(design.mgray);
        frame.add(ln7);
        ln8 = new JLabel();
        ln8.setBounds(25, 475+y1,1200, 1);
        ln8.setOpaque(true);
        ln8.setBackground(design.mgray);
        frame.add(ln8);
        ln9 = new JLabel();
        ln9.setBounds(25, 538+y1,1200, 1);
        ln9.setOpaque(true);
        ln9.setBackground(design.mgray);
        frame.add(ln9);
        ln10 = new JLabel();
        ln10.setBounds(25, 600+y1,1200, 1);
        ln10.setOpaque(true);
        ln10.setBackground(design.mgray);
        frame.add(ln10);

        // left label Hall 01-08
        l3 = new JLabel("Hall 01");
        l3.setBounds(40, 163+y2, 200, 38);
        l3.setOpaque(true);
        l3.setBackground(design.dgray);
        l3.setForeground(design.lgray);
        l3.setFont(design.ss20i);
        frame.add(l3);
        l4 = new JLabel("Hall 02");
        l4.setBounds(40, 225+y2, 200, 38);
        l4.setOpaque(true);
        l4.setBackground(design.dgray);
        l4.setForeground(design.lgray);
        l4.setFont(design.ss20i);
        frame.add(l4);
        l5 = new JLabel("Hall 03");
        l5.setBounds(40, 288+y2, 200, 38);
        l5.setOpaque(true);
        l5.setBackground(design.dgray);
        l5.setForeground(design.lgray);
        l5.setFont(design.ss20i);
        frame.add(l5);
        l6 = new JLabel("Hall 04");
        l6.setBounds(40, 350+y2, 200, 38);
        l6.setOpaque(true);
        l6.setBackground(design.dgray);
        l6.setForeground(design.lgray);
        l6.setFont(design.ss20i);
        frame.add(l6);
        l7 = new JLabel("Hall 05");
        l7.setBounds(40, 413+y2, 200, 38);
        l7.setOpaque(true);
        l7.setBackground(design.dgray);
        l7.setForeground(design.lgray);
        l7.setFont(design.ss20i);
        frame.add(l7);
        l8 = new JLabel("Hall 06");
        l8.setBounds(40, 475+y2, 200, 38);
        l8.setOpaque(true);
        l8.setBackground(design.dgray);
        l8.setForeground(design.lgray);
        l8.setFont(design.ss20i);
        frame.add(l8);
        l9 = new JLabel("Hall 07");
        l9.setBounds(40, 538+y2, 200, 38);
        l9.setOpaque(true);
        l9.setBackground(design.dgray);
        l9.setForeground(design.lgray);
        l9.setFont(design.ss20i);
        frame.add(l9);
        l10 = new JLabel("Hall 08");
        l10.setBounds(40, 600+y2, 200, 38);
        l10.setOpaque(true);
        l10.setBackground(design.dgray);
        l10.setForeground(design.lgray);
        l10.setFont(design.ss20i);
        frame.add(l10);

        // right label Hall 09-16
        l32 = new JLabel("Hall 09");
        l32.setBounds(625, 163+y2, 200, 38);
        l32.setOpaque(true);
        l32.setBackground(design.dgray);
        l32.setForeground(design.lgray);
        l32.setFont(design.ss20i);
        frame.add(l32);
        l42 = new JLabel("Hall 10");
        l42.setBounds(625, 225+y2, 200, 38);
        l42.setOpaque(true);
        l42.setBackground(design.dgray);
        l42.setForeground(design.lgray);
        l42.setFont(design.ss20i);
        frame.add(l42);
        l52 = new JLabel("Hall 11");
        l52.setBounds(625, 288+y2, 200, 38);
        l52.setOpaque(true);
        l52.setBackground(design.dgray);
        l52.setForeground(design.lgray);
        l52.setFont(design.ss20i);
        frame.add(l52);
        l62 = new JLabel("Hall 12");
        l62.setBounds(625, 350+y2, 200, 38);
        l62.setOpaque(true);
        l62.setBackground(design.dgray);
        l62.setForeground(design.lgray);
        l62.setFont(design.ss20i);
        frame.add(l62);
        l72 = new JLabel("Hall 13");
        l72.setBounds(625, 413+y2, 200, 38);
        l72.setOpaque(true);
        l72.setBackground(design.dgray);
        l72.setForeground(design.lgray);
        l72.setFont(design.ss20i);
        frame.add(l72);
        l82 = new JLabel("Hall 14");
        l82.setBounds(625, 475+y2, 200, 38);
        l82.setOpaque(true);
        l82.setBackground(design.dgray);
        l82.setForeground(design.lgray);
        l82.setFont(design.ss20i);
        frame.add(l82);
        l92 = new JLabel("Hall 15");
        l92.setBounds(625, 538+y2, 200, 38);
        l92.setOpaque(true);
        l92.setBackground(design.dgray);
        l92.setForeground(design.lgray);
        l92.setFont(design.ss20i);
        frame.add(l92);
        l102 = new JLabel("Hall 16");
        l102.setBounds(625, 600+y2, 200, 38);
        l102.setOpaque(true);
        l102.setBackground(design.dgray);
        l102.setForeground(design.lgray);
        l102.setFont(design.ss20i);
        frame.add(l102);

        // left text box
        l3l=new JTextField();
        l3l.setBounds(420, 163+y2, 100, 38);
        l3l.setFont(design.ss20);
        l3l.setForeground(design.mgray);
        l3l.setBackground(design.lgray);
        if(inOcc("01")>-1){
            l3l.setText("> "+arrno.get(inOcc("01")).toString());
        }
        label.add(l3l);
        l4l=new JTextField();
        l4l.setBounds(420, 225+y2, 100, 38);
        l4l.setFont(design.ss20);
        l4l.setForeground(design.mgray);
        l4l.setBackground(design.lgray);
        if(inOcc("02")>-1){
            l4l.setText("> "+arrno.get(inOcc("02")).toString());
        }
        label.add(l4l);
        l5l=new JTextField();
        l5l.setBounds(420, 288+y2, 100, 38);
        l5l.setFont(design.ss20);
        l5l.setForeground(design.mgray);
        l5l.setBackground(design.lgray);
        if(inOcc("03")>-1){
            l5l.setText("> "+arrno.get(inOcc("03")).toString());
        }
        label.add(l5l);
        l6l=new JTextField();
        l6l.setBounds(420, 350+y2, 100, 38);
        l6l.setFont(design.ss20);
        l6l.setForeground(design.mgray);
        l6l.setBackground(design.lgray);
        if(inOcc("04")>-1){
            l6l.setText("> "+arrno.get(inOcc("04")).toString());
        }
        label.add(l6l);
        l7l=new JTextField();
        l7l.setBounds(420, 413+y2, 100, 38);
        l7l.setFont(design.ss20);
        l7l.setForeground(design.mgray);
        l7l.setBackground(design.lgray);
        if(inOcc("05")>-1){
            l7l.setText("> "+arrno.get(inOcc("05")).toString());
        }
        label.add(l7l);
        l8l=new JTextField();
        l8l.setBounds(420, 475+y2, 100, 38);
        l8l.setFont(design.ss20);
        l8l.setForeground(design.mgray);
        l8l.setBackground(design.lgray);
        if(inOcc("06")>-1){
            l8l.setText("> "+arrno.get(inOcc("06")).toString());
        }
        label.add(l8l);
        l9l=new JTextField();
        l9l.setBounds(420, 538+y2, 100, 38);
        l9l.setFont(design.ss20);
        l9l.setForeground(design.mgray);
        l9l.setBackground(design.lgray);
        if(inOcc("07")>-1){
            l9l.setText("> "+arrno.get(inOcc("07")).toString());
        }
        label.add(l9l);
        l10l=new JTextField();
        l10l.setBounds(420, 600+y2, 100, 38);
        l10l.setFont(design.ss20);
        l10l.setForeground(design.mgray);
        l10l.setBackground(design.lgray);
        if(inOcc("08")>-1){
            l10l.setText("> "+arrno.get(inOcc("08")).toString());
        }
        label.add(l10l);

        // right text box
        l3l2=new JTextField();
        l3l2.setBounds(1020, 163+y2, 100, 38);
        l3l2.setFont(design.ss20);
        l3l2.setForeground(design.mgray);
        l3l2.setBackground(design.lgray);
        if(inOcc("09")>-1){
            l3l2.setText("> "+arrno.get(inOcc("09")).toString());
        }
        label.add(l3l2);
        l4l2=new JTextField();
        l4l2.setBounds(1020, 225+y2, 100, 38);
        l4l2.setFont(design.ss20);
        l4l2.setForeground(design.mgray);
        l4l2.setBackground(design.lgray);
        if(inOcc("10")>-1){
            l4l2.setText("> "+arrno.get(inOcc("10")).toString());
        }
        label.add(l4l2);
        l5l2=new JTextField();
        l5l2.setBounds(1020, 288+y2, 100, 38);
        l5l2.setFont(design.ss20);
        l5l2.setForeground(design.mgray);
        l5l2.setBackground(design.lgray);
        if(inOcc("11")>-1){
            l5l2.setText("> "+arrno.get(inOcc("11")).toString());
        }
        label.add(l5l2);
        l6l2=new JTextField();
        l6l2.setBounds(1020, 350+y2, 100, 38);
        l6l2.setFont(design.ss20);
        l6l2.setForeground(design.mgray);
        l6l2.setBackground(design.lgray);
        if(inOcc("12")>-1){
            l6l2.setText("> "+arrno.get(inOcc("12")).toString());
        }
        label.add(l6l2);
        l7l2=new JTextField();
        l7l2.setBounds(1020, 413+y2, 100, 38);
        l7l2.setFont(design.ss20);
        l7l2.setForeground(design.mgray);
        l7l2.setBackground(design.lgray);
        if(inOcc("13")>-1){
            l7l2.setText("> "+arrno.get(inOcc("13")).toString());
        }
        label.add(l7l2);
        l8l2=new JTextField();
        l8l2.setBounds(1020, 475+y2, 100, 38);
        l8l2.setFont(design.ss20);
        l8l2.setForeground(design.mgray);
        l8l2.setBackground(design.lgray);
        if(inOcc("14")>-1){
            l8l2.setText("> "+arrno.get(inOcc("14")).toString());
        }
        label.add(l8l2);
        l9l2=new JTextField();
        l9l2.setBounds(1020, 538+y2, 100, 38);
        l9l2.setFont(design.ss20);
        l9l2.setForeground(design.mgray);
        l9l2.setBackground(design.lgray);
        if(inOcc("15")>-1){
            l9l2.setText("> "+arrno.get(inOcc("15")).toString());
        }
        label.add(l9l2);
        l10l2=new JTextField();
        l10l2.setBounds(1020, 600+y2, 100, 38);
        l10l2.setFont(design.ss20);
        l10l2.setForeground(design.mgray);
        l10l2.setBackground(design.lgray);
        if(inOcc("16")>-1){
            l10l2.setText("> "+arrno.get(inOcc("16")).toString());
        }
        label.add(l10l2);

        // left /160
        l33 = new JLabel("/160");
        l33.setBounds(525, 163+y2, 70, 38);
        l33.setOpaque(true);
        l33.setBackground(design.dgray);
        l33.setForeground(design.lgray);
        l33.setFont(design.ss20);
        frame.add(l33);
        l44 = new JLabel("/160");
        l44.setBounds(525, 225+y2, 70, 38);
        l44.setOpaque(true);
        l44.setBackground(design.dgray);
        l44.setForeground(design.lgray);
        l44.setFont(design.ss20);
        frame.add(l44);
        l55 = new JLabel("/160");
        l55.setBounds(525, 288+y2, 70, 38);
        l55.setOpaque(true);
        l55.setBackground(design.dgray);
        l55.setForeground(design.lgray);
        l55.setFont(design.ss20);
        frame.add(l55);
        l66 = new JLabel("/160");
        l66.setBounds(525, 350+y2, 70, 38);
        l66.setOpaque(true);
        l66.setBackground(design.dgray);
        l66.setForeground(design.lgray);
        l66.setFont(design.ss20);
        frame.add(l66);
        l77 = new JLabel("/160");
        l77.setBounds(525, 413+y2, 70, 38);
        l77.setOpaque(true);
        l77.setBackground(design.dgray);
        l77.setForeground(design.lgray);
        l77.setFont(design.ss20);
        frame.add(l77);
        l88 = new JLabel("/160");
        l88.setBounds(525, 475+y2, 70, 38);
        l88.setOpaque(true);
        l88.setBackground(design.dgray);
        l88.setForeground(design.lgray);
        l88.setFont(design.ss20);
        frame.add(l88);
        l99 = new JLabel("/160");
        l99.setBounds(525, 538+y2, 70, 38);
        l99.setOpaque(true);
        l99.setBackground(design.dgray);
        l99.setForeground(design.lgray);
        l99.setFont(design.ss20);
        frame.add(l99);
        l1010 = new JLabel("/160");
        l1010.setBounds(525, 600+y2, 70, 38);
        l1010.setOpaque(true);
        l1010.setBackground(design.dgray);
        l1010.setForeground(design.lgray);
        l1010.setFont(design.ss20);
        frame.add(l1010);

        // right /160
        l332 = new JLabel("/160");
        l332.setBounds(1125, 163+y2, 70, 38);
        l332.setOpaque(true);
        l332.setBackground(design.dgray);
        l332.setForeground(design.lgray);
        l332.setFont(design.ss20);
        frame.add(l332);
        l442 = new JLabel("/160");
        l442.setBounds(1125, 225+y2, 70, 38);
        l442.setOpaque(true);
        l442.setBackground(design.dgray);
        l442.setForeground(design.lgray);
        l442.setFont(design.ss20);
        frame.add(l442);
        l552 = new JLabel("/160");
        l552.setBounds(1125, 288+y2, 70, 38);
        l552.setOpaque(true);
        l552.setBackground(design.dgray);
        l552.setForeground(design.lgray);
        l552.setFont(design.ss20);
        frame.add(l552);
        l662 = new JLabel("/160");
        l662.setBounds(1125, 350+y2, 70, 38);
        l662.setOpaque(true);
        l662.setBackground(design.dgray);
        l662.setForeground(design.lgray);
        l662.setFont(design.ss20);
        frame.add(l662);
        l772 = new JLabel("/160");
        l772.setBounds(1125, 413+y2, 70, 38);
        l772.setOpaque(true);
        l772.setBackground(design.dgray);
        l772.setForeground(design.lgray);
        l772.setFont(design.ss20);
        frame.add(l772);
        l882 = new JLabel("/160");
        l882.setBounds(1125, 475+y2, 70, 38);
        l882.setOpaque(true);
        l882.setBackground(design.dgray);
        l882.setForeground(design.lgray);
        l882.setFont(design.ss20);
        frame.add(l882);
        l992 = new JLabel("/160");
        l992.setBounds(1125, 538+y2, 70, 38);
        l992.setOpaque(true);
        l992.setBackground(design.dgray);
        l992.setForeground(design.lgray);
        l992.setFont(design.ss20);
        frame.add(l992);
        l10102 = new JLabel("/160");
        l10102.setBounds(1125, 600+y2, 70, 38);
        l10102.setOpaque(true);
        l10102.setBackground(design.dgray);
        l10102.setForeground(design.lgray);
        l10102.setFont(design.ss20);
        frame.add(l10102);



        text.setBounds(60,130,990,30);
        text.setBackground(design.dgray);
        text.setOpaque(true);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setFont(design.ss13);
        text.setForeground(design.mgray);
        text.setText("Due to seats being booked, you can only set the maximum capacity of the hall larger than the given number, if stated.");
        frame.add(text);

        label.add(prevpage); // prev page
        label.add(logout);
        label.add(done);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==prevpage){
            new SettingMovie();
            frame.dispose();
        }
        if(e.getSource()==logout){
            staff.RESET();
            new CoverPage();
            frame.dispose();
        }
        if(e.getSource()==done){
            String h01=l3l.getText();
            String h02=l4l.getText();
            String h03=l5l.getText();
            String h04=l6l.getText();
            String h05=l7l.getText();
            String h06=l8l.getText();
            String h07=l9l.getText();
            String h08=l10l.getText();
            String h09=l3l2.getText();
            String h10=l4l2.getText();
            String h11=l5l2.getText();
            String h12=l6l2.getText();
            String h13=l7l2.getText();
            String h14=l8l2.getText();
            String h15=l9l2.getText();
            String h16=l10l2.getText();
            if(isValid(h01,"01")){
                if(isValid(h02,"02")){
                    if(isValid(h03,"03")){
                        if(isValid(h04,"04")){
                            if(isValid(h05,"05")){
                                if(isValid(h06,"06")){
                                    if(isValid(h07,"07")){
                                        if(isValid(h08,"08")){
                                            if(isValid(h09,"09")){
                                                if(isValid(h10,"10")){
                                                    if(isValid(h11,"11")){
                                                        if(isValid(h12,"12")){
                                                            if(isValid(h13,"13")){
                                                                if(isValid(h14,"14")){
                                                                    if(isValid(h15,"15")){
                                                                        if(isValid(h16,"16")){
                                                                            if(inOcc("01")>-1){
                                                                                dbase.updDTL_hallno("01",h01);
                                                                            }
                                                                            if(inOcc("02")>-1){
                                                                                dbase.updDTL_hallno("02",h02);
                                                                            }
                                                                            if(inOcc("03")>-1){
                                                                                dbase.updDTL_hallno("03",h03);
                                                                            }
                                                                            if(inOcc("04")>-1){
                                                                                dbase.updDTL_hallno("04",h04);
                                                                            }
                                                                            if(inOcc("05")>-1){
                                                                                dbase.updDTL_hallno("05",h05);
                                                                            }
                                                                            if(inOcc("06")>-1){
                                                                                dbase.updDTL_hallno("06",h06);
                                                                            }
                                                                            if(inOcc("07")>-1){
                                                                                dbase.updDTL_hallno("07",h07);
                                                                            }
                                                                            if(inOcc("08")>-1){
                                                                                dbase.updDTL_hallno("08",h08);
                                                                            }
                                                                            if(inOcc("09")>-1){
                                                                                dbase.updDTL_hallno("09",h09);
                                                                            }
                                                                            if(inOcc("10")>-1){
                                                                                dbase.updDTL_hallno("10",h10);
                                                                            }
                                                                            if(inOcc("11")>-1){
                                                                                dbase.updDTL_hallno("11",h11);
                                                                            }
                                                                            if(inOcc("12")>-1){
                                                                                dbase.updDTL_hallno("12",h12);
                                                                            }
                                                                            if(inOcc("13")>-1){
                                                                                dbase.updDTL_hallno("13",h13);
                                                                            }
                                                                            if(inOcc("14")>-1){
                                                                                dbase.updDTL_hallno("14",h14);
                                                                            }
                                                                            if(inOcc("15")>-1){
                                                                                dbase.updDTL_hallno("15",h15);
                                                                            }
                                                                            if(inOcc("16")>-1){
                                                                                dbase.updDTL_hallno("16",h16);
                                                                            }
                                                                            new SettingMovie();
                                                                            frame.dispose();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isValid(String hallno, String hall){
        boolean re=false;
        try{
            int num = Integer.parseInt(hallno);
            if(inOcc(hall)>-1){
                if(num>arrno.get(inOcc(hall)) && num<=160){
                    re=true;
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter a number ranging\nfrom "+(arrno.get(inOcc(hall))+1)+" - 160 for Hall "+hall);
                }
            } else {
                if(num>=0 && num<=160){
                    re=true;
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter a number ranging\nfrom 0 - 160 for Hall "+hall);
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer\nfor Hall "+hall);
        }
        return re;
    }

    public static int inOcc(String hall){   // check if hall is in occupied list, if yes returns index pos
        int re=-1;
        if(arr.size()>0){
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i).equals(hall)){
                    re=i;
                }
            }
        }
        return re;
    }
}
