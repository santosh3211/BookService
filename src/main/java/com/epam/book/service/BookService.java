package com.epam.book.service;

import com.epam.book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    List<Book> addBooks(List<Book> books);

    Book addBook(Book book);

    Book update(Long bookId, Book book);

    Book findByBookId(Long bookId);

    void removeBook(Long bookId);
}
