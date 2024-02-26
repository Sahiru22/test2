package com.example.demobookauthorservice.repository;

import com.example.demobookauthorservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
