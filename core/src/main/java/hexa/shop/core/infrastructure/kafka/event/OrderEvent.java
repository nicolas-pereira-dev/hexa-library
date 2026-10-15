package hexa.shop.core.infrastructure.kafka.event;

import lombok.Data;

@Data
public class OrderEvent {
    private Long orderId;
    private String userFirstName;
    private String userEmail;

    public String toJSON(){
        String object = "{\"orderId\":\"%s\",\"userFirstName\":\"%s\",\"userEmail\":\"%s\"}";
        return String.format(object, this.orderId, this.userFirstName, this.userEmail);
    }
}
