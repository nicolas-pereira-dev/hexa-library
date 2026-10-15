package hexa.email.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import hexa.email.sender.service.EmailServiceInterface;

@SpringBootApplication
public class Application {
	@Autowired
    EmailServiceInterface emailService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		// emailService.sendEmail("nicolas_pereira27@hotmail.com", "Kafka test", "Ceci est un test d'envoie de mail automatisé.");
	}

}
