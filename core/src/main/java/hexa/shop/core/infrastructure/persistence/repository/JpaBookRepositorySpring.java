package hexa.shop.core.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import hexa.shop.core.infrastructure.persistence.jpa.BookEntity;

public interface JpaBookRepositorySpring extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByQuantityGreaterThan(Integer quantity);
}