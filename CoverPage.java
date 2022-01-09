import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;            //yx
import java.util.TimerTask;        //yx
import java.util.ArrayList;
import feats.*;

public class CoverPage extends JFrame implements ActionListener {

    JFrame frame = new JFrame("GOLDEN SCREEN CINEMA");
    //JLabel label = new JLabel();
    static JLabel label = new JLabel();    //yx
    JButton myButton1 = new JButton("CREATE ACCOUNT");
    JButton myButton2 = new JButton("LOGIN");
    JButton myButton3 = new JButton("NEW STAFF");
    JButton myButton4 = new JButton("STAFF LOGIN");
    Timer timer = new Timer();                    //yx
    TimerTask task = new TimeKeeper();            //yx

    public CoverPage() {
        //ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
        //C:\Users\RONYLAU123\IdeaProjects\RONYLAU\src\ExampleGSC\GSC.png
        //setSize(2000, 1500);
        label = new JLabel("", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
        label.setIcon(design.s[0]);
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);    //yx
        label.setHorizontalAlignment(JLabel.CENTER);

        // default x=220 y=275 w=300 h=40
        myButton1.setBounds(675, 40, 160, 40);    //yx
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(design.yellow);
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);    //yx
        myButton1.addActionListener(this);

        myButton2.setBounds(505, 40, 160, 40);    //yx
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(design.yellow);
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);    //yx
        myButton2.addActionListener(this);

        myButton3.setBounds(1045, 40, 160, 40);    //yx
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(design.yellow);
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);    //yx
        myButton3.addActionListener(this);

        myButton4.setBounds(875, 40, 160, 40);    //yx
        myButton4.setVerticalAlignment(JLabel.CENTER);
        myButton4.setBackground(design.yellow);
        myButton4.setFocusable(false);
        myButton4.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);    //yx
        myButton4.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        label.add(myButton4);
        frame.add(label);
        frame.setResizable(false);
        //frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(750, 750);
        frame.setSize(1250, 750);    //yx
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        timer.schedule(task, 0, 4000);   //yx
        //timer.cancel();
        //timer.purge();

    }

    public static long setImage(long n) {          //yx
        //System.out.println("setImage()");
        if (n % 8 == 0) {
            label.setIcon(design.s[0]);
        } else if (n % 8 == 1) {
            label.setIcon(design.s[1]);
        } else if (n % 8 == 2) {
            label.setIcon(design.s[2]);
        } else if (n % 8 == 3) {
            label.setIcon(design.s[3]);
        } else if (n % 8 == 4) {
            label.setIcon(design.s[4]);
        } else if (n % 8 == 5) {
            label.setIcon(design.s[5]);
        } else if (n % 8 == 6) {
            label.setIcon(design.s[6]);
        } else if (n % 8 == 7) {
            label.setIcon(design.s[7]);
        }
        n++;
        return n;
    }

        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == myButton1) {
                new CustomerSignIn(true);
                frame.dispose();
            }
            if (e.getSource() == myButton2) {
                new CustomerLogIn(true, 0);
                frame.dispose();
            }
            if (e.getSource() == myButton3) {
                new StaffSignIn(true);
                frame.dispose();
            }
            if (e.getSource() == myButton4) {
                new StaffLogIn(true, 0);
                frame.dispose();
            }
            timer.cancel();    //yx
            timer.purge();     //yx
        }
    }
