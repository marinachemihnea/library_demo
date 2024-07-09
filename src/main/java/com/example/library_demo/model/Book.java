package com.example.library_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    public Book(){
        //default constructor
    }

    public Book(String title, String genre, Long authorId){
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }


}
