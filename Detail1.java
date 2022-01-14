import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;

import feats.*;

public class Detail1 implements ActionListener {

    ImageIcon icon = new ImageIcon(FP.getPath("movie_list.png"));
    JFrame frame = new JFrame("LOGGED IN");
    JLabel label1 = new JLabel();
    ArrayList<ArrayList<String>> arr;
    JLabel pgnum=new JLabel(),l6,l7,l8,l9,l10;
    JLabel ln6,ln7,ln8,ln9,ln10;
    JLabel l66,l77,l88,l99,l1010;
    JLabel ttl,cst,syn;
    JTextArea rel;
    JButton prevpage = new JButton("Previous Page");
    JButton logout = new JButton("Log Out  "+cust.uname);
    JButton prev = new JButton("Previous"), next = new JButton("Next");
    JButton myButton6, myButton7, myButton8, myButton9, myButton10;


    Detail1(String title, int section2){

        arr = dbase.getDTL_front(title);
        movi.arrRESET();
        int i=0;
        int sec;
        // 1D=Spec movie ArrList,  2D=Page ArrList, 3D=Page Container
        for(sec=0; sec<arr.size()/5; sec++){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int j=0; j<5; j++){
                temp.add(arr.get(i));
                i++;
            }
            movi.arr.add(temp);
        }
        if(arr.size()%5!=0){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            for(int k=0; k<arr.size()%5; k++){
                temp.add(arr.get(i));
                i++;
            }
            movi.arr.add(temp);
        }

        label1.setBackground(new Color(50, 50, 50));
        label1.setOpaque(true);
        label1.setBounds(0, 0, 1250, 750);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(JLabel.CENTER);

        ttl = new JLabel(title);
        ttl.setBackground(design.dgray);
        ttl.setOpaque(true);
        ttl.setHorizontalAlignment(JLabel.LEFT);
        ttl.setFont(design.ss30i);
        ttl.setForeground(design.white);
        ttl.setBounds(24, 100, 1000, 60);

        ArrayList<String> d = dbase.getMovies(0, title);
        ArrayList<ArrayList<String>> ca = dbase.getCasts(title);
        String cs="";
        for(int z=0; z<6; z++){
            if(z<ca.size()){
                cs+=ca.get(z).get(0)+"   ";
            }
        }
        String sy2=d.get(3);
        String sy="";
        int jk=sy2.length();
        for(int x=0; x<(jk/130)+1; x++){
            if(sy2.length()>130){
                int pos=129;
                while(true){
                    if(sy2.charAt(pos)!=' '){
                        pos--;
                    } else {
                        break;
                    }
                }
                if(sy2.charAt(0)!=' '){
                    sy+=" "+sy2.substring(0,pos+1)+"\n";
                    sy2=sy2.substring(pos+1);
                } else {
                    sy+=" "+sy2.substring(1,pos+1)+"\n";
                    sy2=sy2.substring(pos+1);
                }
            } else {
                if(sy2.charAt(0)!=' '){
                    sy+=" "+sy2;
                } else {
                    sy+=" "+sy2.substring(1);
                }
            }
        }

        rel = new JTextArea("Released : "+getDate(d.get(2))+" "+d.get(2).substring(0,4)+"\nFeaturing: "+cs+"\n\n"+sy);
        rel.setBackground(design.dgray);
        rel.setOpaque(true);
        rel.setFocusable(false);
        //rel.setHorizontalAlignment(JLabel.LEFT);
        //rel.setVerticalAlignment(JLabel.TOP);
        rel.setFont(design.ss15);
        rel.setForeground(design.lgray);
        rel.setBounds(30, 165, 1000, 140);

        pgnum.setBounds(130,320,990,30);
        pgnum.setBackground(design.dgray);
        pgnum.setOpaque(true);
        pgnum.setHorizontalAlignment(JLabel.CENTER);
        pgnum.setFont(design.ss13);
        pgnum.setForeground(design.mgray);
        pgnum.setText("Page "+(movi.section2+1)+" / "+movi.arr.size());

        prevpage.setBounds(675,33,200,40);
        prevpage.setVerticalAlignment(JLabel.CENTER);
        prevpage.setBackground(design.dgray);
        prevpage.setForeground(design.lgray);
        prevpage.setFocusable(false);
        prevpage.setHorizontalAlignment(JLabel.CENTER);
        prevpage.setFont(design.ss15);    //yx
        prevpage.addActionListener(this);

        logout.setBounds(875, 33, 280, 40);    //yx
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setBackground(design.dgray);
        logout.setForeground(design.lgray);
        logout.setFocusable(false);
        logout.setHorizontalAlignment(JLabel.RIGHT);
        logout.setFont(design.ss15);    //yx
        logout.addActionListener(this);

        prev.setBounds(24,310,100,38);
        prev.setVerticalAlignment(JLabel.CENTER);
        prev.setBackground(design.yellow);
        prev.setForeground(design.dgray);
        prev.setFocusable(false);
        prev.setHorizontalAlignment(JLabel.CENTER);
        prev.setFont(design.sui15);    //yx
        prev.addActionListener(this);

        next.setBounds(1126,310,100,38);
        next.setVerticalAlignment(JLabel.CENTER);
        next.setBackground(design.yellow);
        next.setForeground(design.dgray);
        next.setFocusable(false);
        next.setHorizontalAlignment(JLabel.CENTER);
        next.setFont(design.sui15);    //yx
        next.addActionListener(this);

        int y=20;
        int y1=5; //10
        int y2=15;
        int c=0;
        try{
            c=movi.arr.get(movi.section2).size();
        }catch(Exception e){
            c=0;
        }

        if(1<=c){
            myButton6 = new JButton("Book");
            myButton6.setBounds(1150,350+y,70,38);
            myButton6.setVerticalAlignment(JLabel.CENTER);
            myButton6.setBackground(design.yellow);
            myButton6.setForeground(design.dgray);
            myButton6.setFocusable(false);
            myButton6.setHorizontalAlignment(JLabel.CENTER);
            myButton6.setFont(design.sui15);    //yx
            myButton6.addActionListener(this);
            if((Integer.parseInt(movi.arr.get(movi.section2).get(0).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(0).get(1),movi.arr.get(movi.section2).get(0).get(2),movi.arr.get(movi.section2).get(0).get(3),movi.arr.get(movi.section2).get(0).get(4)))!=0){
                label1.add(myButton6);
            }
            ln6 = new JLabel();
            ln6.setBounds(25, 350+y1,1200, 1);
            ln6.setOpaque(true);
            ln6.setBackground(design.mgray);
            frame.add(ln6);
            //
            l6 = new JLabel(getDate(movi.arr.get(movi.section2).get(0).get(2)));
            l6.setBounds(40, 350+y2, 200, 38);
            l6.setOpaque(true);
            l6.setBackground(design.dgray);
            l6.setForeground(design.lgray);
            l6.setFont(design.ss15);
            frame.add(l6);   //  3+3=6                                |
            l66 = new JLabel("Time: "+movi.arr.get(movi.section2).get(0).get(3)+"                                Hall "+movi.arr.get(movi.section2).get(0).get(4)+"                                Available Seats: "+(Integer.parseInt(movi.arr.get(movi.section2).get(0).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(0).get(1),movi.arr.get(movi.section2).get(0).get(2),movi.arr.get(movi.section2).get(0).get(3),movi.arr.get(movi.section2).get(0).get(4))));
            l66.setBounds(400, 350+2+y2, 650, 38);
            l66.setOpaque(true);
            l66.setBackground(design.dgray);
            l66.setForeground(design.lgray);
            l66.setFont(design.ss15);
            frame.add(l66);
        }
        if(2<=c){
            myButton7 = new JButton("Book");
            myButton7.setBounds(1150,413+y,70,38);
            myButton7.setVerticalAlignment(JLabel.CENTER);
            myButton7.setBackground(design.yellow);
            myButton7.setForeground(design.dgray);
            myButton7.setFocusable(false);
            myButton7.setHorizontalAlignment(JLabel.CENTER);
            myButton7.setFont(design.sui15);    //yx
            myButton7.addActionListener(this);
            if((Integer.parseInt(movi.arr.get(movi.section2).get(1).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(1).get(1),movi.arr.get(movi.section2).get(1).get(2),movi.arr.get(movi.section2).get(1).get(3),movi.arr.get(movi.section2).get(1).get(4)))!=0){
                label1.add(myButton7);
            }
            ln7 = new JLabel();
            ln7.setBounds(25, 413+y1,1200, 1);
            ln7.setOpaque(true);
            ln7.setBackground(design.mgray);
            frame.add(ln7);
            //
            l7 = new JLabel(getDate(movi.arr.get(movi.section2).get(1).get(2)));
            l7.setBounds(40, 413+y2, 200, 38);
            l7.setOpaque(true);
            l7.setBackground(design.dgray);
            l7.setForeground(design.lgray);
            l7.setFont(design.ss15);
            frame.add(l7);
            l77 = new JLabel("Time: "+movi.arr.get(movi.section2).get(1).get(3)+"                                Hall "+movi.arr.get(movi.section2).get(1).get(4)+"                                Available Seats: "+(Integer.parseInt(movi.arr.get(movi.section2).get(1).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(1).get(1),movi.arr.get(movi.section2).get(1).get(2),movi.arr.get(movi.section2).get(1).get(3),movi.arr.get(movi.section2).get(1).get(4))));
            l77.setBounds(400, 413+2+y2, 650, 38);
            l77.setOpaque(true);
            l77.setBackground(design.dgray);
            l77.setForeground(design.lgray);
            l77.setFont(design.ss15);
            frame.add(l77);
        }
        if(3<=c){
            myButton8 = new JButton("Book");
            myButton8.setBounds(1150,475+y,70,38);
            myButton8.setVerticalAlignment(JLabel.CENTER);
            myButton8.setBackground(design.yellow);
            myButton8.setForeground(design.dgray);
            myButton8.setFocusable(false);
            myButton8.setHorizontalAlignment(JLabel.CENTER);
            myButton8.setFont(design.sui15);    //yx
            myButton8.addActionListener(this);
            if((Integer.parseInt(movi.arr.get(movi.section2).get(2).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(2).get(1),movi.arr.get(movi.section2).get(2).get(2),movi.arr.get(movi.section2).get(2).get(3),movi.arr.get(movi.section2).get(2).get(4)))!=0){
                label1.add(myButton8);
            }
            ln8 = new JLabel();
            ln8.setBounds(25, 475+y1,1200, 1);
            ln8.setOpaque(true);
            ln8.setBackground(design.mgray);
            frame.add(ln8);
            //
            l8 = new JLabel(getDate(movi.arr.get(movi.section2).get(2).get(2)));
            l8.setBounds(40, 475+y2, 200, 38);
            l8.setOpaque(true);
            l8.setBackground(design.dgray);
            l8.setForeground(design.lgray);
            l8.setFont(design.ss15);
            frame.add(l8);
            l88 = new JLabel("Time: "+movi.arr.get(movi.section2).get(2).get(3)+"                                Hall "+movi.arr.get(movi.section2).get(2).get(4)+"                                Available Seats: "+(Integer.parseInt(movi.arr.get(movi.section2).get(2).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(2).get(1),movi.arr.get(movi.section2).get(2).get(2),movi.arr.get(movi.section2).get(2).get(3),movi.arr.get(movi.section2).get(2).get(4))));
            l88.setBounds(400, 475+2+y2, 650, 38);
            l88.setOpaque(true);
            l88.setBackground(design.dgray);
            l88.setForeground(design.lgray);
            l88.setFont(design.ss15);
            frame.add(l88);
        }
        if(4<=c){
            myButton9 = new JButton("Book");
            myButton9.setBounds(1150,538+y,70,38);
            myButton9.setVerticalAlignment(JLabel.CENTER);
            myButton9.setBackground(design.yellow);
            myButton9.setForeground(design.dgray);
            myButton9.setFocusable(false);
            myButton9.setHorizontalAlignment(JLabel.CENTER);
            myButton9.setFont(design.sui15);    //yx
            myButton9.addActionListener(this);
            if((Integer.parseInt(movi.arr.get(movi.section2).get(3).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(3).get(1),movi.arr.get(movi.section2).get(3).get(2),movi.arr.get(movi.section2).get(3).get(3),movi.arr.get(movi.section2).get(3).get(4)))!=0){
                label1.add(myButton9);
            }
            ln9 = new JLabel();
            ln9.setBounds(25, 538+y1,1200, 1);
            ln9.setOpaque(true);
            ln9.setBackground(design.mgray);
            frame.add(ln9);
            //
            l9 = new JLabel(getDate(movi.arr.get(movi.section2).get(3).get(2)));
            l9.setBounds(40, 538+y2, 200, 38);
            l9.setOpaque(true);
            l9.setBackground(design.dgray);
            l9.setForeground(design.lgray);
            l9.setFont(design.ss15);
            frame.add(l9);
            l99 = new JLabel("Time: "+movi.arr.get(movi.section2).get(3).get(3)+"                                Hall "+movi.arr.get(movi.section2).get(3).get(4)+"                                Available Seats: "+(Integer.parseInt(movi.arr.get(movi.section2).get(3).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(3).get(1),movi.arr.get(movi.section2).get(3).get(2),movi.arr.get(movi.section2).get(3).get(3),movi.arr.get(movi.section2).get(3).get(4))));
            l99.setBounds(400, 538+2+y2, 650, 38);
            l99.setOpaque(true);
            l99.setBackground(design.dgray);
            l99.setForeground(design.lgray);
            l99.setFont(design.ss15);
            frame.add(l99);
        }
        if(5<=c){
            myButton10 = new JButton("Book");
            myButton10.setBounds(1150,600+y,70,38);
            myButton10.setVerticalAlignment(JLabel.CENTER);
            myButton10.setBackground(design.yellow);
            myButton10.setForeground(design.dgray);
            myButton10.setFocusable(false);
            myButton10.setHorizontalAlignment(JLabel.CENTER);
            myButton10.setFont(design.sui15);    //yx
            myButton10.addActionListener(this);
            if((Integer.parseInt(movi.arr.get(movi.section2).get(4).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(4).get(1),movi.arr.get(movi.section2).get(4).get(2),movi.arr.get(movi.section2).get(4).get(3),movi.arr.get(movi.section2).get(4).get(4)))!=0){
                label1.add(myButton10);
            }
            ln10 = new JLabel();
            ln10.setBounds(25, 600+y1,1200, 1);
            ln10.setOpaque(true);
            ln10.setBackground(design.mgray);
            frame.add(ln10);
            //
            l10 = new JLabel(getDate(movi.arr.get(movi.section2).get(4).get(2)));
            l10.setBounds(40, 600+y2, 200, 38);
            l10.setOpaque(true);
            l10.setBackground(design.dgray);
            l10.setForeground(design.lgray);
            l10.setFont(design.ss15);
            frame.add(l10);
            l1010 = new JLabel("Time: "+movi.arr.get(movi.section2).get(4).get(3)+"                                Hall "+movi.arr.get(movi.section2).get(4).get(4)+"                                Available Seats: "+(Integer.parseInt(movi.arr.get(movi.section2).get(4).get(5))-dbase.getSpecDTL_hallcap(movi.arr.get(movi.section2).get(4).get(1),movi.arr.get(movi.section2).get(4).get(2),movi.arr.get(movi.section2).get(4).get(3),movi.arr.get(movi.section2).get(4).get(4))));
            l1010.setBounds(400, 600+2+y2, 650, 38);
            l1010.setOpaque(true);
            l1010.setBackground(design.dgray);
            l1010.setForeground(design.lgray);
            l1010.setFont(design.ss15);
            frame.add(l1010);
        }


        label1.add(prevpage);
        label1.add(logout);
        if(movi.section2!=0){
            label1.add(prev);
        }
        if(movi.section2!=movi.arr.size()-1){
            label1.add(next);
        }
        frame.add(pgnum);
        frame.add(ttl);
        frame.add(rel);
        /*
        frame.add(cst);
        frame.add(syn);
         */
        frame.add(label1);
        frame.setIconImage(icon.getImage());
        frame.setSize(1250, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static String getDate(String d){
        String re="";
        String [] m = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        re += d.substring(8)+" "+m[Integer.parseInt(d.substring(5,7))-1];
        return re;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==prevpage){
            movi.section2=0;
            new BookMovie(movi.section);
            frame.dispose();
        }
        if (e.getSource()==prev){
            if(movi.section2==0){
                new Detail1(movi.arr.get(0).get(0).get(1),0);
                frame.dispose();
            } else {
                movi.section2--;
                new Detail1(movi.arr.get(0).get(0).get(1),movi.section2);
                frame.dispose();
            }
        }
        if (e.getSource()==next){
            if(movi.section2==movi.arr.size()-1){
                new Detail1(movi.arr.get(0).get(0).get(1),movi.section2);
                frame.dispose();
            } else {
                movi.section2++;
                new Detail1(movi.arr.get(0).get(0).get(1),movi.section2);
                frame.dispose();
            }
        }

        if (e.getSource()==logout){
            cust.RESET();
            movi.section=0;
            movi.section2=0;
            new CoverPage();
            frame.dispose();
        }

        // book
        if (e.getSource()==myButton6){
            new seat1(movi.arr.get(movi.section2).get(0).get(1),movi.arr.get(movi.section2).get(0).get(2),movi.arr.get(movi.section2).get(0).get(3),movi.arr.get(movi.section2).get(0).get(4));
            frame.dispose();
        }
        if (e.getSource()==myButton7){
            new seat1(movi.arr.get(movi.section2).get(1).get(1),movi.arr.get(movi.section2).get(1).get(2),movi.arr.get(movi.section2).get(1).get(3),movi.arr.get(movi.section2).get(1).get(4));
            frame.dispose();
        }
        if (e.getSource()==myButton8){
            new seat1(movi.arr.get(movi.section2).get(2).get(1),movi.arr.get(movi.section2).get(2).get(2),movi.arr.get(movi.section2).get(2).get(3),movi.arr.get(movi.section2).get(2).get(4));
            frame.dispose();
        }
        if (e.getSource()==myButton9){
            new seat1(movi.arr.get(movi.section2).get(3).get(1),movi.arr.get(movi.section2).get(3).get(2),movi.arr.get(movi.section2).get(3).get(3),movi.arr.get(movi.section2).get(3).get(4));
            frame.dispose();
        }
        if (e.getSource()==myButton10){
            new seat1(movi.arr.get(movi.section2).get(4).get(1),movi.arr.get(movi.section2).get(4).get(2),movi.arr.get(movi.section2).get(4).get(3),movi.arr.get(movi.section2).get(4).get(4));
            frame.dispose();
        }
    }
}
