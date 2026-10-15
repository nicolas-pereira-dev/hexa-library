package hexa.shop.core.domain.service;

import org.springframework.stereotype.Service;

import hexa.shop.core.domain.model.User;
import hexa.shop.core.domain.port.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryPort userRepositoryPort;

    public User register(User book) {
        return userRepositoryPort.save(book);
    }

    public User login(User user) {
        User result = userRepositoryPort.findByUsername(user.getUsername());
        return result != null && result.getPassword().equals(user.getPassword()) ? result : null;
    }

    public User findById(Long id){
        return userRepositoryPort.findById(id);
    }

    public void deleteById(Long id) {
        userRepositoryPort.deleteById(id);
    }
}
