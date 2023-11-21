package mab.booksapi.repositories;

import mab.booksapi.models.Comment;
import mab.booksapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICommentRepository extends JpaRepository<Comment, UUID> {
    public List<Comment> findAllByReview(Review review);
}
