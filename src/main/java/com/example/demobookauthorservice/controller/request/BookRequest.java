package com.example.demobookauthorservice.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest {
    private Long id;
    private String name;
    private String Category;
    private Integer year;
}
