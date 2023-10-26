import javax.mail.*; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 
import java.util.Properties; 
import java.io.*; 
import java.text.SimpleDateFormat; 
import java.util.Calendar; 
 
class Sendmail implements Serializable{ 
 private String to_email; 
 private String subject; 
 private String text; 
 private String date; 
   Sendmail(String to_email,String subject,String text){ 
     String date_time=new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime()); 
     this.to_email=to_email; 
     this.subject=subject; 
     this.text=text; 
     this.date=date_time.split("-")[0]; 
      
        final String username = "lakshithakumuduranga102@gmail.com"; 
        final String password = "iptwfjuyycqwfllt"; 
 
        Properties prop = new Properties(); 
  prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", "465"); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.socketFactory.port", "465"); 
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
         
        Session session = Session.getInstance(prop, 
                new javax.mail.Authenticator() { 
                    protected PasswordAuthentication getPasswordAuthentication() { 
                        return new PasswordAuthentication(username, password); 
                    } 
                }); 
 
        try { 
 
            Message message = new MimeMessage(session); 
            message.setFrom(new InternetAddress("lakshithakumuduranga102@gmail.com")); 
            message.setRecipients( 
                    Message.RecipientType.TO, 
                    InternetAddress.parse(to_email) 
            ); 
            message.setSubject(subject); 
            message.setText(text); 
            System.out.println("------Sending an email-----"); 
 
            Transport.send(message); 
 
            System.out.println("Sending Birthday Wishes........."); 
 
        } catch (MessagingException e) { 
            System.out.println("--------Invalid Format--------"); 
        } 
    } 
    String get_to_email() { 
     return to_email; 
    } 
    String get_subject() { 
     return subject; 
    } 
    String get_text() { 
     return text; 
    } 
    String get_date() { 
     return date; 
    } 
} 