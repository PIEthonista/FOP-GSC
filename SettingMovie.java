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
    JButton logout = new JButton("Log Out  "+staff.uname);
    JButton AddFB = new JButton("Add Food & Beverage");
    JButton MoviePrice = new JButton("Movie Price");
    JButton TheaterCapacity = new JButton("Theater Capacity");
    JButton DeleteMovie = new JButton("Delete Movie List");
    JButton AddMovie = new JButton("Add Movie List");
    Timer timer = new Timer();
    TimerTask task = new TimeKeeper2();

    public SettingMovie() {

        label = new JLabel("", JLabel.CENTER);
        label.setIcon(design.s1[0]);
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setHorizontalAlignment(JLabel.CENTER);

        AddMovie.setBounds(225, 5, 200, 40);
        AddMovie.setVerticalAlignment(JLabel.CENTER);
        AddMovie.setBackground(design.dgray);
        AddMovie.setForeground(design.lgray);
        AddMovie.setFocusable(false);
        AddMovie.setHorizontalAlignment(JLabel.CENTER);
        AddMovie.setFont(design.ss15);
        AddMovie.addActionListener(this);

        DeleteMovie.setBounds(425, 5, 200, 40);
        DeleteMovie.setVerticalAlignment(JLabel.CENTER);
        DeleteMovie.setBackground(design.dgray);
        DeleteMovie.setForeground(design.lgray);
        DeleteMovie.setFocusable(false);
        DeleteMovie.setHorizontalAlignment(JLabel.CENTER);
        DeleteMovie.setFont(design.ss15);
        DeleteMovie.addActionListener(this);

        TheaterCapacity.setBounds(625, 5, 200, 40);
        TheaterCapacity.setVerticalAlignment(JLabel.CENTER);
        TheaterCapacity.setBackground(design.dgray);
        TheaterCapacity.setForeground(design.lgray);
        TheaterCapacity.setFocusable(false);
        TheaterCapacity.setHorizontalAlignment(JLabel.CENTER);
        TheaterCapacity.setFont(design.ss15);
        TheaterCapacity.addActionListener(this);

        MoviePrice.setBounds(225, 45, 200, 40);
        MoviePrice.setVerticalAlignment(JLabel.CENTER);
        MoviePrice.setBackground(design.dgray);
        MoviePrice.setForeground(design.lgray);
        MoviePrice.setFocusable(false);
        MoviePrice.setHorizontalAlignment(JLabel.CENTER);
        MoviePrice.setFont(design.ss15);
        MoviePrice.addActionListener(this);

        AddFB.setBounds(425, 45, 200, 40);
        AddFB.setVerticalAlignment(JLabel.CENTER);
        AddFB.setBackground(design.dgray);
        AddFB.setForeground(design.lgray);
        AddFB.setFocusable(false);
        AddFB.setHorizontalAlignment(JLabel.CENTER);
        AddFB.setFont(design.ss15);
        AddFB.addActionListener(this);

        logout.setBounds(875, 45, 280, 40);
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);
        logout.addActionListener(this);

        label.add(AddMovie);
        label.add(DeleteMovie);
        label.add(TheaterCapacity);
        label.add(MoviePrice);
        label.add(AddFB);
        label.add(logout);
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
        if (e.getSource()== AddMovie){
            new AddMovieList();
            frame.dispose();
        }
        if (e.getSource()==DeleteMovie){
            new DeleteMovieList();
            frame.dispose();
        }
        if (e.getSource()==TheaterCapacity){
            new TheaterCapacity();
            frame.dispose();
        }
        if (e.getSource()==MoviePrice){
            new MoviePrice(movi.section);
            frame.dispose();
        }
        if (e.getSource()==AddFB){
            new AddFB();
            frame.dispose();
        }
        if (e.getSource()==logout){
            staff.RESET();
            new CoverPage();
            frame.dispose();
        }
    }
}
