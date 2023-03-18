package Gmail;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
public class GmailSender {

    public static void sendEmail(String recipient, String subject, String body) throws Exception {

        final String username = "abdoulayeaffadineahmat@gmail.com";
        final String password = "mxikradtlsxnmaav";

        // Configuration de la session de messagerie
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Création du message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(body);

        // Envoi du message
        Transport.send(message);
    }

}