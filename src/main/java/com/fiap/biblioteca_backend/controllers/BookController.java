package com.fiap.biblioteca_backend.controllers;

import com.fiap.biblioteca_backend.dto.BookDTO;
import com.fiap.biblioteca_backend.models.Book;
import com.fiap.biblioteca_backend.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{lastBookId}/{pageLength}")
    public ResponseEntity<?> listBooks(
            @PathVariable("lastBookId") Long lastBookId,
            @PathVariable("pageLength") Integer pageLength
    ){
        List<BookDTO> books = this.bookService.listBooks(lastBookId, pageLength);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody BookDTO bookDTO){
        Book book = this.bookService.saveBook(bookDTO);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId){

    }
}
