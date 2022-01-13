import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class AddShowTime implements ActionListener{

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Add Movie List");
    JLabel label = new JLabel();
    JLabel Datelabel = new JLabel("Date");
    JLabel Timelabel = new JLabel("Time");
    JLabel HallNolabel = new JLabel("Hall No");
    JLabel MaxHallCcapacitylabel = new JLabel("Max Hall Capacity");
    JTextField  DateField = new JTextField();
    JTextField TimeField = new JTextField();
    JTextField  HallNoField= new JTextField();
    JTextField MaxHallCapacityField = new JTextField();
    JButton done= new JButton("Done");
    JButton logout = new JButton("Log Out  "+staff.uname);

    public AddShowTime(){

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        Datelabel.setBounds(100, 150, 200, 30);
        Datelabel.setBackground(design.dgray);
        Datelabel.setOpaque(true);
        Datelabel.setFont(design.sui20);
        Datelabel.setForeground(design.lgray);
        Datelabel.setHorizontalAlignment(JLabel.RIGHT);

        Timelabel.setBounds(100, 275, 200, 30);
        Timelabel.setBackground(design.dgray);
        Timelabel.setOpaque(true);
        Timelabel.setFont(design.sui20);
        Timelabel.setForeground(design.lgray);
        Timelabel.setHorizontalAlignment(JLabel.RIGHT);

        HallNolabel.setBounds(100, 400, 200, 30);
        HallNolabel.setBackground(design.dgray);
        HallNolabel.setOpaque(true);
        HallNolabel.setFont(design.sui20);
        HallNolabel.setForeground(design.lgray);
        HallNolabel.setHorizontalAlignment(JLabel.RIGHT);

        MaxHallCcapacitylabel.setBounds(100, 525, 200, 30);
        MaxHallCcapacitylabel.setBackground(design.dgray);
        MaxHallCcapacitylabel.setOpaque(true);
        MaxHallCcapacitylabel.setFont(design.sui20);
        MaxHallCcapacitylabel.setForeground(design.lgray);
        MaxHallCcapacitylabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        DateField.setBounds(325, 150, 750, 30);
        DateField.setFont(design.ss20i);
        DateField.setForeground(design.mgray);
        DateField.setBackground(design.lgray);

        TimeField.setBounds(325, 275, 750, 30);
        TimeField.setFont(design.ss20i);
        TimeField.setForeground(design.mgray);
        TimeField.setBackground(design.lgray);

        HallNoField.setBounds(325, 400, 750, 30);
        HallNoField.setFont(design.ss20i);
        HallNoField.setForeground(design.mgray);
        HallNoField.setBackground(design.lgray);

        MaxHallCapacityField.setBounds(325, 525, 750, 30);
        MaxHallCapacityField.setFont(design.ss20i);
        MaxHallCapacityField.setForeground(design.mgray);
        MaxHallCapacityField.setBackground(design.lgray);

        done.setBounds(1000,600,160,38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.mgray);
        done.setForeground(design.lgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.ss15);
        done.addActionListener(this);

        logout.setBounds(870, 33, 280, 40);
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.mgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.CENTER);
        logout.setFont(design.ss15);
        logout.addActionListener(this);

        label.add(done);
        label.add(logout);
        frame.add(Datelabel);
        frame.add(Timelabel);
        frame.add(HallNolabel);
        frame.add(MaxHallCcapacitylabel);
        frame.add(DateField);
        frame.add(TimeField);
        frame.add(HallNoField);
        frame.add(MaxHallCapacityField);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done){
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource() == logout){
            new CoverPage();
            frame.dispose();
        }
    }
}
