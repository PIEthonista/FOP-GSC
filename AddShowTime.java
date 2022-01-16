import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import feats.*;

public class AddShowTime implements ActionListener{

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Staff: LOGGED IN");
    JLabel label = new JLabel();
    JLabel ttl = new JLabel("Add Showtimes");
    JLabel Datelabel = new JLabel("Date");
    JLabel Timelabel = new JLabel("Time");
    JLabel HallNolabel = new JLabel("Hall No");
    JLabel MaxHallCcapacitylabel = new JLabel("Max Hall Capacity");
    JTextField  DateField = new JTextField();
    JTextField TimeField = new JTextField();
    JTextField  HallNoField= new JTextField();
    JTextField MaxHallCapacityField = new JTextField();
    JButton done= new JButton("Done");
    JButton AddCast = new JButton("Add Showtimes");

    public AddShowTime(){

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        ttl.setBounds(223, 120, 300, 50);
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.lgray);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setVerticalAlignment(JLabel.BOTTOM);
        ttl.setHorizontalAlignment(JLabel.RIGHT);

        Datelabel.setBounds(100, 200, 200, 30);
        Datelabel.setBackground(design.dgray);
        Datelabel.setOpaque(true);
        Datelabel.setFont(design.sui20);
        Datelabel.setForeground(design.lgray);
        Datelabel.setHorizontalAlignment(JLabel.RIGHT);

        Timelabel.setBounds(100, 300, 200, 30);
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

        MaxHallCcapacitylabel.setBounds(100, 500, 200, 30);
        MaxHallCcapacitylabel.setBackground(design.dgray);
        MaxHallCcapacitylabel.setOpaque(true);
        MaxHallCcapacitylabel.setFont(design.sui20);
        MaxHallCcapacitylabel.setForeground(design.lgray);
        MaxHallCcapacitylabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        DateField.setBounds(325, 200, 750, 30);
        DateField.setFont(design.ss20i);
        DateField.setForeground(design.mgray);
        DateField.setBackground(design.lgray);
        DateField.setText("YYYY-MM-DD");

        TimeField.setBounds(325, 300, 750, 30);
        TimeField.setFont(design.ss20i);
        TimeField.setForeground(design.mgray);
        TimeField.setBackground(design.lgray);
        TimeField.setText("hh:mm");

        HallNoField.setBounds(325, 400, 750, 30);
        HallNoField.setFont(design.ss20i);
        HallNoField.setForeground(design.mgray);
        HallNoField.setBackground(design.lgray);
        HallNoField.setText("01 to 16");

        MaxHallCapacityField.setBounds(325, 500, 750, 30);
        MaxHallCapacityField.setFont(design.ss20i);
        MaxHallCapacityField.setForeground(design.mgray);
        MaxHallCapacityField.setBackground(design.lgray);
        MaxHallCapacityField.setText("?/160");

        AddCast.setBounds(760,600,200,38);
        AddCast.setVerticalAlignment(JLabel.CENTER);
        AddCast.setBackground(design.yellow);
        AddCast.setFocusable(false);
        AddCast.setHorizontalAlignment(JLabel.CENTER);
        AddCast.setFont(design.ss15);
        AddCast.addActionListener(this);

        done.setBounds(1000,600,160,38);
        done.setVerticalAlignment(JLabel.CENTER);
        done.setBackground(design.mgray);
        done.setForeground(design.lgray);
        done.setFocusable(false);
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFont(design.ss15);
        done.addActionListener(this);

        label.add(done);
        label.add(AddCast);
        frame.add(ttl);
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
            String date=DateField.getText();
            String time= TimeField.getText();
            String hall=HallNoField.getText();
            String cap=MaxHallCapacityField.getText();
            if(checkDate(date)){
                if(checkTime(time)){
                    if(checkHall(hall)){
                        if(checkCapacity(cap)){
                            if(addshows(date, time, hall, cap)){
                                dbase.addDTL_all(staff.title, staff.shows);
                                new SettingMovie();
                                frame.dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a value from 0 to 160");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a value from 01 to 16");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid time according\nto the format of hh:mm");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid date according\nto the format of YYYY-MM-DD.");
            }
        }
        if(e.getSource()==AddCast){
            String date=DateField.getText();
            String time= TimeField.getText();
            String hall=HallNoField.getText();
            String cap=MaxHallCapacityField.getText();
            if(checkDate(date)){
                if(checkTime(time)){
                    if(checkHall(hall)){
                        if(checkCapacity(cap)){
                            if(addshows(date, time, hall, cap)){
                                new AddShowTime();
                                frame.dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a value from 0 to 160");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a value from 01 to 16");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid time according\nto the format of hh:mm");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid date according\nto the format of YYYY-MM-DD.");
            }
        }
    }

    public static boolean checkDate(String date){
        boolean re=false;
        // YYYY-MM-DD
        // 0123456789
        if(date.length()==10){
            if(date.charAt(4)=='-' && date.charAt(7)=='-'){
                try{
                    Integer.parseInt(date.substring(0,4));
                    if(Integer.parseInt(date.substring(5,7))<=12){
                        if(Integer.parseInt(date.substring(8))<=31){
                            re=true;
                        }
                    }
                } catch(Exception e){}
            }
        }
        return re;
    }

    public static boolean checkTime(String time){
        boolean re=false;
        // HH:MM
        // 01234
        if(time.length()==5){
            if(time.charAt(2)==':'){
                String hh=time.substring(0,2);
                String mm=time.substring(3);
                try{
                    if(Integer.parseInt(hh)<24){
                        if(Integer.parseInt(mm)<60){
                            re=true;
                        }
                    }
                } catch (Exception e){}
            }
        }
        return re;
    }

    public static boolean checkHall(String hall){
        boolean re=false;
        try{
            if(Integer.parseInt(hall)>=1 && Integer.parseInt(hall)<=16){
                re=true;
            }
        } catch(Exception e){}
        return re;
    }

    public static boolean checkCapacity(String cap){
        boolean re=false;
        try{
            if(Integer.parseInt(cap)>=0 && Integer.parseInt(cap)<=160){
                re=true;
            }
        } catch (Exception e){}
        return re;
    }

    public static boolean addshows(String date, String time, String hall, String cap){
        boolean re=false;
        try{
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(date);
            temp.add(time);
            temp.add(hall);
            temp.add(cap);
            staff.shows.add(temp);
            re=true;
        } catch(Exception e){}
        return re;
    }
}
