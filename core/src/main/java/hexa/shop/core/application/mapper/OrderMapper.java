package hexa.shop.core.application.mapper;

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
    private UserService userService;
    private UserMapper userMapper;
    private BookMapper bookMapper;

    public Order toDomain(OrderEntity orderEntity){
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setUser(userMapper.toDomain(orderEntity.getUser()));
        order.setBooks(orderEntity.getBooks().stream().map(bookMapper::toDomain).toList());
        order.setTimestamp(orderEntity.getTimestamp());
        return order;
    }

    public Order toDomain(OrderDTO orderDTO){
        User user = userService.findById(orderDTO.getUserId());
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setUser(user);
        order.setBooks(orderDTO.getBooks().stream().map(bookMapper::toDomain).toList());
        order.setTimestamp(orderDTO.getTimestamp());
        return order;
    }

    public OrderEntity toEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setUser(userMapper.toEntity(order.getUser()));
        orderEntity.setBooks(order.getBooks().stream().map(bookMapper::toEntity).toList());
        orderEntity.setTimestamp(order.getTimestamp());
        return orderEntity;
    }

    public OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setBooks(order.getBooks().stream().map(bookMapper::toDTO).toList());
        orderDTO.setTimestamp(order.getTimestamp());
        return orderDTO;
    }

    public OrderEvent toEvent(Order order) {
        User user = order.getUser();
        OrderEvent event = new OrderEvent();
        event.setOrderId(order.getId());
        event.setUserFirstName(user.getFirstName());
        event.setUserEmail(user.getEmail());
        return event;
    }
}
