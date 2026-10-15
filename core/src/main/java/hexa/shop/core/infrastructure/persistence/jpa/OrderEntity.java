package hexa.shop.core.infrastructure.persistence.jpa;

import java.util.List;

import hexa.shop.core.domain.model.Book;
import hexa.shop.core.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "orders")
@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity user;
    @ManyToMany
    private List<BookEntity> books;
    @Column()
    private String timestamp;
}
