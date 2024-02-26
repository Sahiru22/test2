package com.example.demobookauthorservice.repository;

import com.example.demobookauthorservice.model.Author;
import com.example.demobookauthorservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByAuthorId(long authorId);

    List<Book> findBookByAuthor(Author author);
}
