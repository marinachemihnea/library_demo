package com.example.library_demo.controller;

import com.example.library_demo.model.Author;
import com.example.library_demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return ResponseEntity.notFound().build();
        }
        Author updatedAuthor = authorService.updateAuthor(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return ResponseEntity.notFound().build();
        }
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }


}
