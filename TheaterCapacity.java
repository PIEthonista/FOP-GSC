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
    ArrayList<String> arr;      // occupied/open for booking halls' unique array
    ArrayList<Integer> arrno;   // min assignable SOP seat cap for each hall above
    JLabel label = new JLabel();
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton done = new JButton("Confirm");
    JLabel ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10;
    JLabel l33,l44,l55,l66,l77,l88,l99,l1010;         // Hall 01-08
    JLabel l332,l442,l552,l662,l772,l882,l992,l10102; // Hall 09-16

    JTextField l3l,l4l,l5l,l6l,l7l,l8l,l9l,l10l;          // /160
    JTextField l3l2,l4l2,l5l2,l6l2,l7l2,l8l2,l9l2,l10l2;  // /160


    TheaterCapacity(){
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

    }
}
