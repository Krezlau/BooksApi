package mab.booksapi.controllers;

import mab.booksapi.models.Book;
import mab.booksapi.repositories.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private IBooksRepository booksRepository;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(Book book) {
        return ResponseEntity.ok(booksRepository.save(book));
    }
}
