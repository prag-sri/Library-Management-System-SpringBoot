package com.example.lmsbackend.Repositories;

import com.example.lmsbackend.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
