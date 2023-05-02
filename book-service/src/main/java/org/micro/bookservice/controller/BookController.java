package org.micro.bookservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.micro.bookservice.model.Book;
import org.micro.bookservice.service.book.BookService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {
    private final BookService bookService;
    private final Environment env;

    @GetMapping
    public List<Book> getAllBooks(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        log.info("Try get all books at port :{}", env.getProperty("local.server.port"));
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        if (book.getId() == null) throw new IllegalArgumentException();
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable String id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
