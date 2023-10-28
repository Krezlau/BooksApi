package mab.booksapi.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mab.booksapi.models.Book;
import mab.booksapi.models.dtos.BookCardDTO;
import mab.booksapi.models.dtos.BookDetailsDTO;
import mab.booksapi.repositories.IBooksRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BooksService {

    private final IBooksRepository booksRepository;

    @Transactional
    public List<BookCardDTO> getAllBooks(Pageable pageable) {
        return booksRepository.findAll(pageable).map(BookCardDTO::fromBook).toList();
    }

    @Transactional
    public BookDetailsDTO getBookDetails(String id) {
        Book book = booksRepository.findById(UUID.fromString(id)).orElseThrow();
        return BookDetailsDTO.fromBook(book);
    }
}
