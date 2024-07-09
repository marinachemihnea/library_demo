package com.example.library_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Author(){
        //default constructor
    }

    public Author(Long id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
    }
}
