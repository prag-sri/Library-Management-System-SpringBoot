package com.example.lmsbackend.Repositories;

import com.example.lmsbackend.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
