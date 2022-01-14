package feats;

import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;

import java.util.HashMap;

public class TicketImage {
    static HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
    public static void genTicket() throws Exception {
        String moviename = cust.title;
        String moviedate = cust.date;
        String movietime = cust.time;
        String hallno = cust.hallno;
        String hallseat = "";
        for(String i : cust.select){
            hallseat+=i+"  ";
        }

        BufferedImage ticket = ImageIO.read(new File(FP.getPath("t00.png")));

        Graphics g = ticket.getGraphics();
        g.setFont(new Font("Arial Black", Font.ITALIC+Font.BOLD , 50));

        g.drawString(moviename, 50,230);
        g.setFont(null);

        g.setFont(g.getFont().deriveFont(40f));
        g.setFont(new Font("Arial Black", Font.ITALIC, 40));
        g.drawString("Date: "+moviedate, 50,300);
        g.drawString("Time: "+movietime, 50,360);
        g.drawString("Hall: "+hallno, 50,420);
        String hallseatedit = hallseat.replace(";", "  ");
        String hallseatedit2 = hallseatedit.toUpperCase();
        g.drawString("Seat: "+hallseatedit2, 50,480);

        String txt="";
        if(cust.f_id.size()!=0){
            for(String i : cust.f_id){
                hm.put(Integer.parseInt(i), getFreq(Integer.parseInt(i)));
            }
            for(Integer i : hm.keySet()){
                txt+="\n    - "+getName(i)+" x"+hm.get(i);
            }
        } else {
            txt+="Not Selected";
        }
        hm.clear();

        QRcode.generateQRcode("Movie Name: "+moviename+"\nMovie Date: "+moviedate+"\nMovie Time: "+movietime+"\nHall No: "+hallno+"\nSeat No: "+hallseat+"\nFood & Beverages: "+txt);
        BufferedImage QRCode = ImageIO.read(new File("qr.png"));
        int width = QRCode.getWidth();
        int height = QRCode.getHeight();
        for(int y=0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = QRCode.getRGB(x,y);
                int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int gr = (p>>8) & 0xff;
                int b = p & 0xff;
                r = 255 - r ;
                gr = 255 - gr;
                b = 255 - b ;
                p = (255<<24) | (r<<16) | (gr<<8) | b;
                QRCode.setRGB(x, y, p);
            }
        }
        g.drawImage(QRCode, 900, 50, 500, 500, null);
        ImageIO.write(ticket, "png", new File("movieticket.png"));
    }

    public static Integer getFreq(int n){
        Integer f=0;
        Integer n1=n;
        for(int i=0; i<cust.f_id.size(); i++){
            if(cust.f_id.get(i).equals(n1.toString())){
                f++;
            }
        }
        return f;
    }

    public static String getName(Integer n){
        String re="";
        ArrayList<ArrayList<String>> arr = dbase.getAllFNB();
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).get(0).equals(n.toString())){
                re=arr.get(i).get(1);
            }
        }
        return re;
    }
}
