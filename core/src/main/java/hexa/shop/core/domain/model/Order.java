package hexa.shop.core.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private User user;
    private List<Book> books;
    private String timestamp;
}
