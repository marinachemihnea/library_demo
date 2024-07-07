package com.example.library_demo.controller;

import com.example.library_demo.model.Book;
import com.example.library_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        book.setTitle(bookDetails.getTitle());
        book.setGenre(bookDetails.getGenre());
        book.setAuthorId(bookDetails.getAuthorId());
        Book updatedBook = bookService.updateBook(book);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
