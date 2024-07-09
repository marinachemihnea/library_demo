package com.example.librarydemo.service;


import com.example.library_demo.model.Author;
import com.example.library_demo.repository.AuthorRepository;
import com.example.library_demo.service.AuthorService;
import com.example.library_demo.service.impl.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void testGetAuthorById() {
        Author mockAuthor = new Author(1L, "Foo Bar");
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(mockAuthor));

        Author result = authorService.getAuthorById(1L);

        Assert.assertEquals(1L, result.getId().longValue());
        Assert.assertEquals("Foo Bar", result.getName());
    }

    @Test
    public void testAddAuthor() {
        Author newAuthor = new Author(null, "Foo Bar");
        Author existingAuthor = new Author(1L, "Foo Bar");
        Mockito.when(authorRepository.save(newAuthor)).thenReturn(existingAuthor);

        Author result = authorService.addAuthor(existingAuthor);

        Assert.assertEquals(1L, result.getId().longValue());
        Assert.assertEquals("Foo Bar", result.getName());

    }

    @Test
    public void testDeleteAuthor() {
        Author existingAuthor = new Author(1L, "Old Author");
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(existingAuthor));

        authorService.deleteAuthor(1L);

        Mockito.verify(authorRepository, Mockito.times(1)).delete(existingAuthor);
    }

    @Test
    public void testUpdateAuthor() {
        Author existingAuthor = new Author(1L, "John Doe");
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(existingAuthor));

        authorService.deleteAuthor(1L);

        Mockito.verify(authorRepository, Mockito.times(1)).delete(existingAuthor);
    }

}
