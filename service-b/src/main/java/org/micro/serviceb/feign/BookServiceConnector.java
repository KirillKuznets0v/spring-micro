package org.micro.serviceb.feign;

import org.micro.serviceb.fallback.BookServiceConnector.BookServiceConnectorFallbackFactory;
import org.micro.serviceb.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "api-gateway/api/books", fallbackFactory = BookServiceConnectorFallbackFactory.class)
public interface BookServiceConnector {
    @GetMapping
    List<Book> getAllBooks(@RequestHeader("Authorization") String authorization);

    @GetMapping("{id}")
    Book getBookById(@RequestHeader("Authorization") String authorization, @PathVariable String id);

    @PostMapping
    Book saveBook(@RequestHeader("Authorization") String authorization, Book book);

    @PutMapping()
    Book updateBook(@RequestHeader("Authorization") String authorization, Book book);

    @DeleteMapping("{id}")
    ResponseEntity<HttpStatus> deleteBookById(@RequestHeader("Authorization") String authorization, @PathVariable String id);
}

