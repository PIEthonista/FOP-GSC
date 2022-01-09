import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;            //yx
import java.util.TimerTask;        //yx
import java.util.ArrayList;
import feats.*;

public class BookandCancelMovie implements ActionListener {

    JFrame frame = new JFrame("LOGGED IN");
    static JLabel label = new JLabel();
    JLabel userIDLabel= new JLabel(cust.uname);
    JButton myButton3 = new JButton("LOGOUT");
    JButton myButton2 = new JButton("Book a Movie");
    JButton myButton1 = new JButton("Cancel Booking");
    Timer timer = new Timer();                    //yx
    TimerTask task = new TimeKeeper2();            //yx

    public BookandCancelMovie() {
        label = new JLabel("", JLabel.CENTER);
        //add(label, BorderLayout.CENTER);
        label.setIcon(design.s1[0]);
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);    //yx
        label.setHorizontalAlignment(JLabel.CENTER);

        //userIDLabel.setBounds(1045, 40,125,30);
        userIDLabel.setBounds(500, 500,125,30);
        //userIDLabel.setBackground(design.dgray);
        userIDLabel.setBackground(Color.blue);
        userIDLabel.setOpaque(true);
        userIDLabel.setFont(design.sui20);
        userIDLabel.setForeground(design.lgray);
        userIDLabel.setHorizontalAlignment(JLabel.RIGHT);

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

        myButton3.setBounds(875, 40, 160, 40);    //yx
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(design.yellow);
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);    //yx
        myButton3.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        frame.add(userIDLabel);
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
            label.setIcon(design.s1[0]);
        } else if (n % 8 == 1) {
            label.setIcon(design.s1[1]);
        } else if (n % 8 == 2) {
            label.setIcon(design.s1[2]);
        } else if (n % 8 == 3) {
            label.setIcon(design.s1[3]);
        } else if (n % 8 == 4) {
            label.setIcon(design.s1[4]);
        } else if (n % 8 == 5) {
            label.setIcon(design.s1[5]);
        } else if (n % 8 == 6) {
            label.setIcon(design.s1[6]);
        } else if (n % 8 == 7) {
            label.setIcon(design.s1[7]);
        }
        n++;
        return n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== myButton1){
            new CancelMovie();
            frame.dispose();
        }
        if (e.getSource()==myButton2){
            new BookMovie();
            frame.dispose();
        }
        if (e.getSource()==myButton3){
            cust.RESET();
            new CoverPage();
            frame.dispose();
        }
    }
}
