package hexa.shop.core.infrastructure.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hexa.shop.core.application.dto.BookDTO;
import hexa.shop.core.application.mapper.BookMapper;
import hexa.shop.core.domain.model.Book;
import hexa.shop.core.domain.service.BookService;
import hexa.shop.core.domain.service.ImageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final ImageService imageService;

    @PostMapping("/save")
    public BookDTO save(@RequestBody BookDTO requestDTO) {
        Book book = bookMapper.toDomain(requestDTO);
        BookDTO resultDTO = bookMapper.toDTO(bookService.save(book));
        return resultDTO;
    }

    @GetMapping("/findById")
    public BookDTO findById(@RequestParam Long id) {
        return bookMapper.toDTO(bookService.findById(id));
    }

    @GetMapping("/available")
    public List<BookDTO> findAllAvailable() {
        return bookService.findAllAvailable().stream().map(bookMapper::toDTO).toList();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getBookImage(@PathVariable Long id) throws IOException {
        Book book = bookService.findById(id);
        InputStream imageStream = imageService.getImage(book.getImagePath());
        byte[] imageBytes = imageStream.readAllBytes();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }
}
