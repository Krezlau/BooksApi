package mab.booksapi.controllers;

import lombok.AllArgsConstructor;
import mab.booksapi.models.dtos.BookCardDTO;
import mab.booksapi.models.dtos.BookDetailsDTO;
import mab.booksapi.services.BooksService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {

    private BooksService booksService;

    @GetMapping("")
    public ResponseEntity<List<BookCardDTO>> getAllBooks(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        try {
            return ResponseEntity.ok(booksService.getAllBooks(PageRequest.of(page, size)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> getBookDetails(@PathVariable String id) {
        try {
            return ResponseEntity.ok(booksService.getBookDetails(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

//    @PostMapping("/")
//    public ResponseEntity<String> createBook(Book book) {
//        return ResponseEntity.ok("Jest w pyte.");
//    }
}
