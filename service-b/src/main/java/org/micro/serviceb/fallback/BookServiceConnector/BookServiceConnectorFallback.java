package org.micro.serviceb.fallback.BookServiceConnector;

import org.micro.serviceb.feign.BookServiceConnector;
import org.micro.serviceb.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BookServiceConnectorFallback implements BookServiceConnector {

    @Override
    public List<Book> getAllBooks(String authorization) {
        return Collections.emptyList();
    }

    @Override
    public Book getBookById(String authorization, String id) {
        return null;
    }

    @Override
    public Book saveBook(String authorization, Book book) {
        return null;
    }

    @Override
    public Book updateBook(String authorization, Book book) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteBookById(String authorization, String id) {
        return null;
    }
}
