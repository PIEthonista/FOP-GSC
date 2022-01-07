import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class BookMovie implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
    JFrame frame = new JFrame("Book Your Movie");
    JLabel label = new JLabel();
    JButton myButton1 = new JButton("Back");
    JButton myButton2 =new JButton("Spider-man: No Way Home");
    JButton myButton3 =new JButton("");
    JButton myButton4 =new JButton("");
    JButton myButton5 =new JButton("");
    JButton myButton6 =new JButton("");

    BookMovie(){

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220,120,0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(50,100,650,50);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(234, 81, 81));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        myButton3.setBounds(50,225,650,50);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setFocusable(false);
        myButton3.setBackground(new Color(234, 81, 81));
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton3.addActionListener(this);

        myButton4.setBounds(50,350,650,50);
        myButton4.setVerticalAlignment(JLabel.CENTER);
        myButton4.setBackground(new Color(234, 81, 81));
        myButton4.setFocusable(false);
        myButton4.setHorizontalAlignment(JLabel.CENTER);
        myButton4.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton4.addActionListener(this);

        myButton5.setBounds(50,475,650,50);
        myButton5.setVerticalAlignment(JLabel.CENTER);
        myButton5.setBackground(new Color(234, 81, 81));
        myButton5.setFocusable(false);
        myButton5.setHorizontalAlignment(JLabel.CENTER);
        myButton5.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton5.addActionListener(this);

        myButton6.setBounds(50,600,650,50);
        myButton6.setVerticalAlignment(JLabel.CENTER);
        myButton6.setBackground(new Color(234, 81, 81));
        myButton6.setFocusable(false);
        myButton6.setHorizontalAlignment(JLabel.CENTER);
        myButton6.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton6.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        label.add(myButton4);
        label.add(myButton5);
        label.add(myButton6);
        frame.add(label);
        frame.setSize(750,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==myButton1){
            frame.dispose();
            new BookandCancelMovie();
        }
        if (e.getSource()==myButton2){
            frame.dispose();
            new Detail1();
        }
    }
}
