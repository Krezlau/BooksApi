package mab.booksapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Books")
@Data
public class Book {

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "funFacts")
    private String funFacts;

    @Column(name = "rating")
    private double rating;

}
