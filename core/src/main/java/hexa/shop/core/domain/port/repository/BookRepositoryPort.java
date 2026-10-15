package hexa.shop.core.domain.port.repository;

import java.util.List;

import hexa.shop.core.domain.model.Book;

public interface BookRepositoryPort {
    Book save(Book book);
    Book findById(Long id);
    List<Book> findAllAvailable();
    void deleteById(Long id);
}
