package com.example.library_demo.service;

import com.example.library_demo.model.Author;
import com.example.library_demo.model.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author addAuthor(Author author);
    void deleteAuthor(Long id);
    Author updateAuthor(Author author);

}
