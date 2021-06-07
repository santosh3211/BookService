package com.epam.book.controllers;

import com.epam.book.model.Book;
import com.epam.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookapi")
public class BookRestController {
    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        logger.info("Fetching books from database");
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
    }

    @GetMapping(value = "/books/{book_id}")
    public ResponseEntity<?> getBookById(@PathVariable("book_id") Long bookId) {
        logger.info("Fetching book by Id from book database");
        Optional<Book> bookRetrived = Optional.ofNullable(bookService.findByBookId(bookId));
        return new ResponseEntity<Optional<Book>>(bookRetrived, HttpStatus.OK);
    }

    @PostMapping(value = "/books")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books) {
        logger.info("Bulk book addition started..");
        List<Book> bookList = bookService.addBooks(books);
        return new ResponseEntity<List<Book>>(bookList, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/books/{book_id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("book_id") Long bookiId) {
        logger.info("Remove book by id : " + bookiId);
        bookService.removeBook(bookiId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/books/{book_id}")
    public ResponseEntity<Book> updateBook(@PathVariable("book_id") Long bookId, @RequestBody Book book) {
        logger.info("Updating book by id : " + bookId);
        Book bookSaved = bookService.update(bookId, book);
        return new ResponseEntity<Book>(bookSaved, HttpStatus.CREATED);
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        logger.info("Add a book started..");
        Book bookAdded = bookService.addBook(book);
        return new ResponseEntity<Book>(bookAdded, HttpStatus.CREATED);
    }

}
