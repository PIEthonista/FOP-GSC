import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import feats.*;

public class SettingMovie implements ActionListener {

    JFrame frame = new JFrame("Setting The Movie");
    static JLabel label = new JLabel();
    JLabel accIcon = new JLabel();
    JButton myButton7 = new JButton("Log Out  "+staff.uname);
    JButton myButton6 = new JButton("Delete Food & Beverage");
    JButton myButton5 = new JButton("Add Food & Beverage");
    JButton myButton4 = new JButton("Movie Price");
    JButton myButton3 = new JButton("Theater Capacity");
    JButton myButton2 = new JButton("Delete Movie List");
    JButton myButton1 = new JButton("Add Movie List");
    Timer timer = new Timer();
    TimerTask task = new TimeKeeper2();

    public SettingMovie() {

        label = new JLabel("", JLabel.CENTER);

        label.setIcon(design.s1[0]);
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setHorizontalAlignment(JLabel.CENTER);

        myButton1.setBounds(225, 5, 200, 40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(design.dgray);
        myButton1.setForeground(design.lgray);
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);
        myButton1.addActionListener(this);

        myButton2.setBounds(425, 5, 200, 40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(design.dgray);
        myButton2.setForeground(design.lgray);
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(design.ss15);
        myButton2.addActionListener(this);

        myButton3.setBounds(625, 5, 200, 40);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(design.dgray);
        myButton3.setForeground(design.lgray);
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(design.ss15);
        myButton3.addActionListener(this);

        myButton4.setBounds(225, 45, 200, 40);
        myButton4.setVerticalAlignment(JLabel.CENTER);
        myButton4.setBackground(design.dgray);
        myButton4.setForeground(design.lgray);
        myButton4.setFocusable(false);
        myButton4.setHorizontalAlignment(JLabel.CENTER);
        myButton4.setFont(design.ss15);
        myButton4.addActionListener(this);

        myButton5.setBounds(425, 45, 200, 40);
        myButton5.setVerticalAlignment(JLabel.CENTER);
        myButton5.setBackground(design.dgray);
        myButton5.setForeground(design.lgray);
        myButton5.setFocusable(false);
        myButton5.setHorizontalAlignment(JLabel.CENTER);
        myButton5.setFont(design.ss15);
        myButton5.addActionListener(this);

        myButton6.setBounds(625, 45, 200, 40);
        myButton6.setVerticalAlignment(JLabel.CENTER);
        myButton6.setBackground(design.dgray);
        myButton6.setForeground(design.lgray);
        myButton6.setFocusable(false);
        myButton6.setHorizontalAlignment(JLabel.CENTER);
        myButton6.setFont(design.ss15);
        myButton6.addActionListener(this);

        myButton7.setBounds(875, 45, 280, 40);
        myButton7.setVerticalAlignment(JLabel.CENTER);
        myButton7.setBackground(design.dgray);
        myButton7.setForeground(design.lgray);
        myButton7.setFocusable(false);
        myButton7.setHorizontalAlignment(JLabel.RIGHT);
        myButton7.setFont(design.ss15);
        myButton7.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        label.add(myButton4);
        label.add(myButton5);
        label.add(myButton6);
        label.add(myButton7);
        frame.add(label);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        timer.schedule(task, 0, 4000);
    }

    public static long setImage(long n) {
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
            new AddMovieList();
            frame.dispose();
        }
        if (e.getSource()==myButton2){
            //new DeleteMovieList();
            frame.dispose();
        }
        if (e.getSource()==myButton3){
            cust.RESET();
            new TheaterCapacity();
            frame.dispose();
        }
        if (e.getSource()==myButton4){
            cust.RESET();
            new MoviePrice();
            frame.dispose();
        }
        if (e.getSource()==myButton5){
            cust.RESET();
            //new AddFB();
            frame.dispose();
        }
        if (e.getSource()==myButton6){
            cust.RESET();
            new DeleteFB();
            frame.dispose();
        }
        if (e.getSource()==myButton7){
            cust.RESET();
            new CoverPage();
            frame.dispose();
        }
    }
}
