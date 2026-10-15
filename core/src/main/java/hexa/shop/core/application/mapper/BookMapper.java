package hexa.shop.core.application.mapper;

import org.springframework.stereotype.Component;

import hexa.shop.core.application.dto.BookDTO;
import hexa.shop.core.domain.model.Book;
import hexa.shop.core.infrastructure.persistence.jpa.BookEntity;

@Component
public class BookMapper {
    public Book toDomain(BookEntity bookEntity) {
        if (bookEntity == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setTitle(bookEntity.getName());
        book.setDescription(bookEntity.getDescription());
        book.setPrice(bookEntity.getPrice());
        book.setQuantity(bookEntity.getQuantity());
        book.setImagePath(bookEntity.getURI());
        return book;
    }

    public Book toDomain(BookDTO dto) {
        if (dto == null) {
            return null;
        }
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getName());
        book.setDescription(dto.getDescription());
        book.setPrice(dto.getPrice());
        book.setQuantity(dto.getQuantity());
        book.setImagePath(dto.getURI());
        return book;
    }

    public BookEntity toEntity(Book book) {
        if (book == null) {
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setName(book.getTitle());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setQuantity(book.getQuantity());
        bookEntity.setURI(book.getImagePath());
        return bookEntity;
    }

    public BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setPrice(book.getPrice());
        dto.setQuantity(book.getQuantity());
        dto.setURI(book.getImagePath());
        return dto;
    }
}
