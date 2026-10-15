package hexa.shop.core.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hexa.shop.core.domain.model.Book;
import hexa.shop.core.domain.port.repository.BookRepositoryPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryPort bookRepositoryPort;

    public Book save(Book book) {
        return bookRepositoryPort.save(book);
    }

    public Book findById(Long id) {
        return bookRepositoryPort.findById(id);
    }

    public List<Book> findAllAvailable() {
        return bookRepositoryPort.findAllAvailable();
    }

    public void deleteById(Long id) {
        bookRepositoryPort.deleteById(id);
    }
}
