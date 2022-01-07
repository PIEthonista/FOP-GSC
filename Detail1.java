import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class Detail1 implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
    JFrame frame = new JFrame("Detail of the movie");
    JLabel label1 = new JLabel();
    JButton myButton1 = new JButton("Back");
    JButton myButton2 =new JButton("Next");


    Detail1(){

        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 750, 750);
        label1.setHorizontalAlignment(JLabel.CENTER);

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220,120,0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(250,650,200,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(220,120,0));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        label1.add(myButton1);
        label1.add(myButton2);
        frame.add(label1);
        frame.setIconImage(icon.getImage());
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==myButton1){
            frame.dispose();
            new BookMovie();
        }
        if (e.getSource()==myButton2){
            frame.dispose();
            new seat1();
        }
    }
}
