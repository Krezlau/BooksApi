package mab.booksapi.services;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.models.Author;
import mab.booksapi.models.dtos.AuthorBookDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {
    private String id;
    private String name;
    private String surname;
    private String about;
    @Nullable private String photo;
    private List<AuthorBookDTO> books;

    public static AuthorDTO fromAuthor(Author author) {
        return AuthorDTO.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .surname(author.getSurname())
                .about(author.getAbout())
                .photo(author.getPhoto())
                .books(author.getBooks().stream().map(AuthorBookDTO::fromBook).toList())
                .build();
    }
}
