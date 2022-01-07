import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class StaffSignIn implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
    JFrame frame = new JFrame("NEW CUSTOMER CREATE ACCOUNT PAGE");
    JLabel label = new JLabel();
    JLabel nameLabel = new JLabel("Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel staffIDLabel = new JLabel("StaffID: ");
    JLabel phoneLabel = new JLabel("Phone No:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JTextField nameLabelField= new JTextField();
    JTextField emailLabelField= new JTextField();
    JTextField staffIDField= new JTextField();
    JTextField phoneLabelField= new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton myButton1 = new JButton("Back ");
    JButton myButton2 = new JButton("Create Account");

    StaffSignIn() {

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,750,750);

        nameLabel.setBounds(50,100,125,30);
        nameLabel.setBackground(Color.MAGENTA);
        nameLabel.setOpaque(true);
        nameLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        emailLabel.setBounds(50,200,125,30);
        emailLabel.setBackground(Color.MAGENTA);
        emailLabel.setOpaque(true);
        emailLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        staffIDLabel.setBounds(50,300,125,30);
        staffIDLabel.setBackground(Color.MAGENTA);
        staffIDLabel.setOpaque(true);
        staffIDLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        phoneLabel.setBounds(50,400,125,30);
        phoneLabel.setBackground(Color.MAGENTA);
        phoneLabel.setOpaque(true);
        phoneLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        userPasswordLabel.setBounds(50,500,125,30);
        userPasswordLabel.setBackground(Color.MAGENTA);
        userPasswordLabel.setOpaque(true);
        userPasswordLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        nameLabelField.setBounds(200,100,450,30);
        nameLabelField.setFont(new Font(null,Font.PLAIN,20));

        emailLabelField.setBounds(200,200,450,30);
        emailLabelField.setFont(new Font(null,Font.PLAIN,20));

        staffIDField.setBounds(200,300,450,30);
        staffIDField.setFont(new Font(null,Font.PLAIN,20));

        phoneLabelField.setBounds(200,400,450,30);
        phoneLabelField.setFont(new Font(null,Font.PLAIN,20));

        userPasswordField.setBounds(200,500,450,30);
        userPasswordField.setFont(new Font(null,Font.PLAIN,20));

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220,120,0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(220,625,300,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(220,120,0));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        frame.add(nameLabelField);
        frame.add(emailLabelField);
        frame.add(staffIDField);
        frame.add(phoneLabelField);
        frame.add(userPasswordField);
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(staffIDLabel);
        frame.add(phoneLabel);
        frame.add(userPasswordLabel);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setIconImage(icon.getImage());
        frame.add(label);
        frame.setSize(750,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== myButton1){
            frame.dispose();
            new CoverPage();
        }
        if (e.getSource()==myButton2){
            frame.dispose();
            new StaffLogIn();
        }
    }
}
