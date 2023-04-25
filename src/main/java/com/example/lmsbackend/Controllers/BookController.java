package com.example.lmsbackend.Controllers;

import com.example.lmsbackend.Models.Book;
import com.example.lmsbackend.RequestDTOs.BookRequestDTO;
import com.example.lmsbackend.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create_book")
    public ResponseEntity<String> createBook(@RequestBody() BookRequestDTO bookRequestDTO){
        String result= bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/suggest_book")
    public ResponseEntity<List<Book>> suggestBook(@RequestParam("genre")String genre){
        List<Book> books= bookService.suggestBook(genre);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
