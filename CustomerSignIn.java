import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class CustomerSignIn implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("cust_signup.png"));
    JFrame frame = new JFrame("SIGN UP");
    JLabel label = new JLabel();
    JLabel nameLabel = new JLabel("Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel userNameLabel = new JLabel("Username:");
    JLabel phoneLabel = new JLabel("Phone No:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JTextField nameLabelField= new JTextField();
    JTextField emailLabelField= new JTextField();
    JTextField userNameField= new JTextField();
    JTextField phoneLabelField= new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JButton myButton1 = new JButton("Previous Page");
    JButton myButton2 = new JButton("Create Account");
    JButton myButton3 = new JButton("Clear");


    CustomerSignIn(Boolean tf) {   // true: no error
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0,0,1250,750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        int x=10;
        int y=30;

        nameLabel.setBounds(550-x,425-y-75-75-75,125,30);
        nameLabel.setBackground(design.dgray);
        nameLabel.setOpaque(true);
        nameLabel.setFont(design.sui20);
        nameLabel.setForeground(design.lgray);
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);

        emailLabel.setBounds(550-x,425-y-75-75,125,30);
        emailLabel.setBackground(design.dgray);
        emailLabel.setOpaque(true);
        emailLabel.setFont(design.sui20);
        emailLabel.setForeground(design.lgray);
        emailLabel.setHorizontalAlignment(JLabel.RIGHT);

        userNameLabel.setBounds(550-x,425-y-75,125,30);
        userNameLabel.setBackground(design.dgray);
        userNameLabel.setOpaque(true);
        userNameLabel.setFont(design.sui20);
        userNameLabel.setForeground(design.lgray);
        userNameLabel.setHorizontalAlignment(JLabel.RIGHT);

        phoneLabel.setBounds(550-x,425-y,125,30);
        phoneLabel.setBackground(design.dgray);
        phoneLabel.setOpaque(true);
        phoneLabel.setFont(design.sui20);
        phoneLabel.setForeground(design.lgray);
        phoneLabel.setHorizontalAlignment(JLabel.RIGHT);

        userPasswordLabel.setBounds(550-x,500-y,125,30);
        userPasswordLabel.setBackground(design.dgray);
        userPasswordLabel.setOpaque(true);
        userPasswordLabel.setFont(design.sui20);
        userPasswordLabel.setForeground(design.lgray);
        userPasswordLabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        nameLabelField.setBounds(700-x,425-75-75-75-y,450,30);
        nameLabelField.setFont(design.ss20i);
        nameLabelField.setForeground(design.mgray);
        nameLabelField.setBackground(design.lgray);

        emailLabelField.setBounds(700-x,425-75-75-y,450,30);
        emailLabelField.setFont(design.ss20i);
        emailLabelField.setForeground(design.mgray);
        emailLabelField.setBackground(design.lgray);

        userNameField.setBounds(700-x,425-75-y,450,30);
        userNameField.setFont(design.ss20i);
        userNameField.setForeground(design.mgray);
        userNameField.setBackground(design.lgray);

        phoneLabelField.setBounds(700-x,425-y,450,30);
        phoneLabelField.setFont(design.ss20i);
        phoneLabelField.setForeground(design.mgray);
        phoneLabelField.setBackground(design.lgray);

        userPasswordField.setBounds(700-x,500-y,450,30);
        userPasswordField.setFont(design.ss20i);
        userPasswordField.setForeground(design.mgray);
        userPasswordField.setBackground(design.lgray);

        //error label
        if(!tf){
            messageLabel.setBounds(703-x,425-75-75-y+50,300,25);
            messageLabel.setFont(design.erri);
            messageLabel.setForeground(design.lred);
            messageLabel.setText("Sorry, Username is already taken.");
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
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==myButton1){
            new CoverPage();
            frame.dispose();
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
                    new CustomerSignIn(false);
                    frame.dispose();
                } else {
                    new CustomerLogIn(true, 0);
                    frame.dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
