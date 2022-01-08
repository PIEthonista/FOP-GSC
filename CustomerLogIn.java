import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.ArrayList;
import feats.*;

public class CustomerLogIn implements ActionListener {
    ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
    JFrame frame = new JFrame("CUSTOMER LOG IN PAGE");
    JLabel label = new JLabel();
    JLabel userIDLabel= new JLabel("UserName: ");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JTextField userIDField= new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton myButton1 = new JButton("Back");
    JButton myButton2 = new JButton("Log in");
    JButton myButton3 = new JButton("Reset");

    CustomerLogIn(Boolean tf, int err){
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,750,750);
        label.setHorizontalAlignment(JLabel.CENTER);

        userIDLabel.setBounds(50,200,125,30);
        userIDLabel.setBackground(Color.MAGENTA);
        userIDLabel.setOpaque(true);
        userIDLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        userPasswordLabel.setBounds(50,300,125,30);
        userPasswordLabel.setBackground(Color.MAGENTA);
        userPasswordLabel.setOpaque(true);
        userPasswordLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        userIDField.setBounds(200,200,450,30);
        userIDField.setFont(new Font(null,Font.PLAIN,20));

        userPasswordField.setBounds(200,300,450,30);
        userPasswordField.setFont(new Font(null,Font.PLAIN,20));

        if(!tf){   // true=no error, 1==pswd 2==username
            if(err==1){
                messageLabel.setBounds(200,270,300,25);
                messageLabel.setFont(new Font(null,Font.ITALIC,20));
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Wrong Password.");
            } else if (err==2){
                messageLabel.setBounds(200,170,300,25);
                messageLabel.setFont(new Font(null,Font.ITALIC,20));
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid Username.");
            }
        }

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(255, 245, 6));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(150,450,200,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(255, 245, 6));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        myButton3.setBounds(450,450,200,40);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(new Color(255, 245, 6));
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(new Font("Arial Black",Font.BOLD,20));
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
        frame.setSize(750,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton1){
            frame.dispose();
            new CoverPage();
        }

        if (e.getSource() == myButton2){
            String username = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            ArrayList<String> arr;
            try{
               arr = dbase.getCustomer(username);
               if (arr.size()==0){
                   frame.dispose();
                   new CustomerLogIn(false, 2);
               } else if (!password.equals(arr.get(4))) {
                   frame.dispose();
                   new CustomerLogIn(false, 1);
                }else{
                    frame.dispose();
                    cust c1 = new cust(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5));
                    new BookandCancelMovie();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}