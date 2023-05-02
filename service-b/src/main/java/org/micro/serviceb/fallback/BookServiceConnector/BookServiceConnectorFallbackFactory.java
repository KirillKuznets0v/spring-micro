package org.micro.serviceb.fallback.BookServiceConnector;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.micro.serviceb.feign.BookServiceConnector;
import org.micro.serviceb.model.Book;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BookServiceConnectorFallbackFactory implements FallbackFactory<BookServiceConnectorFallbackFactory.FallBackWithFactory> {

    @Override
    public FallBackWithFactory create(Throwable cause) {
        return new FallBackWithFactory(cause.getMessage());
    }

    @Slf4j
    @AllArgsConstructor
    static class FallBackWithFactory implements BookServiceConnector {
        private String reason;

        @Override
        public List<Book> getAllBooks(String authorization) {
            log.warn("Failed send request on book-service, reason {}", reason);
            return Collections.emptyList();
        }

        @Override
        public Book getBookById(String authorization, String id) {
            log.warn("Failed send request on book-service, reason {}", reason);
            return null;
        }

        @Override
        public Book saveBook(String authorization, Book book) {
            log.warn("Failed send request on book-service, reason {}", reason);
            return null;
        }

        @Override
        public Book updateBook(String authorization, Book book) {
            log.warn("Failed send request on book-service, reason {}", reason);
            return null;
        }

        @Override
        public ResponseEntity<HttpStatus> deleteBookById(String authorization, String id) {
            log.warn("Failed send request on book-service, reason {}", reason);
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
