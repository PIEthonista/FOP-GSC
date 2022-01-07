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


    CustomerLogIn(){
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

        messageLabel.setBounds(100,600,300,25);
        messageLabel.setFont(new Font(null,Font.ITALIC,20   ));

        myButton1.setBounds(0,0,200,40);
        myButton1.setVerticalAlignment(JLabel.CENTER);
        myButton1.setBackground(new Color(220,120,0));
        myButton1.setFocusable(false);
        myButton1.setHorizontalAlignment(JLabel.CENTER);
        myButton1.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton1.addActionListener(this);

        myButton2.setBounds(220,450,300,40);
        myButton2.setVerticalAlignment(JLabel.CENTER);
        myButton2.setBackground(new Color(220,120,0));
        myButton2.setFocusable(false);
        myButton2.setHorizontalAlignment(JLabel.CENTER);
        myButton2.setFont(new Font("Arial Black",Font.BOLD,20));
        myButton2.addActionListener(this);

        label.add(myButton1);
        label.add(myButton2);
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
            ArrayList<String> arr = new ArrayList<String>();
            try{
                arr = dbase.getCustomer(username);
                if(!username.equals(arr.get(3))){
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid username!!!");
                    new CustomerLogIn();
                }else if (!password.equals(arr.get(4))) {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid password!!!");
                    new CustomerLogIn();
                }else{
                    frame.dispose();
                    new BookandCancelMovie();
                }
            } catch (Exception ex){
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid username!!!");
                new CustomerLogIn();
            }
        }


    }
}