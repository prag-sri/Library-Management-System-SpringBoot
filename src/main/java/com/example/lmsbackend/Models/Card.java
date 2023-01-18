package com.example.lmsbackend.Models;

import com.example.lmsbackend.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Book> booksIssued;
}
