import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class CoverPage implements ActionListener {

    JFrame frame = new JFrame("GOLDEN SCREEN CINEMA");
    JLabel label = new JLabel();
    JButton myButton1 = new JButton("NEW CUSTOMER");
    JButton myButton2 = new JButton("EXISTING CUSTOMER");
    JButton myButton3 = new JButton("NEW STAFF");
    JButton myButton4 = new JButton("EXISTING STAFF");

    public CoverPage() {

        ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
        //C:\Users\RONYLAU123\IdeaProjects\RONYLAU\src\ExampleGSC\GSC.png

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 750, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        myButton1.setBounds(220, 150, 300, 40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220, 120, 0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black", Font.BOLD, 20));
        myButton1.addActionListener(this);

        myButton2.setBounds(220, 275, 300, 40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(220, 120, 0));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black", Font.BOLD, 20));
        myButton2.addActionListener(this);

        myButton3.setBounds(220, 400, 300, 40);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(new Color(220, 120, 0));
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(new Font("Arial Black", Font.BOLD, 20));
        myButton3.addActionListener(this);

        myButton4.setBounds(220, 525, 300, 40);
        myButton4.setVerticalAlignment(JLabel.CENTER);
        myButton4.setBackground(new Color(220, 120, 0));
        myButton4.setFocusable(false);
        myButton4.setHorizontalAlignment(JLabel.CENTER);
        myButton4.setFont(new Font("Arial Black", Font.BOLD, 20));
        myButton4.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        label.add(myButton4);
        frame.add(label);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==myButton1){
            frame.dispose();
            new CustomerSignIn(true);
        }
        if (e.getSource()==myButton2){
            frame.dispose();
            new CustomerLogIn(true, 0);
        }
        if (e.getSource()==myButton3){
            frame.dispose();
            new StaffSignIn();
        }
        if (e.getSource()==myButton4){
            frame.dispose();
            new StaffLogIn();
        }
    }
}
