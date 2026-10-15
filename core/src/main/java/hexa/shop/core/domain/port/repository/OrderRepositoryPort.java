package hexa.shop.core.domain.port.repository;

import hexa.shop.core.domain.model.Order;

public interface OrderRepositoryPort {
    public Order orderBooks(Order order);
}
