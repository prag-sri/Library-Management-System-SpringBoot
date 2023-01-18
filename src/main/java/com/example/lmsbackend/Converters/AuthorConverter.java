package com.example.lmsbackend.Converters;

import com.example.lmsbackend.Models.Author;
import com.example.lmsbackend.RequestDTOs.AuthorRequestDTO;

public class AuthorConverter {

    public static Author convertAuthorDTOtoEntity(AuthorRequestDTO authorRequestDTO){
        Author newAuthor= Author.builder()
                .name(authorRequestDTO.getName())
                .age(authorRequestDTO.getAge())
                .country(authorRequestDTO.getCountry())
                .email(authorRequestDTO.getEmail()).build();
        return newAuthor;
    }
}
