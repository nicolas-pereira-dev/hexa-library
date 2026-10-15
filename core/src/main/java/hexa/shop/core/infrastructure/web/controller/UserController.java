package hexa.shop.core.infrastructure.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hexa.shop.core.application.dto.UserLoginDTO;
import hexa.shop.core.application.dto.UserDTO;
import hexa.shop.core.application.mapper.UserMapper;
import hexa.shop.core.domain.model.User;
import hexa.shop.core.domain.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO requestDTO) {
        User user = userMapper.toDomain(requestDTO);
        UserDTO resultDTO = userMapper.toDTO(userService.register(user));
        return user != null ? ResponseEntity.ok(resultDTO) : ResponseEntity.status(400).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO requestDTO) {
        User user = userMapper.toDomain(requestDTO);
        UserDTO userDTO = userMapper.toDTO(userService.login(user));
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.status(401).build();
    }
}
