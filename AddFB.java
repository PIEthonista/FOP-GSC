import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class AddFB implements ActionListener{
    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Staff: LOGGED IN");
    JLabel label = new JLabel();
    JLabel ttl = new JLabel("Add F&B");
    JLabel fbnamelabel = new JLabel("F&B Name");
    JLabel desclabel = new JLabel("Description");
    JLabel pricelabel = new JLabel("Unit Price");
    JTextField fbnameField = new JTextField();
    JTextField descField = new JTextField();
    JTextField priceField = new JTextField();
    JButton AddFB = new JButton("Add F&B");
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+staff.uname);

    AddFB(){
        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        ttl.setBounds(223, 230, 300, 50);
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.lgray);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setVerticalAlignment(JLabel.TOP);
        ttl.setHorizontalAlignment(JLabel.RIGHT);

        prevpage.setBounds(675,28,200,40);
        prevpage.setVerticalAlignment(JLabel.CENTER);
        prevpage.setBackground(design.dgray);
        prevpage.setForeground(design.lgray);
        prevpage.setFocusable(false);
        prevpage.setHorizontalAlignment(JLabel.CENTER);
        prevpage.setFont(design.ss15);    //yx
        prevpage.addActionListener(this);

        logout.setBounds(875, 28, 280, 40);    //yx
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);    //yx
        logout.addActionListener(this);

        fbnamelabel.setBounds(125, 300, 200, 30);
        fbnamelabel.setBackground(design.dgray);
        fbnamelabel.setOpaque(true);
        fbnamelabel.setFont(design.sui20);
        fbnamelabel.setForeground(design.lgray);
        fbnamelabel.setHorizontalAlignment(JLabel.RIGHT);

        desclabel.setBounds(125, 400, 200, 30);
        desclabel.setBackground(design.dgray);
        desclabel.setOpaque(true);
        desclabel.setFont(design.sui20);
        desclabel.setForeground(design.lgray);
        desclabel.setHorizontalAlignment(JLabel.RIGHT);

        pricelabel.setBounds(125, 500, 200, 30);
        pricelabel.setBackground(design.dgray);
        pricelabel.setOpaque(true);
        pricelabel.setFont(design.sui20);
        pricelabel.setForeground(design.lgray);
        pricelabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        fbnameField.setBounds(375, 300, 700, 30);
        fbnameField.setFont(design.ss20i);
        fbnameField.setForeground(design.mgray);
        fbnameField.setBackground(design.lgray);

        descField.setBounds(375, 400, 700, 30);
        descField.setFont(design.ss20i);
        descField.setForeground(design.mgray);
        descField.setBackground(design.lgray);

        priceField.setBounds(375, 500, 700, 30);
        priceField.setFont(design.ss20i);
        priceField.setForeground(design.mgray);
        priceField.setBackground(design.lgray);

        AddFB.setBounds(1000,600,160,38);
        AddFB.setVerticalAlignment(JLabel.CENTER);
        AddFB.setBackground(design.yellow);
        AddFB.setFocusable(false);
        AddFB.setHorizontalAlignment(JLabel.CENTER);
        AddFB.setFont(design.ss15);
        AddFB.addActionListener(this);

        label.add(AddFB);
        label.add(prevpage); // prev page
        label.add(logout);
        frame.add(ttl);
        frame.add(fbnamelabel);
        frame.add(desclabel);
        frame.add(pricelabel);
        frame.add(priceField);
        frame.add(fbnameField);
        frame.add(descField);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddFB){
            String name=fbnameField.getText();
            String desc=descField.getText();
            String price=priceField.getText();
            try{
                Integer.parseInt(price);
                if(name.length()<51){
                    if(desc.length()<151){
                        dbase.addFNB(name, desc, Integer.parseInt(price));
                        new SettingMovie();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "The maximum allowed length for the\nDescription field is 150 characters.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The maximum allowed length for\nthe Name field is 50 characters.");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Please enter valid Integers\nfor the price field.");
            }
        }
        if (e.getSource()==logout){
            staff.RESET();
            staff.section=0;
            new CoverPage();
            frame.dispose();
        }
        if (e.getSource()==prevpage){
            staff.section=0;
            new SettingMovie();
            frame.dispose();
        }
    }
}
