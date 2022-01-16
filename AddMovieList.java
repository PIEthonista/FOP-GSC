import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import feats.*;

public class AddMovieList implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("Staff: LOGGED IN");
    JLabel label = new JLabel();
    JLabel Titlelabel = new JLabel("Title");
    JLabel ReleaseDatelabel = new JLabel("Release Date");
    JLabel Synopsislabel = new JLabel("Synopsis");
    JLabel Adultplabel = new JLabel("Adult price");
    JLabel Childrenplabel = new JLabel("Children price");
    JLabel Studentplabel = new JLabel("Student price");
    JTextField TitleField= new JTextField();
    JTextField ReleaseDateField= new JTextField();
    JTextField SynopsisField= new JTextField();
    JTextField AdultpField= new JTextField();
    JTextField ChildrenpField = new JTextField();
    JTextField StudentpField = new JTextField();
    JButton prevpage = new JButton("Previous Page");
    JButton Next = new JButton("Next");
    JButton logout = new JButton("Log Out  "+staff.uname);
    String rel;

    public AddMovieList() {

        label.setBackground(new Color(50, 50, 50));
        label.setOpaque(true);
        label.setBounds(0, 0, 1250, 750);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        Titlelabel.setBounds(200, 150, 125, 30);
        Titlelabel.setBackground(design.dgray);
        Titlelabel.setOpaque(true);
        Titlelabel.setFont(design.sui20);
        Titlelabel.setForeground(design.lgray);
        Titlelabel.setHorizontalAlignment(JLabel.RIGHT);

        ReleaseDatelabel.setBounds(200, 225, 125, 30);
        ReleaseDatelabel.setBackground(design.dgray);
        ReleaseDatelabel.setOpaque(true);
        ReleaseDatelabel.setFont(design.sui20);
        ReleaseDatelabel.setForeground(design.lgray);
        ReleaseDatelabel.setHorizontalAlignment(JLabel.RIGHT);

        Synopsislabel.setBounds(200, 300, 125, 30);
        Synopsislabel.setBackground(design.dgray);
        Synopsislabel.setOpaque(true);
        Synopsislabel.setFont(design.sui20);
        Synopsislabel.setForeground(design.lgray);
        Synopsislabel.setHorizontalAlignment(JLabel.RIGHT);

        Adultplabel.setBounds(125, 375, 200, 30);
        Adultplabel.setBackground(design.dgray);
        Adultplabel.setOpaque(true);
        Adultplabel.setFont(design.sui20);
        Adultplabel.setForeground(design.lgray);
        Adultplabel.setHorizontalAlignment(JLabel.RIGHT);

        Childrenplabel.setBounds(125, 450, 200, 30);
        Childrenplabel.setBackground(design.dgray);
        Childrenplabel.setOpaque(true);
        Childrenplabel.setFont(design.sui20);
        Childrenplabel.setForeground(design.lgray);
        Childrenplabel.setHorizontalAlignment(JLabel.RIGHT);

        Studentplabel.setBounds(125, 525, 200, 30);
        Studentplabel.setBackground(design.dgray);
        Studentplabel.setOpaque(true);
        Studentplabel.setFont(design.sui20);
        Studentplabel.setForeground(design.lgray);
        Studentplabel.setHorizontalAlignment(JLabel.RIGHT);

        // Text Input Field
        TitleField.setBounds(375, 150, 700, 30);
        TitleField.setFont(design.ss20i);
        TitleField.setForeground(design.mgray);
        TitleField.setBackground(design.lgray);

        ReleaseDateField.setBounds(375, 225, 700, 30);
        ReleaseDateField.setFont(design.ss20i);
        ReleaseDateField.setForeground(design.mgray);
        ReleaseDateField.setBackground(design.lgray);
        ReleaseDateField.setText("YYYY-MM-DD");

        SynopsisField.setBounds(375, 300, 700, 30);
        SynopsisField.setFont(design.ss20i);
        SynopsisField.setForeground(design.mgray);
        SynopsisField.setBackground(design.lgray);

        AdultpField.setBounds(375, 375, 700, 30);
        AdultpField.setFont(design.ss20i);
        AdultpField.setForeground(design.mgray);
        AdultpField.setBackground(design.lgray);

        ChildrenpField.setBounds(375, 450, 700, 30);
        ChildrenpField.setFont(design.ss20i);
        ChildrenpField.setForeground(design.mgray);
        ChildrenpField.setBackground(design.lgray);

        StudentpField.setBounds(375, 525, 700, 30);
        StudentpField.setFont(design.ss20i);
        StudentpField.setForeground(design.mgray);
        StudentpField.setBackground(design.lgray);

        prevpage.setBounds(670,33,200,38);
        prevpage.setVerticalAlignment(JLabel.CENTER);
        prevpage.setBackground(design.mgray);
        prevpage.setForeground(design.lgray);
        prevpage.setFocusable(false);
        prevpage.setHorizontalAlignment(JLabel.CENTER);
        prevpage.setFont(design.ss15);
        prevpage.addActionListener(this);

        logout.setBounds(870, 33, 275, 38);
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.mgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.CENTER);
        logout.setFont(design.ss15);
        logout.addActionListener(this);

        Next.setBounds(1000,600,160,38);
        Next.setVerticalAlignment(JLabel.CENTER);
        Next.setBackground(design.yellow);
        Next.setFocusable(false);
        Next.setHorizontalAlignment(JLabel.CENTER);
        Next.setFont(design.ss15);
        Next.addActionListener(this);

        label.add(prevpage);
        label.add(logout);
        label.add(Next);
        frame.add(TitleField);
        frame.add(ReleaseDateField);
        frame.add(SynopsisField);
        frame.add(AdultpField);
        frame.add(ChildrenpField);
        frame.add(StudentpField);
        frame.add(Titlelabel);
        frame.add(ReleaseDatelabel);
        frame.add(Synopsislabel);
        frame.add(Adultplabel);
        frame.add(Childrenplabel);
        frame.add(Studentplabel);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Next){
            String title=TitleField.getText();
            String reldate=ReleaseDateField.getText();
            String synopsis=SynopsisField.getText();
            String adult=AdultpField.getText();
            String children=ChildrenpField.getText();
            String student=StudentpField.getText();
            if(synopsis.length()<1001){
                if(checkDate(reldate)){
                    try{
                        int ad = Integer.parseInt(adult);
                        int ch = Integer.parseInt(children);
                        int st = Integer.parseInt(student);
                        staff.title=title;
                        dbase.addMovies(title,reldate,synopsis,ad,st,ch);
                        new Addcast();
                        frame.dispose();
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Only Integers are allowed\nfor the various price fields.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid release date\naccording to the format of\nYYYY-MM-DD.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The maximum allowed characters\nfor synopsis is 1000 characters.");
            }

        }
        if (e.getSource()==prevpage){
            staff.title=null;
            new SettingMovie();
            frame.dispose();
        }
        if (e.getSource()==logout){
            staff.RESET();
            new CoverPage();
            frame.dispose();
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
}