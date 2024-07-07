package com.example.library_demo.service.impl;

import com.example.library_demo.model.Book;
import com.example.library_demo.repository.AuthorRepository;
import com.example.library_demo.repository.BookRepository;
import com.example.library_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
