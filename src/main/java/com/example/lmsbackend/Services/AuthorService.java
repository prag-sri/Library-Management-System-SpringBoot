package com.example.lmsbackend.Services;

import com.example.lmsbackend.Converters.AuthorConverter;
import com.example.lmsbackend.Models.Author;
import com.example.lmsbackend.Repositories.AuthorRepository;
import com.example.lmsbackend.RequestDTOs.AuthorRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorRequestDTO authorRequestDTO){
        try{
            Author newAuthor= AuthorConverter.convertAuthorDTOtoEntity(authorRequestDTO);
            authorRepository.save(newAuthor);
        }catch(Exception e){
            log.info("createAuthor has caused an issue");
            return "Create Author did not work!";
        }
        return "New Author created successfully!";
    }
}
