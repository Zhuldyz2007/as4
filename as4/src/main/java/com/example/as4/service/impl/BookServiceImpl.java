package com.example.as4.service.impl;

import com.example.as4.model.dto.BookDTO;
import com.example.as4.model.entity.Book;
import com.example.as4.repository.BookRepository;
import com.example.as4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .pages(dto.getPages())
                .price(dto.getPrice())
                .publishedYear(dto.getPublishedYear())
                .build();
        return mapToDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return mapToDTO(book);
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO update(Long id, BookDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());
        book.setPrice(dto.getPrice());
        book.setPublishedYear(dto.getPublishedYear());

        return mapToDTO(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDTO mapToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pages(book.getPages())
                .price(book.getPrice())
                .publishedYear(book.getPublishedYear())
                .build();
    }
}