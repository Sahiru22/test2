package com.example.demobookauthorservice.service;

import com.example.demobookauthorservice.controller.request.BookRequest;
import com.example.demobookauthorservice.controller.response.BookBuilderResponse;
import com.example.demobookauthorservice.controller.response.BookResponse;

import java.util.List;

public interface BookService {
    void add(BookRequest request, long authorId);

    List<BookResponse> getAuthorBooks(long authorId);

    List<BookBuilderResponse> get(long authorId);
}
