package mab.booksapi.controllers;

import lombok.AllArgsConstructor;
import mab.booksapi.services.AuthorDTO;
import mab.booksapi.services.AuthorsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorsController {

    private final AuthorsService authorsService;

    @GetMapping("/")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "5") int size) {
        try {
            return ResponseEntity.ok(authorsService.getAllAuthors(PageRequest.of(page, size)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
