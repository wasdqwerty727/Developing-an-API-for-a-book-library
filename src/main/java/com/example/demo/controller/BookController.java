package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/filter")
    public List<Book> filterBooks(@RequestParam Long authorId) {
        return bookService.filterBooksByAuthor(authorId);
    }
}
