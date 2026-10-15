package hexa.shop.core.domain.port.repository;

import hexa.shop.core.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
    User findByUsername(String username);
    User findById(Long id);
    void deleteById(Long id);
}
