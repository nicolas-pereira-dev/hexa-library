package hexa.shop.core.application.mapper;

import java.sql.Timestamp;
import org.springframework.stereotype.Component;
import hexa.shop.core.application.dto.OrderDTO;
import hexa.shop.core.domain.model.Order;
import hexa.shop.core.domain.model.User;
import hexa.shop.core.domain.service.UserService;
import hexa.shop.core.infrastructure.kafka.event.OrderEvent;
import hexa.shop.core.infrastructure.persistence.jpa.OrderEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final UserService userService;
    private final UserMapper userMapper;
    private final BookMapper bookMapper;

    public Order toDomain(OrderEntity orderEntity){
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setUser(userMapper.toDomain(orderEntity.getUser()));
        order.setBooks(orderEntity.getBooks().stream().map(bookMapper::toDomain).toList());
        order.setTimestamp(orderEntity.getTimestamp());
        order.setOrderStatus(orderEntity.getOrderStatus());
        return order;
    }

    public Order toDomain(OrderDTO orderDTO){
        User user = userService.findById(orderDTO.getUserId());
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setUser(user);
        order.setBooks(orderDTO.getBooks().stream().map(bookMapper::toDomain).toList());
        order.setTimestamp(orderDTO.getTimestamp());
        order.setOrderStatus(orderDTO.getOrderStatus());
        return order;
    }

    public OrderEntity toEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setUser(userMapper.toEntity(order.getUser()));
        orderEntity.setBooks(order.getBooks().stream().map(bookMapper::toEntity).toList());
        orderEntity.setTimestamp(order.getTimestamp());
        orderEntity.setOrderStatus(order.getOrderStatus());
        return orderEntity;
    }

    public OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setBooks(order.getBooks().stream().map(bookMapper::toDTO).toList());
        orderDTO.setTimestamp(order.getTimestamp());
        orderDTO.setOrderStatus(order.getOrderStatus());
        return orderDTO;
    }

    public OrderEvent toEvent(Order order) {
        User user = order.getUser();
        OrderEvent event = new OrderEvent();
        Timestamp timestamp = new Timestamp(Long.parseLong(order.getTimestamp()));
        event.setOrderId(order.getId());
        event.setUserFirstName(user.getFirstName());
        event.setUserEmail(user.getEmail());
        event.setOrderDate(timestamp.toLocalDateTime().toLocalDate());
        event.setOrderStatus(order.getOrderStatus());
        return event;
    }
}
