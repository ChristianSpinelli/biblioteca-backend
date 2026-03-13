package com.fiap.biblioteca_backend.services;

import com.fiap.biblioteca_backend.dto.BookDTO;
import com.fiap.biblioteca_backend.models.Book;

import java.util.List;

public interface BookService {

    public List<BookDTO> listBooks(Long lastBookId, Integer pageLength);
    public Book saveBook(BookDTO bookDTO);
}
