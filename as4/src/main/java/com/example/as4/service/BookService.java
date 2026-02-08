package com.example.as4.service;

import com.example.as4.model.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO create(BookDTO dto);
    BookDTO getById(Long id);
    List<BookDTO> getAll();
    BookDTO update(Long id, BookDTO dto);
    void delete(Long id);
}