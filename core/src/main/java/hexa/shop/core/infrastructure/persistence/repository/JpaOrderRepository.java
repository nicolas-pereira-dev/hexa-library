package hexa.shop.core.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import hexa.shop.core.application.mapper.OrderMapper;
import hexa.shop.core.domain.model.Order;
import hexa.shop.core.domain.port.repository.OrderRepositoryPort;
import hexa.shop.core.infrastructure.persistence.jpa.OrderEntity;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepository implements OrderRepositoryPort {
    private final JpaOrderRepositorySpring orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order orderBooks(Order order) {
        OrderEntity orderEntity = orderRepository.save(orderMapper.toEntity(order));
        return orderMapper.toDomain(orderEntity);
    }

}
