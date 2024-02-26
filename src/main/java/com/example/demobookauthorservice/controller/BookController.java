package com.example.demobookauthorservice.controller;

import com.example.demobookauthorservice.controller.request.BookRequest;
import com.example.demobookauthorservice.controller.response.BookBuilderResponse;
import com.example.demobookauthorservice.controller.response.BookResponse;
import com.example.demobookauthorservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/authors/{author-id}/books")
    public void add(@RequestBody BookRequest request, @PathVariable ("author-id") long authorId){
        bookService.add(request,authorId);
    }

    @GetMapping("/authors/{author-id}/books")
    public List<BookResponse> getAuthorBooks(@PathVariable ("author-id") long authorId){
       return bookService.getAuthorBooks(authorId);
    }

    @GetMapping("/authors/{author-id}/books111")
    public List<BookBuilderResponse> get(@PathVariable ("author-id") long authorId){
        return bookService.get(authorId);
    }

}
