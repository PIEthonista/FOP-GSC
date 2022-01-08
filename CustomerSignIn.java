import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import feats.*;

public class CustomerSignIn implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("GSC.png"));
    JFrame frame = new JFrame("NEW CUSTOMER CREATE ACCOUNT PAGE");
    JLabel label = new JLabel();
    JLabel nameLabel = new JLabel("Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel userNameLabel = new JLabel("Username: ");
    JLabel phoneLabel = new JLabel("Phone No:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JTextField nameLabelField= new JTextField();
    JTextField emailLabelField= new JTextField();
    JTextField userNameField= new JTextField();
    JTextField phoneLabelField= new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton myButton1 = new JButton("Back ");
    JButton myButton2 = new JButton("Create Account");
    JButton myButton3 = new JButton("Reset");


    CustomerSignIn(Boolean tf) {   // true: no error

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);

        nameLabel.setBounds(50,100,125,30);
        nameLabel.setBackground(Color.MAGENTA);
        nameLabel.setOpaque(true);
        nameLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        emailLabel.setBounds(50,200,125,30);
        emailLabel.setBackground(Color.MAGENTA);
        emailLabel.setOpaque(true);
        emailLabel.setFont(new Font("MV Boli",Font.BOLD,20));

        userNameLabel.setBounds(50,300,125,30);
        userNameLabel.setBackground(Color.MAGENTA);
        userNameLabel.setOpaque(true);
        userNameLabel.setFont(new Font("MV Boli",Font.BOLD,20));

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

        userNameField.setBounds(200,300,450,30);
        userNameField.setFont(new Font(null,Font.PLAIN,20));

        phoneLabelField.setBounds(200,400,450,30);
        phoneLabelField.setFont(new Font(null,Font.PLAIN,20));

        userPasswordField.setBounds(200,500,450,30);
        userPasswordField.setFont(new Font(null,Font.PLAIN,20));

        //error label
        if(!tf){
            messageLabel.setBounds(200,270,300,25);
            messageLabel.setFont(new Font(null,Font.ITALIC,20   ));
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Sorry, Username already taken.");
        }

        //default color 220 120 0
        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(255, 245, 6));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(150,625,200,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(255, 245, 6));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,15));
        myButton2.addActionListener(this);

        myButton3.setBounds(400,625,200,40);
        myButton3.setVerticalAlignment(JLabel.CENTER);
        myButton3.setBackground(new Color(255, 245, 6));
        myButton3.setFocusable(false);
        myButton3.setHorizontalAlignment(JLabel.CENTER);
        myButton3.setFont(new Font("Arial Black",Font.BOLD,15));
        myButton3.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
        label.add(myButton3);
        frame.add(nameLabelField);
        frame.add(emailLabelField);
        frame.add(userNameField);
        frame.add(phoneLabelField);
        frame.add(userPasswordField);
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(userNameLabel);
        frame.add(phoneLabel);
        frame.add(userPasswordLabel);
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
        if (e.getSource()==myButton1){
            frame.dispose();
            new CoverPage();
        }
        if (e.getSource()==myButton2) {
            String name = nameLabelField.getText();
            String email = emailLabelField.getText();
            String userName = userNameField.getText();
            String phone = phoneLabelField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            try {
                int status = dbase.addCustomer(name, email, userName, password, phone);
                if(status==0){
                    frame.dispose();
                    new CustomerSignIn(false);
                } else {
                    frame.dispose();
                    new CustomerLogIn(true, 0);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //frame.dispose();
            //new CustomerLogIn();

        }
        if (e.getSource()==myButton3){
            nameLabelField.setText("");
            emailLabelField.setText("");
            userNameField.setText("");
            phoneLabelField.setText("");
            userPasswordField.setText("");
        }
    }
}
