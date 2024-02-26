package com.example.demobookauthorservice.service.impl;

import com.example.demobookauthorservice.controller.request.BookRequest;
import com.example.demobookauthorservice.controller.response.BookBuilderResponse;
import com.example.demobookauthorservice.controller.response.BookResponse;
import com.example.demobookauthorservice.model.Author;
import com.example.demobookauthorservice.model.Book;
import com.example.demobookauthorservice.repository.AuthorRepository;
import com.example.demobookauthorservice.repository.BookRepository;
import com.example.demobookauthorservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public final AuthorRepository authorRepository;


    @Override
    public void add(BookRequest request, long authorId) {

        Optional<Author> authorOptional = authorRepository.findById(authorId);

        if (authorOptional.isPresent()){
            Author author = authorOptional.get();

            Book book = new Book();
            book.setId(request.getId());
            book.setName(request.getName());
            book.setCategory(request.getCategory());
            book.setYear(request.getYear());

            book.setAuthor(author);

            bookRepository.save(book);
        }

    }

    @Override
    public List<BookResponse> getAuthorBooks(long authorId) {

        List<Book> books = bookRepository.findByAuthorId(authorId);

        List<BookResponse> bookResponseList = new ArrayList<>();

        for (Book book : books){
            BookResponse response = new BookResponse();

            response.setId(book.getId());
            response.setName(book.getName());
            response.setCategory(book.getCategory());
            response.setYear(book.getYear());

            bookResponseList.add(response);

        }
        return bookResponseList;
    }

    @Override
    public List<BookBuilderResponse> get(long authorId) {

        Optional<Author> authorOptional = authorRepository.findById(authorId);

        if (authorOptional.isPresent()){
            Author author = authorOptional.get();

            List<Book> books = bookRepository.findBookByAuthor(author);

            return books.stream()
                    .map(book -> BookBuilderResponse.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .Category(book.getCategory())
                            .year(book.getYear())
                            .authorName(book.getAuthor().getName())
                            .build())
                    .toList();
        }
        return null;
    }
}
