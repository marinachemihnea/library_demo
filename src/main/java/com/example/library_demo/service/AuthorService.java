package com.example.library_demo.service;

import com.example.library_demo.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author addAuthor(Author author);
    void deleteAuthor(Long id);
    Author updateAuthor(Author author);

}
