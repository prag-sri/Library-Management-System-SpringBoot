package com.example.lmsbackend.Services;

import com.example.lmsbackend.Converters.BookConverter;
import com.example.lmsbackend.Models.Author;
import com.example.lmsbackend.Models.Book;
import com.example.lmsbackend.Repositories.AuthorRepository;
import com.example.lmsbackend.Repositories.BookRepository;
import com.example.lmsbackend.RequestDTOs.BookRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String createBook(BookRequestDTO bookRequestDTO){
        Book newBook= BookConverter.convertBookDTOtoEntity(bookRequestDTO);

        //need to set author entity
        int authorId= bookRequestDTO.getAuthorId();
        Author author= authorRepository.findById(authorId).get();
        newBook.setAuthor(author);

        //book list also needs to be updated
        List<Book> bookList= author.getBooksWritten();
        bookList.add(newBook);
        author.setBooksWritten(bookList);

        //saving author
//        authorRepository.save(author);

        bookRepository.save(newBook);

        return "New Book created successfully!";
    }

    public List<Book> suggestBook(String genre){
        List<Book> booksRecommended= new ArrayList<>();
        List<Book> books= bookRepository.findAll();
        for(Book book: books)
        {
            if(book.getGenre().toString().equals(genre))
                booksRecommended.add(book);
        }
        return booksRecommended;
    }
}
