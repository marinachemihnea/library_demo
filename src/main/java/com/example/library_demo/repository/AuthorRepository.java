package com.example.library_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_demo.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
