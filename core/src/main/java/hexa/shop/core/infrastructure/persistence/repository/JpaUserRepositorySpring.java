package hexa.shop.core.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import hexa.shop.core.infrastructure.persistence.jpa.UserEntity;

public interface JpaUserRepositorySpring extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    Optional<UserEntity> findById(Long id);
}
