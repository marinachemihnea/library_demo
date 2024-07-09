package com.example.librarydemo.service;

import com.example.library_demo.model.Book;
import com.example.library_demo.repository.BookRepository;
import com.example.library_demo.service.BookService;
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
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetBookById(){

        Book mockBook = new Book(1L, "Lorem Ipsum", "Genre", 1L);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));

        Book result = bookService.getBookById(1L);

        Assert.assertEquals(1L, result.getId().longValue());
        Assert.assertEquals("Lorem Ipsum", result.getTitle());
        Assert.assertEquals("Genre", result.getGenre());
        Assert.assertEquals(1L, result.getAuthorId().longValue());

    }

    @Test
    public void testAddBook(){
        Book newBook = new Book(null, "Lorem Ipsum", "Genre", 1L);
        Book existingBook = new Book(1L, "Lorem Ipsum", "Genre", 1L);
        Mockito.when(bookRepository.save(newBook)).thenReturn(existingBook);

        Book result = bookService.addBook(newBook);

        Assert.assertEquals(1L, result.getId().longValue());
        Assert.assertEquals("Lorem Ipsum", result.getTitle());
        Assert.assertEquals("Genre", result.getGenre());
        Assert.assertEquals(1L, result.getAuthorId().longValue());
    }

    @Test
    public void testUpdateBook(){
        Book existingBook = new Book(1L, "Existing", "Old", 1L);
        Book updatedBookDetails = new Book(null, "Updated", "New", 1L);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));
        Mockito.when(bookRepository.save(existingBook)).thenReturn(existingBook);

        Book result = bookService.updateBook(updatedBookDetails);

        Assert.assertEquals(1L, result.getId().longValue());
        Assert.assertEquals("Updated", result.getTitle());
        Assert.assertEquals("New", result.getGenre());
        Assert.assertEquals(1L, result.getAuthorId().longValue());
    }

    @Test
    public void testDeleteBook(){
        Book existingBook = new Book(1L, "Existing", "Old", 1L);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));

        bookService.deleteBook(1L);

        Mockito.verify(bookRepository, Mockito.times(1)).delete(existingBook);
    }

}
