package com.example.lmsbackend.Converters;

import com.example.lmsbackend.Models.Book;
import com.example.lmsbackend.RequestDTOs.BookRequestDTO;

public class BookConverter {

    public static Book convertBookDTOtoEntity(BookRequestDTO bookRequestDTO){
        Book newBook= Book.builder()
                .name(bookRequestDTO.getName())
                .genre(bookRequestDTO.getGenre()).build();
        return newBook;
        //author object is expected- author entity has to be set
    }
}
