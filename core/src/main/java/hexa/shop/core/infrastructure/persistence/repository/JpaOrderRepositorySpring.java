package hexa.shop.core.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hexa.shop.core.infrastructure.persistence.jpa.OrderEntity;

public interface JpaOrderRepositorySpring extends JpaRepository<OrderEntity, Long> {
}