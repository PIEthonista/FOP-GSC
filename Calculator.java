

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    public static void main(String[] args) {

        Calculator Cal = new Calculator();
    }

    JTextField textfield;
    JFrame frame;
    JButton [] numButton = new JButton[10];
    JButton [] funcButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font(" Ink Free", Font.BOLD,30);

    double num1=0, num2=0, result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        funcButton[0] = addButton;
        funcButton[1] = subButton;
        funcButton[2] = mulButton;
        funcButton[3] = divButton;
        funcButton[4] = decButton;
        funcButton[5] = equButton;
        funcButton[6] = delButton;
        funcButton[7] = clrButton;
        funcButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funcButton[i].addActionListener(this);
            funcButton[i].setFont(myFont);
            funcButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(myFont);
            numButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.GRAY);

        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(addButton);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(subButton);
        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case '+' :
                    result = num1+num2;
                    break;
                case '-' :
                    result = num1-num2;
                    break;
                case '*' :
                    result = num1*num2;
                    break;
                case '/' :
                    result = num1/num2;
                    break;

            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == clrButton){
            textfield.setText("");
        }
        if (e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
