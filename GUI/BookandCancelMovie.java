package ExampleGSC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookandCancelMovie implements ActionListener {

    ImageIcon icon = new ImageIcon("C:\\Users\\RONYLAU123\\IdeaProjects\\RONYLAU\\src\\ExampleGSC\\GSC.png");
    JFrame frame = new JFrame("BOOK THE TICKET ");
    JLabel label = new JLabel();
    JButton myButton1 = new JButton("Back");
    JButton myButton2 = new JButton("Book the Movie");
    JButton myButton3 = new JButton("Cancel Booking");

    BookandCancelMovie() {
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 750, 750);
        label.setHorizontalAlignment(JLabel.CENTER);

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220,120,0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(220,200,300,60);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(220,120,0));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        myButton3.setBounds(220,400,300,60);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(new Color(220,120,0));
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton3.addActionListener(this);

        frame.add(myButton1);
        frame.add(myButton2);
        frame.add(myButton3);
        frame.setIconImage(icon.getImage());
        frame.add(label);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== myButton1){
            frame.dispose();
            new CustomerLogIn();
        }
        if (e.getSource()==myButton2){
            frame.dispose();
            new BookMovie();
        }
        if (e.getSource()==myButton3){
            frame.dispose();
            new CancelMovie();
        }
    }
}