package com.example.lmsbackend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String country;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    //One author can have multiple books and not a single book so taking list
    private List<Book> booksWritten;
}
