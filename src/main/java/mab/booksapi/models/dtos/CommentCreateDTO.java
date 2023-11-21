package mab.booksapi.models.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentCreateDTO {
    private UUID reviewId;
    @Size(min = 1, max = 1024)
    private String content;
}
