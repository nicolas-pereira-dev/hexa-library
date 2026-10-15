package hexa.shop.core.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import hexa.shop.core.application.mapper.UserMapper;
import hexa.shop.core.domain.model.User;
import hexa.shop.core.domain.port.repository.UserRepositoryPort;
import hexa.shop.core.infrastructure.persistence.jpa.UserEntity;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepositoryPort {
    private final JpaUserRepositorySpring userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(user));
        return this.userMapper.toDomain(this.userRepository.save(userEntity));
    }

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username);
        return this.userMapper.toDomain(userEntity);
    }

    @Override
    public User findById(Long id){
        UserEntity userEntity = this.userRepository.findById(id).get();
        return this.userMapper.toDomain(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
    
}
