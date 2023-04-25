package com.example.lmsbackend.Converters;

import com.example.lmsbackend.Enums.Genre;
import com.example.lmsbackend.Models.Author;
import com.example.lmsbackend.Models.Book;
import com.example.lmsbackend.Repositories.AuthorRepository;
import com.example.lmsbackend.RequestDTOs.BookRequestDTO;
import com.example.lmsbackend.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookConverter {

    @Autowired
    static
    AuthorService authorService;

    public static Book convertBookDTOtoEntity(BookRequestDTO bookRequestDTO){
        Book newBook= Book.builder()
                .name(bookRequestDTO.getName()).build();
        if(bookRequestDTO.getGenre().equals("FICTION"))
            newBook.setGenre(Genre.FICTION);
        else if (bookRequestDTO.getGenre().equals("ROMANCE"))
            newBook.setGenre(Genre.ROMANCE);
        else if (bookRequestDTO.getGenre().equals("THRILLER"))
            newBook.setGenre(Genre.THRILLER);
        else if (bookRequestDTO.getGenre().equals("MYSTERY"))
            newBook.setGenre(Genre.MYSTERY);
        else if (bookRequestDTO.getGenre().equals("ADVENTURE"))
            newBook.setGenre(Genre.ADVENTURE);
        else
            newBook.setGenre(Genre.FANTASY);

        Author author= authorService.getById(bookRequestDTO.getAuthorId());
        newBook.setAuthor(author);
        return newBook;
    }
}
