package mab.booksapi.models.dtos;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.models.Author;
import mab.booksapi.models.Book;
import mab.booksapi.models.Tag;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCardDTO {
    private String id;
    private String author;
    private String authorId;
    private String title;
    private String synopsis;
    private double rating;
    @Nullable private String cover;
    private List<String> tags;

    public static BookCardDTO fromBook(Book book) {
        Author author = book.getAuthor();
        List<Tag> tags = book.getTags();
        return BookCardDTO.builder()
                .id(book.getId().toString())
                .author(author.getName() + " " + author.getSurname())
                .authorId(author.getId().toString())
                .title(book.getTitle())
                .synopsis(book.getSynopsis())
                .rating(book.getRating())
                .cover(book.getCover())
                .tags(tags.stream().map(Tag::getName).toList())
                .build();
    }
}