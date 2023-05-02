package org.micro.bookservice.service.book.impl;

import lombok.AllArgsConstructor;
import org.micro.bookservice.model.Book;
import org.micro.bookservice.repository.BookRepository;
import org.micro.bookservice.service.book.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book updatedBook) {
        return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}
