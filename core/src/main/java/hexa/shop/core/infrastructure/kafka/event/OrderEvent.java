package hexa.shop.core.infrastructure.kafka.event;

import java.time.LocalDate;

import hexa.shop.core.domain.model.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderEvent {
    private Long orderId;
    private String userFirstName;
    private String userEmail;
    private LocalDate orderDate;
    private OrderStatusEnum orderStatus;

    public String toJSON() {
        return "{\"orderId\":" + orderId
                + ",\"userFirstName\":" + userFirstName
                + ",\"userEmail\":" + userEmail
                + ",\"orderDate\":" + orderDate.toString()
                + ",\"orderStatus\":" + orderStatus.toString()
                + "}";
    }
}
