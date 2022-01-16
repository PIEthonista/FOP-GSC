import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class Addcast implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Staff: LOGGED IN");
    JLabel label = new JLabel();
    JLabel ttl = new JLabel("Add Casts");
    JLabel actorNamelabel = new JLabel("Actor's Name");
    JLabel movieNamelabel = new JLabel("Movie Character");
    JTextField ActorNameField = new JTextField();
    JTextField MovieNameField = new JTextField();
    JButton AddCast = new JButton("Add Casts");
    JButton AddShowTime = new JButton("Add Showtimes");

    public Addcast(){

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        ttl.setBounds(223, 230, 300, 50);
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.lgray);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setVerticalAlignment(JLabel.TOP);
        ttl.setHorizontalAlignment(JLabel.RIGHT);

        actorNamelabel.setBounds(125, 300, 200, 30);
        actorNamelabel.setBackground(design.dgray);
        actorNamelabel.setOpaque(true);
        actorNamelabel.setFont(design.sui20);
        actorNamelabel.setForeground(design.lgray);
        actorNamelabel.setHorizontalAlignment(JLabel.RIGHT);

        movieNamelabel.setBounds(125, 400, 200, 30);
        movieNamelabel.setBackground(design.dgray);
        movieNamelabel.setOpaque(true);
        movieNamelabel.setFont(design.sui20);
        movieNamelabel.setForeground(design.lgray);
        movieNamelabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        ActorNameField.setBounds(375, 300, 700, 30);
        ActorNameField.setFont(design.ss20i);
        ActorNameField.setForeground(design.mgray);
        ActorNameField.setBackground(design.lgray);

        MovieNameField.setBounds(375, 400, 700, 30);
        MovieNameField.setFont(design.ss20i);
        MovieNameField.setForeground(design.mgray);
        MovieNameField.setBackground(design.lgray);

        AddCast.setBounds(800,600,160,38);
        AddCast.setVerticalAlignment(JLabel.CENTER);
        AddCast.setBackground(design.yellow);
        AddCast.setFocusable(false);
        AddCast.setHorizontalAlignment(JLabel.CENTER);
        AddCast.setFont(design.ss15);
        AddCast.addActionListener(this);

        AddShowTime.setBounds(1000,600,160,38);
        AddShowTime.setVerticalAlignment(JLabel.CENTER);
        AddShowTime.setBackground(design.yellow);
        AddShowTime.setFocusable(false);
        AddShowTime.setHorizontalAlignment(JLabel.CENTER);
        AddShowTime.setFont(design.ss15);
        AddShowTime.addActionListener(this);

        label.add(AddCast);
        label.add(AddShowTime);
        frame.add(ttl);
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
            String name=ActorNameField.getText();
            String ch=MovieNameField.getText();
            if(addcasts(name, ch)){
                new Addcast();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The maximum allowed length for\nboth fields are 100 characters.");
            }
        }
        if (e.getSource() == AddShowTime){
            String name=ActorNameField.getText();
            String ch=MovieNameField.getText();
            if(addcasts(name, ch)){
                if(staff.casts.size()>0){
                    dbase.addCasts(staff.title, staff.casts);
                    new AddShowTime();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please add at least ONE actor and\nthe character he/her is acting.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The maximum allowed length for\nboth fields are 100 characters.");
            }
        }
    }
    public static boolean addcasts(String name, String ch){
        boolean re=false;
        if(name.length()<101 && !name.isBlank()){
            if(ch.length()<101 && !ch.isBlank()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(name);
                temp.add(ch);
                staff.casts.add(temp);
                re=true;
            }
        }
        return re;
    }
}
