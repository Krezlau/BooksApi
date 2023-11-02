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
    private int reviewCount;

    public static AuthorBookDTO fromBook(Book book) {
        int reviewsCount = book.getReviews().size();
        double rating = 0;
        for (var review : book.getReviews()) {
            rating += review.getRating();
        }
        if (reviewsCount > 0)
            rating = rating/reviewsCount;
        return AuthorBookDTO.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .rating(rating)
                .reviewCount(reviewsCount)
                .build();
    }
}
