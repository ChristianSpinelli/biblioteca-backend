package com.fiap.biblioteca_backend.services.impl;

import com.fiap.biblioteca_backend.dto.BookDTO;
import com.fiap.biblioteca_backend.mappers.BookMapper;
import com.fiap.biblioteca_backend.models.Book;
import com.fiap.biblioteca_backend.repositories.BookRepository;
import com.fiap.biblioteca_backend.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> listBooks(Long lastBookId, Integer pageLength) {
        List<Book> books = this.bookRepository.listBooks(lastBookId, pageLength);
        return this.bookMapper.toDTOList(books);
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book book = this.bookMapper.toEntity(bookDTO);
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
