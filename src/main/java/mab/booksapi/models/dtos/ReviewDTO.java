package mab.booksapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.models.Comment;
import mab.booksapi.models.Review;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private String id;
    private String userId;
    private String username;
    private String content;
    private double rating;
    private int commentsCount;

    public static ReviewDTO fromReview(Review review) {
        int commentsCount = review.getComments() != null ? review.getComments().size() : 0;
        return ReviewDTO.builder()
                .rating(review.getRating())
                .id(review.getId().toString())
                .userId(review.getUser().getId().toString())
                .username(review.getUser().getUsername())
                .content(review.getContent())
                .commentsCount(commentsCount)
                .build();
    }
}
