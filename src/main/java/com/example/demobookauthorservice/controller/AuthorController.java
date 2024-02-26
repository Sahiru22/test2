package com.example.demobookauthorservice.controller;

import com.example.demobookauthorservice.controller.request.AuthorRequest;
import com.example.demobookauthorservice.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/authors")
    public void create(@RequestBody AuthorRequest request){
        authorService.add(request);
    }

}
