package hexa.shop.core.application.mapper;

import org.springframework.stereotype.Component;

import hexa.shop.core.application.dto.UserLoginDTO;
import hexa.shop.core.application.dto.UserDTO;
import hexa.shop.core.domain.model.RoleEnum;
import hexa.shop.core.domain.model.User;
import hexa.shop.core.infrastructure.persistence.jpa.UserEntity;

@Component
public class UserMapper {
    public UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole().toString());

        return userEntity;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole().toString());

        return userDTO;
    }

    public UserLoginDTO toLoginDTO(User user) {
        if (user == null) {
            return null;
        }

        UserLoginDTO userDTO = new UserLoginDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User toDomain(UserLoginDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public User toDomain(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(RoleEnum.valueOf(userDTO.getRole()));

        return user;
    }

    public User toDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();

        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setRole(RoleEnum.valueOf(userEntity.getRole()));

        return user;
    }

}
