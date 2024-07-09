package com.example.librarydemo.controller;

import com.example.library_demo.model.Author;
import com.example.library_demo.service.impl.AuthorServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorServiceImpl authorService;

    @Test
    public void testGetAuthorById() throws Exception {

        Author mockAuthor = new Author(1L, "John Doe");
        Mockito.when(authorService.getAuthorById(1L)).thenReturn(mockAuthor);

        mockMvc.perform(MockMvcRequestBuilders.get("/library/authors/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName", Matchers.is("John Doe")));

    }

    @Test
    public void testAddAuthor() throws Exception {

        Author newAuthor = new Author(null, "Foo Bar");
        Author existingAuthor = new Author(1L, "Foo Bar");
        Mockito.when(authorService.addAuthor(newAuthor)).thenReturn(existingAuthor);

        mockMvc.perform(MockMvcRequestBuilders.post("/library/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Foo Bar\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Foo Bar")));
    }

}
