package com.example.demobookauthorservice.service.impl;

import com.example.demobookauthorservice.controller.request.AuthorRequest;
import com.example.demobookauthorservice.model.Author;
import com.example.demobookauthorservice.repository.AuthorRepository;
import com.example.demobookauthorservice.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public void add(AuthorRequest request) {
        Author author = new Author();

        author.setId(request.getId());;
        author.setName(request.getName());

        authorRepository.save(author);
    }
}
