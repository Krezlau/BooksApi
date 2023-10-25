package mab.booksapi.repositories;

import mab.booksapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IBooksReposity extends JpaRepository<Book, UUID> {
    List<Book> findAllBooks();
}
