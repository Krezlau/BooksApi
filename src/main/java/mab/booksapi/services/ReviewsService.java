package mab.booksapi.services;

import lombok.AllArgsConstructor;
import mab.booksapi.models.Book;
import mab.booksapi.models.Requests.ReviewCreateRequest;
import mab.booksapi.models.Review;
import mab.booksapi.models.User;
import mab.booksapi.models.dtos.ReviewDTO;
import mab.booksapi.repositories.IReviewRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReviewsService {

    private final IReviewRepository reviewRepository;

    public List<ReviewDTO> getReviewsByBookId(String bookId, Pageable pageable) {
        return reviewRepository.getReviewsByBook_Id(UUID.fromString(bookId), pageable).stream().map(ReviewDTO::fromReview).toList();
    }

    public ReviewDTO saveReview(ReviewCreateRequest review, UUID userId, String bookId) {
        return ReviewDTO.fromReview(reviewRepository.save(Review.builder()
                .user(User.builder().id(userId).build())
                .content(review.getContent())
                .book(Book.builder().id(UUID.fromString(bookId)).build())
                .rating(review.getRating())
                .build()));
    }

}
