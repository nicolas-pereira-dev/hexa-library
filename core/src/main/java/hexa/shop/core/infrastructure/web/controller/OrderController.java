package hexa.shop.core.infrastructure.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hexa.shop.core.application.dto.OrderDTO;
import hexa.shop.core.application.mapper.OrderMapper;
import hexa.shop.core.domain.model.Order;
import hexa.shop.core.domain.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/books")
    public OrderDTO orderBooks(@RequestBody OrderDTO requestDTO) {
        Order order = orderMapper.toDomain(requestDTO);
        OrderDTO result = orderMapper.toDTO(orderService.orderBooks(order));
        return result;
        
    }
}
