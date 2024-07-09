package com.example.librarydemo.controller;

import com.example.library_demo.controller.BookController;
import com.example.library_demo.model.Book;
import com.example.library_demo.service.impl.BookServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl bookService;

    @Test
    public void testGetBookById() throws Exception{
        Book mockBook = new Book(1L, "Lorem Ipsum", "Genre", 1L);
        Mockito.when(bookService.getBookById(1L)).thenReturn(mockBook);

        mockMvc.perform(MockMvcRequestBuilders.get("/library/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Lorem Ipsum")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre", Matchers.is("Genre")));
    }

    @Test
    public void testAddBook() throws Exception{
        Book newBook = new Book(null, "Lorem Ipsum", "Genre", 1L);
        Book savedBook = new Book(1L, "Lorem Ipsum", "Genre", 1L);
        Mockito.when(bookService.addBook(newBook)).thenReturn(savedBook);

        mockMvc.perform(MockMvcRequestBuilders.post("/library/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Lorem Ipsum\", \"genre\": \"Genre\", \"authorId\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Lorem Ipsum")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre", Matchers.is("Genre")));
    }

    @Test
    public void testUpdatedBook() throws Exception{
        Book updatedBookDetails = new Book(null, "Updated Ipsum", "New", 1L);
        Book updatedBook = new Book(1L, "Updated Ipsum", "New", 1L);
        Mockito.when(bookService.updateBook(Mockito.any(Book.class))).thenReturn(updatedBook);

        mockMvc.perform(MockMvcRequestBuilders.put("/library/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Updated Ipsum\", \"genre\": \"New\", \"authorId\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Updated Ipsum")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre", Matchers.is("New")));
    }

    @Test
    public void testDeleteBook() throws Exception{
        Mockito.doNothing().when(bookService).deleteBook(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/library/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(bookService, Mockito.times(1)).deleteBook(1L);
    }


}
