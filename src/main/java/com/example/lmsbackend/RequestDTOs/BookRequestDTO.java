package com.example.lmsbackend.RequestDTOs;

import com.example.lmsbackend.Enums.Genre;
import lombok.Data;

@Data
public class BookRequestDTO {
    private String name;
    private Genre genre;
    private int authorId;
}
