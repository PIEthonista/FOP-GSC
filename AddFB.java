import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class AddFB implements ActionListener{

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Edit Movie List");
    JLabel label = new JLabel();
    JLabel Titlelabel = new JLabel("Title");
    JTextField StudentpField = new JTextField();
    ArrayList<ArrayList<String>> arr;
    JLabel l3,l4,l5,l6,l7,l8,l9,l10 = new JLabel();
    JButton prevpage = new JButton("Previous Page");
    JButton Confirm = new JButton("Confirm");
    JButton AddMore= new JButton("+");
    JButton logout = new JButton("Log Out  "+staff.uname);

    public AddFB(){



        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        AddMore.setBounds(25, 615, 50, 40);    //yx
        AddMore.setVerticalAlignment(JLabel.CENTER);
        AddMore.setBackground(design.yellow);
        AddMore.setForeground(design.lred);
        AddMore.setFocusable(false);
        AddMore.setHorizontalAlignment(JLabel.CENTER);
        AddMore.setFont(design.ss15);    //yx
        AddMore.addActionListener(this);

        Confirm.setBounds(1050,615,150,38);
        Confirm.setVerticalAlignment(JLabel.CENTER);
        Confirm.setBackground(design.dgray);
        Confirm.setForeground(design.lgray);
        Confirm.setFocusable(false);
        Confirm.setHorizontalAlignment(JLabel.CENTER);
        Confirm.setFont(design.ss15);
        Confirm.addActionListener(this);

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

        label.add(AddMore);
        label.add(prevpage);
        label.add(logout);
        label.add(Confirm);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource()==AddMore){
            new AddMoreFB();
            frame.dispose();
        }
        if (e.getSource()==Confirm){
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource()==logout){
            staff.RESET();
            new CoverPage();
            frame.dispose();
        }
    }
}
