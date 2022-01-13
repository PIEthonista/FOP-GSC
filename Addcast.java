import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class Addcast implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Add Cast List");
    JLabel label = new JLabel();
    JLabel actorNamelabel = new JLabel("Actor Name");
    JLabel movieNamelabel = new JLabel("Movie Name");
    JTextField ActorNameField = new JTextField();
    JTextField MovieNameField = new JTextField();
    JButton AddCast = new JButton("Add Cast");
    JButton AddShowTime = new JButton("ShowTime");
    JButton logout = new JButton("Log Out  "+staff.uname);

    public Addcast(){

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        actorNamelabel.setBounds(200, 200, 125, 30);
        actorNamelabel.setBackground(design.dgray);
        actorNamelabel.setOpaque(true);
        actorNamelabel.setFont(design.sui20);
        actorNamelabel.setForeground(design.lgray);
        actorNamelabel.setHorizontalAlignment(JLabel.RIGHT);

        movieNamelabel.setBounds(200, 400, 125, 30);
        movieNamelabel.setBackground(design.dgray);
        movieNamelabel.setOpaque(true);
        movieNamelabel.setFont(design.sui20);
        movieNamelabel.setForeground(design.lgray);
        movieNamelabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        ActorNameField.setBounds(375, 200, 700, 30);
        ActorNameField.setFont(design.ss20i);
        ActorNameField.setForeground(design.mgray);
        ActorNameField.setBackground(design.lgray);

        MovieNameField.setBounds(375, 400, 700, 30);
        MovieNameField.setFont(design.ss20i);
        MovieNameField.setForeground(design.mgray);
        MovieNameField.setBackground(design.lgray);

        AddCast.setBounds(800,600,160,38);
        AddCast.setVerticalAlignment(JLabel.CENTER);
        AddCast.setBackground(design.mgray);
        AddCast.setForeground(design.lgray);
        AddCast.setFocusable(false);
        AddCast.setHorizontalAlignment(JLabel.CENTER);
        AddCast.setFont(design.ss15);
        AddCast.addActionListener(this);

        AddShowTime.setBounds(1000,600,160,38);
        AddShowTime.setVerticalAlignment(JLabel.CENTER);
        AddShowTime.setBackground(design.mgray);
        AddShowTime.setForeground(design.lgray);
        AddShowTime.setFocusable(false);
        AddShowTime.setHorizontalAlignment(JLabel.CENTER);
        AddShowTime.setFont(design.ss15);
        AddShowTime.addActionListener(this);

        logout.setBounds(870, 33, 280, 40);
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.mgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.CENTER);
        logout.setFont(design.ss15);
        logout.addActionListener(this);

        label.add(AddCast);
        label.add(AddShowTime);
        label.add(logout);
        frame.add(actorNamelabel);
        frame.add(movieNamelabel);
        frame.add(ActorNameField);
        frame.add(MovieNameField);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddCast){
            new Addcast();
            frame.dispose();
        }
        if (e.getSource() == AddShowTime){
            new AddShowTime();
            frame.dispose();
        }
        if (e.getSource() == logout){
            new CoverPage();
            frame.dispose();
        }
    }
}
