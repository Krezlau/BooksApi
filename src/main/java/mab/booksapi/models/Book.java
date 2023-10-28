package mab.booksapi.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyGroup;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "title")
    private String title;

    @Column(name = "synopsis", length = 1000)
    private String synopsis;

    @Column(name = "fun_facts", length = 1000)
    private String funFacts;

    @Column(name = "rating")
    private double rating;

    @Column(name = "cover", length = 1000)
    @Nullable
    private String cover;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Books_Tags",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
