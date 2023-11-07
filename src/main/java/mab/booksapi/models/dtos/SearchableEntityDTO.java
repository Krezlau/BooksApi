package mab.booksapi.models.dtos;

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
public class SearchableEntityDTO {
    private String url;
    private String id;
    private String searchableProperty;
    private String description;
    private double rating;
    private int reviewCount;
    private String author;
    private String title;
    
    public static SearchableEntityDTO fromBook(Book book) {
        Author author = book.getAuthor();
        int reviewsCount = book.getReviews().size();
        double rating = 0;
        for (var review : book.getReviews()) {
            rating += review.getRating();
        }
        if (reviewsCount > 0)
            rating = rating/reviewsCount;
        return SearchableEntityDTO.builder()
                .url("book-catalog")
                .id(book.getId().toString())
                .searchableProperty(book.getTitle() + " " + author.getName() + " " + author.getSurname())
                .title(book.getTitle())
                .description(book.getSynopsis())
                .rating(rating)
                .reviewCount(reviewsCount)
                .author(author.getName() + " " + author.getSurname())
                .build();
    }
    
    public static SearchableEntityDTO fromAuthor(Author author) {
        return SearchableEntityDTO.builder()
                .url("author-catalog")
                .id(author.getId().toString())
                .author(author.getName() + " " + author.getSurname())
                .searchableProperty(author.getName() + " " + author.getSurname())
                .description(author.getAbout())
                .build();
    }
}
