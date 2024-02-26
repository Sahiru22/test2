package com.example.demobookauthorservice.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookBuilderResponse {
    private Long id;
    private String name;
    private String Category;
    private Integer year;
    private String authorName;

}
