package mab.booksapi.controllers;

import lombok.AllArgsConstructor;
import mab.booksapi.models.dtos.SearchableEntityDTO;
import mab.booksapi.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {
    
    private final SearchService searchService;
    
    @GetMapping("")
    public ResponseEntity<List<SearchableEntityDTO>> search(@RequestParam String query) {
        return ResponseEntity.ok().body(searchService.search(query));
    }
}
