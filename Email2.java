import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.internet.AddressException;
public class Email2 {

    public static void sendMail(String recepient, String subject, String text) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String EmailAcc = "gsc.customer.service.no.reply@gmail.com";
        String Pswd = "SingleInUM";
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EmailAcc, Pswd);
            }
        });
    
        Message message = prepareMessage(session, EmailAcc, recepient, subject, text);
        try{
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (Exception e){
            System.out.println("ERROR: Message not sent!");
            e.printStackTrace();
        }

    }

    //method called in send mail
    private static Message prepareMessage(Session session,
                                          String email,
                                          String recepient,
                                          String subject,
                                          String text){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);   //subject here
            message.setText(text);         //text here
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Email2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
}
    
}
