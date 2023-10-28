package mab.booksapi.repositories;

import mab.booksapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAuthorRepository extends JpaRepository<Author, UUID> {
}
