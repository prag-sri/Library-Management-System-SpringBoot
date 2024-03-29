package com.example.lmsbackend.Controllers;

import com.example.lmsbackend.Models.Author;
import com.example.lmsbackend.RequestDTOs.AuthorRequestDTO;
import com.example.lmsbackend.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<String> createAuthor(@RequestBody() AuthorRequestDTO authorRequestDTO){
        String result= authorService.createAuthor(authorRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("get_by_id")
    public ResponseEntity<Author> getById(@RequestParam("id")Integer id){
        Author author= authorService.getById(id);
        return new ResponseEntity<>(author, HttpStatus.FOUND);
    }
}
