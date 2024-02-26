package com.example.demobookauthorservice.controller.response;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String name;
    private String Category;
    private Integer year;
}
