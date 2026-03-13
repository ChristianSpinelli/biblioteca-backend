package com.fiap.biblioteca_backend.mappers;

import com.fiap.biblioteca_backend.dto.BookDTO;
import com.fiap.biblioteca_backend.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setYear(bookDTO.getYear());
        book.setIsbn(bookDTO.getIsbn());
        return book;
    }

    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                book.getIsbn()
        );
    }

    public List<BookDTO> toDTOList(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYear(),
                    book.getIsbn()
            );
            bookDTOS.add(bookDTO);
        }

        return bookDTOS;
    }
}
