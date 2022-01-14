import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class AddMoreFB implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Add Movie List");
    JLabel label = new JLabel();
    ArrayList<ArrayList<String>> arr;
    JButton Done = new JButton("Done");
    JButton logout = new JButton("Log Out  " + staff.uname);

    public AddMoreFB() {

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        Done.setBounds(1050,615,150,38);
        Done.setVerticalAlignment(JLabel.CENTER);
        Done.setBackground(design.dgray);
        Done.setForeground(design.lgray);
        Done.setFocusable(false);
        Done.setHorizontalAlignment(JLabel.CENTER);
        Done.setFont(design.ss15);
        Done.addActionListener(this);

        logout.setBounds(875, 33, 280, 40);    //yx
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);    //yx
        logout.addActionListener(this);


        label.add(logout);
        label.add(Done);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Done) {
            new AddFB();
            frame.dispose();
        }
        if (e.getSource() == logout) {
            staff.RESET();
            new CoverPage();
            frame.dispose();
        }
    }
}
