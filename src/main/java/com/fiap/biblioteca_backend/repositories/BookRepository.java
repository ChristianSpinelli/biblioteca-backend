package com.fiap.biblioteca_backend.repositories;

import com.fiap.biblioteca_backend.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * from books b WHERE b.id > :lastBookId LIMIT pageLength", nativeQuery = true)
    public List<Book> listBooks(
            @Param("lastBookId") Long lastBookId,
            @Param("pageLength") Integer pageLength
    );
}
