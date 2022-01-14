import feats.FP;
import feats.cust;
import feats.movi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Summary implements ActionListener {
    ImageIcon icon = new ImageIcon(FP.getPath("cust_confirm.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label1 = new JLabel();
    JButton logout = new JButton("Log Out  "+ cust.uname);
    JButton done = new JButton("Home");
    JLabel ttl, ln3, content;
    Summary(){
        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 1250, 750);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(JLabel.CENTER);

        ttl = new JLabel("Booking Success");
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.white);
        ttl.setBounds(500, 100, 750, 60);

        int y1=5; //10
        ln3 = new JLabel();
        ln3.setBounds(500, 163+y1,500, 1);
        ln3.setOpaque(true);
        ln3.setBackground(design.mgray);
        frame.add(ln3);

        content = new JLabel("Thank you for purchasing with us!");
        content.setHorizontalAlignment(JLabel.LEFT);
        content.setVerticalAlignment(JLabel.BOTTOM);
        content.setBackground(design.dgray);
        content.setOpaque(true);
        content.setFocusable(false);
        content.setFont(design.ss23);
        content.setForeground(design.lgray);
        content.setBounds(520, 188, 600, 50);

        done.setBounds(1126,610,100,38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.yellow);
        done.setForeground(design.dgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.sui15);    //yx
        done.addActionListener(this);

        logout.setBounds(875, 33, 280, 40);    //yx
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);    //yx
        logout.addActionListener(this);

        label1.add(logout);
        label1.add(done);
        frame.add(content);
        frame.add(ttl);
        frame.add(label1);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            movi.section2=0;
            new CoverPage();
            frame.dispose();
        }
        if(e.getSource()==done){
            cust.partialRESET();
            movi.section=0;
            movi.section2=0;
            new BookandCancelMovie();
            frame.dispose();
        }
    }
}
