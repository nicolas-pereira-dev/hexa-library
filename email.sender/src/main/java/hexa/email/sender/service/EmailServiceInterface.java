package hexa.email.sender.service;

public interface EmailServiceInterface {
    public void sendEmail(String toEmail, String subject, String body);
}
