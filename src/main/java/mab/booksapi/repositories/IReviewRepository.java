package mab.booksapi.repositories;

import mab.booksapi.models.Book;
import mab.booksapi.models.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IReviewRepository extends JpaRepository<Review, UUID> {

    List<Review> getReviewsByBook_Id(UUID bookId, Pageable pageable);

}
