package hexa.shop.core.infrastructure.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import hexa.shop.core.application.mapper.BookMapper;
import hexa.shop.core.domain.model.Book;
import hexa.shop.core.domain.port.repository.BookRepositoryPort;
import hexa.shop.core.infrastructure.persistence.jpa.BookEntity;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaBookRepository implements BookRepositoryPort {
    private final JpaBookRepositorySpring bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = bookRepository.save(bookMapper.toEntity(book));
        return bookMapper.toDomain(bookEntity);
    }

    @Override
    public Book findById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).get();
        return bookMapper.toDomain(bookEntity);
    }

    @Override
    public List<Book> findAllAvailable() {
        List<BookEntity> bookEntities = bookRepository.findByQuantityGreaterThan(0);
        return bookEntities.stream()
                .map(bookMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    
}
