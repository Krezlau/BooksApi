package mab.booksapi.repositories;

import mab.booksapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IBooksRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByRatingIsGreaterThan(double rating);
}

