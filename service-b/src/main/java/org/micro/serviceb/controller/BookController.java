package org.micro.serviceb.controller;

import lombok.AllArgsConstructor;
import org.micro.serviceb.feign.BookServiceConnector;
import org.micro.serviceb.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/books")
public class BookController {
    private final BookServiceConnector bookServiceConnector;
    @GetMapping
    public List<Book> getAllBooks(@RequestHeader("Authorization") String authorization ) {
        return bookServiceConnector.getAllBooks(authorization);
    }
    @GetMapping("{id}")
    public Book getBookById(@RequestHeader("Authorization") String authorization, @PathVariable String id) {
        return bookServiceConnector.getBookById(authorization, id);
    }

    @PostMapping
    public Book saveBook(@RequestHeader("Authorization") String authorization, @RequestBody Book book) {
        return bookServiceConnector.saveBook(authorization, book);
    }

    @PutMapping()
    public Book updateBook(@RequestHeader("Authorization") String authorization, @RequestBody Book book) {
        return bookServiceConnector.updateBook(authorization, book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook(@RequestHeader("Authorization") String authorization, @PathVariable String id) {
        return bookServiceConnector.deleteBookById(authorization, id);
    }
}
