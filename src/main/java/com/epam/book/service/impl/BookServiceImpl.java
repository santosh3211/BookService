package com.epam.book.service.impl;

import com.epam.book.exception.EmptyInputException;
import com.epam.book.model.Book;
import com.epam.book.repos.BookRepository;
import com.epam.book.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @Override
    public Book addBook(Book book) {
        if (StringUtils.isEmpty(book.getBookName()) || StringUtils.isEmpty(book.getBookAuther())) {
            throw new EmptyInputException("400", "Input Fields are empty");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long bookId, Book book) {
        if (StringUtils.isEmpty(book.getBookName()) || StringUtils.isEmpty(book.getBookAuther())) {
            throw new EmptyInputException("400", "Input Fields are empty");
        }
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        existingBook.setBookAuther(book.getBookAuther());
        existingBook.setBookName(book.getBookName());
        return bookRepository.save(existingBook);
    }

    @Override
    public Book findByBookId(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public void removeBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
