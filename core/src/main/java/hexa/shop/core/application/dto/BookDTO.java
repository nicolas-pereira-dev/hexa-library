package hexa.shop.core.application.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String URI;
}
