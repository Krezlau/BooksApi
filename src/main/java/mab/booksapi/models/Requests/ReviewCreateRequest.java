package mab.booksapi.models.Requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mab.booksapi.validation.RatingConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCreateRequest {

    @NotBlank(message = "Content is required")
    private String content;

    @RatingConstraint
    private double rating;
}
