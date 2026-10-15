package hexa.shop.core.domain.service;

import org.springframework.stereotype.Service;

import hexa.shop.core.application.mapper.OrderMapper;
import hexa.shop.core.domain.model.Order;
import hexa.shop.core.domain.port.repository.OrderRepositoryPort;
import hexa.shop.core.infrastructure.kafka.event.OrderEvent;
import hexa.shop.core.infrastructure.kafka.producer.OrderEventProducer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepositoryPort orderRepository;
    private OrderEventProducer orderEventProducer;
    private OrderMapper orderMapper;

    public Order orderBooks(Order order) {
        Order result = orderRepository.orderBooks(order);
        if(result != null){
            OrderEvent event = orderMapper.toEvent(result);
            this.orderEventProducer.publishOrderEvent(event);
        }
        return result;
    }
}
