package com.example.lmsbackend.RequestDTOs;

import com.example.lmsbackend.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookRequestDTO {
    private String name;
    private String genre;
    private int authorId;
}
