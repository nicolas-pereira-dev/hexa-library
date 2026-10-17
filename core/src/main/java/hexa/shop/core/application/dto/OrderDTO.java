package hexa.shop.core.application.dto;

import java.util.List;

import hexa.shop.core.domain.model.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private List<BookDTO> books;
    private String timestamp;
    private OrderStatusEnum orderStatus;
}
