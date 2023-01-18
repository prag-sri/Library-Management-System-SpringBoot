package com.example.lmsbackend.Controllers;

import com.example.lmsbackend.RequestDTOs.BookRequestDTO;
import com.example.lmsbackend.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("create_book")
    public ResponseEntity<String> createBook(@RequestBody() BookRequestDTO bookRequestDTO){
        String result= bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
