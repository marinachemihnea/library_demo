package com.example.library_demo.controller;

import com.example.library_demo.model.Book;
import com.example.library_demo.model.Author;
import com.example.library_demo.service.AuthorService;
import com.example.library_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


}
