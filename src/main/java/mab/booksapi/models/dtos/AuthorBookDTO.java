package mab.booksapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.models.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorBookDTO {
    private String id;
    private String title;
    private double rating;

    public static AuthorBookDTO fromBook(Book book) {
        return AuthorBookDTO.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .rating(book.getRating())
                .build();
    }
}
