package mab.booksapi.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mab.booksapi.models.dtos.AuthorDTO;
import mab.booksapi.repositories.IAuthorRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorsService {

    private final IAuthorRepository authorRepository;

    @Transactional
    public List<AuthorDTO> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).map(AuthorDTO::fromAuthor).toList();
    }
}
