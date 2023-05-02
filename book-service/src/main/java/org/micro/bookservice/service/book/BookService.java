package org.micro.bookservice.service.book;

import org.micro.bookservice.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(String id);

    Book save(Book book);

    Book update(Book updatedBook);

    void deleteById(String id);
}
