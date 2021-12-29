/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package email2;
import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
public class Email2 {

    public static void main(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail = "gsc.customer.service.no.reply@gmail.com";
        String password = "SingleInUM";
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
    
        Message message = prepareMessage(session, myAccountEmail, recepient);
        
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Congratulations!");
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is the movie ticket as your gift. Please scan it! \nHello");
            
            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
            //File file = new File("C:\\Users\\asus\\Desktop\\qrcode.png");
            
            messageBodyPart1.attachFile("C:\\Users\\asus\\Desktop\\qrcode.png");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messageBodyPart1);
            message.setContent(multipart);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Email2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
}
    
}
