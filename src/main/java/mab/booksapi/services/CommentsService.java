package mab.booksapi.services;

import lombok.AllArgsConstructor;
import mab.booksapi.models.Comment;
import mab.booksapi.models.Review;
import mab.booksapi.models.User;
import mab.booksapi.models.dtos.CommentCreateDTO;
import mab.booksapi.models.dtos.CommentDTO;
import mab.booksapi.repositories.ICommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentsService {
    private final ICommentRepository commentRepository;
    
    public List<CommentDTO> fetchCommentsForReview(UUID reviewId){
        Review review = Review.builder().id(reviewId).build();
        List<Comment> lc = commentRepository.findAllByReview(review);
        return lc.stream().map(CommentDTO::fromComment).toList();
    }

    public Comment CreateComment(CommentCreateDTO comment, UUID userId) {
        return commentRepository.save(Comment.builder()
                        .user(User.builder().id(userId).build())
                        .review(Review.builder().id(comment.getReviewId()).build())
                        .content(comment.getContent())
                        .build());
    }
}
