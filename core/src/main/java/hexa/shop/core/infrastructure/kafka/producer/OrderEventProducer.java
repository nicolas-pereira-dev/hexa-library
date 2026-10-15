package hexa.shop.core.infrastructure.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import hexa.shop.core.infrastructure.kafka.event.OrderEvent;

@Component
public class OrderEventProducer {
    private static final String TOPIC = "hexa-order";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderEvent(OrderEvent event) {
        kafkaTemplate.send(TOPIC, event.getOrderId().toString(), event.toJSON());
    }
}