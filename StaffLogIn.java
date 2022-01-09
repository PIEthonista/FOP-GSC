import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class StaffLogIn implements ActionListener {
    ImageIcon icon = new ImageIcon(FP.getPath("cust_signup.png"));
    JFrame frame = new JFrame("Staff LOGIN");
    JLabel label = new JLabel();
    JLabel userIDLabel= new JLabel("Staff ID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JTextField userIDField= new JTextField();
    JLabel messageLabel = new JLabel();
    JPasswordField userPasswordField = new JPasswordField();
    JButton myButton1 = new JButton("Previous Page");
    JButton myButton2 = new JButton("Log In");
    JButton myButton3 = new JButton("Clear");


    StaffLogIn(Boolean tf, int err){
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        int x=10;
        int y=30;

        userIDLabel.setBounds(550-x,300,125,30);
        userIDLabel.setBackground(design.dgray);
        userIDLabel.setOpaque(true);
        userIDLabel.setFont(design.sui20);
        userIDLabel.setForeground(design.lgray);
        userIDLabel.setHorizontalAlignment(JLabel.RIGHT);

        userPasswordLabel.setBounds(550-x,375,125,30);
        userPasswordLabel.setBackground(design.dgray);
        userPasswordLabel.setOpaque(true);
        userPasswordLabel.setFont(design.sui20);
        userPasswordLabel.setForeground(design.lgray);
        userPasswordLabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        userIDField.setBounds(700-x,300,450,30);
        userIDField.setFont(design.ss20i);
        userIDField.setForeground(design.mgray);
        userIDField.setBackground(design.lgray);

        userPasswordField.setBounds(700-x,375,450,30);
        userPasswordField.setFont(design.ss20i);
        userPasswordField.setForeground(design.mgray);
        userPasswordField.setBackground(design.lgray);

        if(!tf){   // true=no error, 1==pswd 2==username
            if(err==1){
                messageLabel.setBounds(703-x,375-25,300,25);
                messageLabel.setFont(design.erri);
                messageLabel.setForeground(design.lred);
                messageLabel.setText("Wrong Password.");
            } else if (err==2){
                messageLabel.setBounds(703-x,300-25,300,25);
                messageLabel.setFont(design.erri);
                messageLabel.setForeground(design.lred);
                messageLabel.setText("Invalid Staff ID.");
            }
        }

        //default color 220 120 0
        myButton1.setBounds(567,545,160,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(design.mgray);
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(design.ss15);
        myButton1.addActionListener(this);

        myButton2.setBounds(800,545,160,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(design.yellow);
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(design.ss15);
        myButton2.addActionListener(this);

        myButton3.setBounds(980,545,160,40);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(design.mgray);
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(design.ss15);
        myButton3.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        frame.add(userIDField);
        frame.add(userPasswordLabel);
        frame.add(userPasswordField);
        frame.add(userIDLabel);
        frame.add(messageLabel);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.add(label);
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton1){
            new CoverPage();
            frame.dispose();
        }

        if (e.getSource() == myButton2){
            String username = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            ArrayList<String> arr;
            try{
                arr = dbase.getStaff(username);
                if (arr.size()==0){
                    new StaffLogIn(false, 2);
                    frame.dispose();
                } else if (!password.equals(arr.get(4))) {
                    new StaffLogIn(false, 1);
                    frame.dispose();
                }else{
                    staff s1 = new staff(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5));
                    new SettingMovie();
                    frame.dispose();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource()==myButton3){
            userIDField.setText("");
            userPasswordField.setText("");
        }
    }
}
