package hexa.email.sender.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hexa.email.sender.event.OrderEvent;
import hexa.email.sender.service.EmailServiceInterface;

@Component
public class EmailConsumer {
    @Autowired
    private EmailServiceInterface emailService;

    @KafkaListener(topics = "hexa-order")
    public void emailConsume(String json) throws JsonMappingException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        OrderEvent event = om.readValue(json, OrderEvent.class);
        String emailAddress = event.getUserEmail();
        String subject = "Book order.";
        String body = String.format(
            "<h3>Hi %s!<h3><br/><br/>Your book order has been received and is going to be process as soon as possible.<br/>Here is you order number for the follow up: %s<br/><br/>Best regards<br/>The library", 
            event.getUserFirstName(),
            event.getOrderId()
        );
        emailService.sendEmail(emailAddress, subject, body);
    }
}
