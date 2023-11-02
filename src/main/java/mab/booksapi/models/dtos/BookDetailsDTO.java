package mab.booksapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.models.Book;
import mab.booksapi.models.Tag;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsDTO {
    private String id;
    private String author;
    private String authorId;
    private String aboutAuthor;
    private String title;
    private String synopsis;
    private String funFacts;
    private String cover;
    private List<String> tags;

    public static BookDetailsDTO fromBook(Book book) {
        return BookDetailsDTO.builder()
                .id(book.getId().toString())
                .author(book.getAuthor().getName())
                .authorId(book.getAuthor().getId().toString())
                .aboutAuthor(book.getAuthor().getAbout())
                .title(book.getTitle())
                .synopsis(book.getSynopsis())
                .funFacts(book.getFunFacts())
                .cover(book.getCover())
                .tags(book.getTags().stream().map(Tag::getName).toList())
                .build();
    }
}
