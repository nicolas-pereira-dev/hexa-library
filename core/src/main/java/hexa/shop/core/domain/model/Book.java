package hexa.shop.core.domain.model;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer quantity;
    private String imagePath;
    private User seller;
}
