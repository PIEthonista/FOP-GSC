import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import feats.*;

public class TheaterCapacity implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Edit Theater Capacity");
    JLabel label = new JLabel();
    JLabel hall1 = new JLabel("Hall1");
    JLabel hall2 = new JLabel("Hall2");
    JLabel hall3 = new JLabel("Hall3");
    JLabel hall4 = new JLabel("Hall4");
    JLabel hall5 = new JLabel("Hall5");
    JLabel hall6 = new JLabel("Hall6");
    JLabel hall7 = new JLabel("Hall7");
    JLabel hall8 = new JLabel("Hall8");
    JLabel hall9 = new JLabel("Hall9");
    JLabel hall10 = new JLabel("Hall10");
    JLabel hall11 = new JLabel("Hall11");
    JLabel hall12 = new JLabel("Hall12");
    JLabel hall13 = new JLabel("Hall13");
    JLabel hall14 = new JLabel("Hall14");
    JLabel hall15 = new JLabel("Hall15");
    JLabel hall16 = new JLabel("Hall16");
    JLabel l1 = new JLabel("/160");
    JLabel l2 = new JLabel("/160");
    JLabel l3 = new JLabel("/160");
    JLabel l4 = new JLabel("/160");
    JLabel l5 = new JLabel("/160");
    JLabel l6 = new JLabel("/160");
    JLabel l7 = new JLabel("/160");
    JLabel l8 = new JLabel("/160");
    JLabel l9 = new JLabel("/160");
    JLabel l10 = new JLabel("/160");
    JLabel l11 = new JLabel("/160");
    JLabel l12 = new JLabel("/160");
    JLabel l13 = new JLabel("/160");
    JLabel l14 = new JLabel("/160");
    JLabel l15 = new JLabel("/160");
    JLabel l16 = new JLabel("/160");
    JTextField hall1Field = new JTextField();
    JTextField hall2Field = new JTextField();
    JTextField hall3Field = new JTextField();
    JTextField hall4Field= new JTextField();
    JTextField hall5Field = new JTextField();
    JTextField hall6Field = new JTextField();
    JTextField hall7Field = new JTextField();
    JTextField hall8Field = new JTextField();
    JTextField hall9Field = new JTextField();
    JTextField hall10Field = new JTextField();
    JTextField hall11Field = new JTextField();
    JTextField hall12Field = new JTextField();
    JTextField hall13Field = new JTextField();
    JTextField hall14Field = new JTextField();
    JTextField hall15Field = new JTextField();
    JTextField hall16Field = new JTextField();
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+staff.uname);
    JButton Done = new JButton("Done");


    public TheaterCapacity() {

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        hall1.setBounds(50, 150, 150, 30);
        hall1.setBackground(new Color(50, 50, 50));
        hall1.setOpaque(true);
        hall1.setFont(design.sui20);
        hall1.setForeground(design.lgray);
        hall1.setHorizontalAlignment(JLabel.CENTER);

        hall2.setBounds(50, 200, 150, 30);
        hall2.setBackground(new Color(50, 50, 50));
        hall2.setOpaque(true);
        hall2.setFont(design.sui20);
        hall2.setForeground(design.lgray);
        hall2.setHorizontalAlignment(JLabel.CENTER);

        hall3.setBounds(50, 250, 150, 30);
        hall3.setBackground(new Color(50, 50, 50));
        hall3.setOpaque(true);
        hall3.setFont(design.sui20);
        hall3.setForeground(design.lgray);
        hall3.setHorizontalAlignment(JLabel.CENTER);

        hall4.setBounds(50, 300, 150, 30);
        hall4.setBackground(new Color(50, 50, 50));
        hall4.setOpaque(true);
        hall4.setFont(design.sui20);
        hall4.setForeground(design.lgray);
        hall4.setHorizontalAlignment(JLabel.CENTER);

        hall5.setBounds(50, 350, 150, 30);
        hall5.setBackground(new Color(50, 50, 50));
        hall5.setOpaque(true);
        hall5.setFont(design.sui20);
        hall5.setForeground(design.lgray);
        hall5.setHorizontalAlignment(JLabel.CENTER);

        hall6.setBounds(50, 400, 150, 30);
        hall6.setBackground(new Color(50, 50, 50));
        hall6.setOpaque(true);
        hall6.setFont(design.sui20);
        hall6.setForeground(design.lgray);
        hall6.setHorizontalAlignment(JLabel.CENTER);

        hall7.setBounds(50, 450, 150, 30);
        hall7.setBackground(new Color(50, 50, 50));
        hall7.setOpaque(true);
        hall7.setFont(design.sui20);
        hall7.setForeground(design.lgray);
        hall7.setHorizontalAlignment(JLabel.CENTER);

        hall8.setBounds(50, 500, 150, 30);
        hall8.setBackground(new Color(50, 50, 50));
        hall8.setOpaque(true);
        hall8.setFont(design.sui20);
        hall8.setForeground(design.lgray);
        hall8.setHorizontalAlignment(JLabel.CENTER);

        hall9.setBounds(600, 150, 150, 30);
        hall9.setBackground(new Color(50, 50, 50));
        hall9.setOpaque(true);
        hall9.setFont(design.sui20);
        hall9.setForeground(design.lgray);
        hall9.setHorizontalAlignment(JLabel.CENTER);

        hall10.setBounds(600, 200, 150, 30);
        hall10.setBackground(new Color(50, 50, 50));
        hall10.setOpaque(true);
        hall10.setFont(design.sui20);
        hall10.setForeground(design.lgray);
        hall10.setHorizontalAlignment(JLabel.CENTER);

        hall11.setBounds(600, 250, 150, 30);
        hall11.setBackground(new Color(50, 50, 50));
        hall11.setOpaque(true);
        hall11.setFont(design.sui20);
        hall11.setForeground(design.lgray);
        hall11.setHorizontalAlignment(JLabel.CENTER);

        hall12.setBounds(600, 300, 150, 30);
        hall12.setBackground(new Color(50, 50, 50));
        hall12.setOpaque(true);
        hall12.setFont(design.sui20);
        hall12.setForeground(design.lgray);
        hall12.setHorizontalAlignment(JLabel.CENTER);

        hall13.setBounds(600, 350, 150, 30);
        hall13.setBackground(new Color(50, 50, 50));
        hall13.setOpaque(true);
        hall13.setFont(design.sui20);
        hall13.setForeground(design.lgray);
        hall13.setHorizontalAlignment(JLabel.CENTER);

        hall14.setBounds(600, 400, 150, 30);
        hall14.setBackground(new Color(50, 50, 50));
        hall14.setOpaque(true);
        hall14.setFont(design.sui20);
        hall14.setForeground(design.lgray);
        hall14.setHorizontalAlignment(JLabel.CENTER);

        hall15.setBounds(600, 450, 150, 30);
        hall15.setBackground(new Color(50, 50, 50));
        hall15.setOpaque(true);
        hall15.setFont(design.sui20);
        hall15.setForeground(design.lgray);
        hall15.setHorizontalAlignment(JLabel.CENTER);

        hall16.setBounds(600, 500, 150, 30);
        hall16.setBackground(new Color(50, 50, 50));
        hall16.setOpaque(true);
        hall16.setFont(design.sui20);
        hall16.setForeground(design.lgray);
        hall16.setHorizontalAlignment(JLabel.CENTER);

        l1.setBounds(350, 150, 150, 30);
        l1.setBackground(new Color(50, 50, 50));
        l1.setOpaque(true);
        l1.setFont(design.sui20);
        l1.setForeground(design.lgray);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2.setBounds(350, 200, 150, 30);
        l2.setBackground(new Color(50, 50, 50));
        l2.setOpaque(true);
        l2.setFont(design.sui20);
        l2.setForeground(design.lgray);
        l2.setHorizontalAlignment(JLabel.CENTER);

        l3.setBounds(350, 250, 150, 30);
        l3.setBackground(new Color(50, 50, 50));
        l3.setOpaque(true);
        l3.setFont(design.sui20);
        l3.setForeground(design.lgray);
        l3.setHorizontalAlignment(JLabel.CENTER);

        l4.setBounds(350, 300, 150, 30);
        l4.setBackground(new Color(50, 50, 50));
        l4.setOpaque(true);
        l4.setFont(design.sui20);
        l4.setForeground(design.lgray);
        l4.setHorizontalAlignment(JLabel.CENTER);

        l5.setBounds(350, 350, 150, 30);
        l5.setBackground(new Color(50, 50, 50));
        l5.setOpaque(true);
        l5.setFont(design.sui20);
        l5.setForeground(design.lgray);
        l5.setHorizontalAlignment(JLabel.CENTER);

        l6.setBounds(350, 400, 150, 30);
        l6.setBackground(new Color(50, 50, 50));
        l6.setOpaque(true);
        l6.setFont(design.sui20);
        l6.setForeground(design.lgray);
        l6.setHorizontalAlignment(JLabel.CENTER);

        l7.setBounds(350, 450, 150, 30);
        l7.setBackground(new Color(50, 50, 50));
        l7.setOpaque(true);
        l7.setFont(design.sui20);
        l7.setForeground(design.lgray);
        l7.setHorizontalAlignment(JLabel.CENTER);

        l8.setBounds(350, 500, 150, 30);
        l8.setBackground(new Color(50, 50, 50));
        l8.setOpaque(true);
        l8.setFont(design.sui20);
        l8.setForeground(design.lgray);
        l8.setHorizontalAlignment(JLabel.CENTER);

        l9.setBounds(900, 150, 150, 30);
        l9.setBackground(new Color(50, 50, 50));
        l9.setOpaque(true);
        l9.setFont(design.sui20);
        l9.setForeground(design.lgray);
        l9.setHorizontalAlignment(JLabel.CENTER);

        l10.setBounds(900, 200, 150, 30);
        l10.setBackground(new Color(50, 50, 50));
        l10.setOpaque(true);
        l10.setFont(design.sui20);
        l10.setForeground(design.lgray);
        l10.setHorizontalAlignment(JLabel.CENTER);

        l11.setBounds(900, 250, 150, 30);
        l11.setBackground(new Color(50, 50, 50));
        l11.setOpaque(true);
        l11.setFont(design.sui20);
        l11.setForeground(design.lgray);
        l11.setHorizontalAlignment(JLabel.CENTER);

        l12.setBounds(900, 300, 150, 30);
        l12.setBackground(new Color(50, 50, 50));
        l12.setOpaque(true);
        l12.setFont(design.sui20);
        l12.setForeground(design.lgray);
        l12.setHorizontalAlignment(JLabel.CENTER);

        l13.setBounds(900, 350, 150, 30);
        l13.setBackground(new Color(50, 50, 50));
        l13.setOpaque(true);
        l13.setFont(design.sui20);
        l13.setForeground(design.lgray);
        l13.setHorizontalAlignment(JLabel.CENTER);

        l14.setBounds(900, 400, 150, 30);
        l14.setBackground(new Color(50, 50, 50));
        l14.setOpaque(true);
        l14.setFont(design.sui20);
        l14.setForeground(design.lgray);
        l14.setHorizontalAlignment(JLabel.CENTER);

        l15.setBounds(900, 450, 150, 30);
        l15.setBackground(new Color(50, 50, 50));
        l15.setOpaque(true);
        l15.setFont(design.sui20);
        l15.setForeground(design.lgray);
        l15.setHorizontalAlignment(JLabel.CENTER);

        l16.setBounds(900, 500, 150, 30);
        l16.setBackground(new Color(50, 50, 50));
        l16.setOpaque(true);
        l16.setFont(design.sui20);
        l16.setForeground(design.lgray);
        l16.setHorizontalAlignment(JLabel.CENTER);

        hall1Field.setBounds(250, 150, 100, 30);
        hall1Field.setFont(design.ss20i);
        hall1Field.setForeground(design.mgray);
        hall1Field.setBackground(design.lgray);

        hall2Field.setBounds(250, 200, 100, 30);
        hall2Field.setFont(design.ss20i);
        hall2Field.setForeground(design.mgray);
        hall2Field.setBackground(design.lgray);

        hall3Field.setBounds(250, 250, 100, 30);
        hall3Field.setFont(design.ss20i);
        hall3Field.setForeground(design.mgray);
        hall3Field.setBackground(design.lgray);

        hall4Field.setBounds(250, 300, 100, 30);
        hall4Field.setFont(design.ss20i);
        hall4Field.setForeground(design.mgray);
        hall4Field.setBackground(design.lgray);

        hall5Field.setBounds(250, 350, 100, 30);
        hall5Field.setFont(design.ss20i);
        hall5Field.setForeground(design.mgray);
        hall5Field.setBackground(design.lgray);

        hall6Field.setBounds(250, 400, 100, 30);
        hall6Field.setFont(design.ss20i);
        hall6Field.setForeground(design.mgray);
        hall6Field.setBackground(design.lgray);

        hall7Field.setBounds(250, 450, 100, 30);
        hall7Field.setFont(design.ss20i);
        hall7Field.setForeground(design.mgray);
        hall7Field.setBackground(design.lgray);

        hall8Field.setBounds(250, 500, 100, 30);
        hall8Field.setFont(design.ss20i);
        hall8Field.setForeground(design.mgray);
        hall8Field.setBackground(design.lgray);

        hall9Field.setBounds(800, 150, 100, 30);
        hall9Field.setFont(design.ss20i);
        hall9Field.setForeground(design.mgray);
        hall9Field.setBackground(design.lgray);

        hall10Field.setBounds(800, 200, 100, 30);
        hall10Field.setFont(design.ss20i);
        hall10Field.setForeground(design.mgray);
        hall10Field.setBackground(design.lgray);

        hall11Field.setBounds(800, 250, 100, 30);
        hall11Field.setFont(design.ss20i);
        hall11Field.setForeground(design.mgray);
        hall11Field.setBackground(design.lgray);

        hall12Field.setBounds(800, 300, 100, 30);
        hall12Field.setFont(design.ss20i);
        hall12Field.setForeground(design.mgray);
        hall12Field.setBackground(design.lgray);

        hall13Field.setBounds(800, 350, 100, 30);
        hall13Field.setFont(design.ss20i);
        hall13Field.setForeground(design.mgray);
        hall13Field.setBackground(design.lgray);

        hall14Field.setBounds(800, 400, 100, 30);
        hall14Field.setFont(design.ss20i);
        hall14Field.setForeground(design.mgray);
        hall14Field.setBackground(design.lgray);

        hall15Field.setBounds(800, 450, 100, 30);
        hall15Field.setFont(design.ss20i);
        hall15Field.setForeground(design.mgray);
        hall15Field.setBackground(design.lgray);

        hall16Field.setBounds(800, 500, 100, 30);
        hall16Field.setFont(design.ss20i);
        hall16Field.setForeground(design.mgray);
        hall16Field.setBackground(design.lgray);

        Done.setBounds(1000,600,160,38);
        Done.setVerticalAlignment(JLabel.CENTER);
        Done.setBackground(design.mgray);
        Done.setForeground(design.lgray);
        Done.setFocusable(false);
        Done.setHorizontalAlignment(JLabel.CENTER);
        Done.setFont(design.ss15);
        Done.addActionListener(this);

        prevpage.setBounds(675, 28, 200, 40);
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

        label.add(Done);
        label.add(logout);
        label.add(prevpage);
        frame.add(hall1);
        frame.add(hall2);
        frame.add(hall3);
        frame.add(hall4);
        frame.add(hall5);
        frame.add(hall6);
        frame.add(hall7);
        frame.add(hall8);
        frame.add(hall9);
        frame.add(hall10);
        frame.add(hall11);
        frame.add(hall12);
        frame.add(hall13);
        frame.add(hall14);
        frame.add(hall15);
        frame.add(hall16);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(l9);
        frame.add(l10);
        frame.add(l11);
        frame.add(l12);
        frame.add(l13);
        frame.add(l14);
        frame.add(l15);
        frame.add(l16);
        frame.add(hall1Field);
        frame.add(hall2Field);
        frame.add(hall3Field);
        frame.add(hall4Field);
        frame.add(hall5Field);
        frame.add(hall6Field);
        frame.add(hall7Field);
        frame.add(hall8Field);
        frame.add(hall9Field);
        frame.add(hall10Field);
        frame.add(hall11Field);
        frame.add(hall12Field);
        frame.add(hall13Field);
        frame.add(hall14Field);
        frame.add(hall15Field);
        frame.add(hall16Field);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250,750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevpage) {
            movi.section = 0;
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource() == logout) {
            cust.RESET();
            movi.section = 0;
            new CoverPage();
            frame.dispose();
        }
        if (e.getSource() == Done){
            new SettingMovie();
            frame.dispose();
        }
    }
}

