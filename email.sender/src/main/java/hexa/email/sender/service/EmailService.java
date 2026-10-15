package hexa.email.sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailServiceInterface {
    @Autowired
    JavaMailSender mailSender;
    @Value( "${spring.mail.username}" )
    private String emailFrom;
     
    public void sendEmail(String emailTo, String subject, String body) {
        // SimpleMailMessage message = new SimpleMailMessage();

        // message.setFrom(this.email);
        // message.setTo(emailTo);
        // message.setText(body);
        // message.setSubject(subject);

        // this.mailSender.send(message);

        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            mailMessage.setSubject(subject, "UTF-8");

            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            helper.setFrom(emailFrom);
            helper.setTo(emailTo);
            helper.setText(body, true);

            mailSender.send(mailMessage);

            String log = String.format("Email sent to %s, subject was '%s'.", emailTo, subject);
            System.out.print(log);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
