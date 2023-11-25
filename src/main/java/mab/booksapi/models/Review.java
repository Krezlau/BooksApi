package mab.booksapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "review_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
