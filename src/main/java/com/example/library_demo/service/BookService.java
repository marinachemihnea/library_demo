package com.example.library_demo.service;

import com.example.library_demo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Book book);


}
