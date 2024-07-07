package com.example.library_demo.service.impl;

import com.example.library_demo.model.Author;
import com.example.library_demo.repository.AuthorRepository;
import com.example.library_demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }
}
