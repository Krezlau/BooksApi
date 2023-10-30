package mab.booksapi.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mab.booksapi.config.JwtService;
import mab.booksapi.models.Requests.ReviewCreateRequest;
import mab.booksapi.models.Review;
import mab.booksapi.models.User;
import mab.booksapi.models.dtos.ReviewDTO;
import mab.booksapi.repositories.IUserRepository;
import mab.booksapi.services.ReviewsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewsController {

   private final ReviewsService reviewsService;
   private final JwtService jwtService;
   private final IUserRepository userRepository;

    @GetMapping("/by-book/{bookId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsForBook(@PathVariable String bookId,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        try {
          return ResponseEntity.ok(reviewsService.getReviewsByBookId(bookId, PageRequest.of(page, size)));
      }
      catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
   }

   @PostMapping("/by-book/{bookId}")
    public ResponseEntity<ReviewDTO> postReview(@PathVariable String bookId,
                                                @Valid @RequestBody ReviewCreateRequest review,
                                                HttpServletRequest request) {
      try {
          String username = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
          User user = userRepository.findByUsername(username).orElseThrow();
          ReviewDTO newReview = reviewsService.saveReview(review, user.getId(), bookId);
          return ResponseEntity.created(URI.create(newReview.getId())).build();
      }
      catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
   }

   @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable String reviewId,
                                               HttpServletRequest request) {
       // check if user is the owner of the review
       try {
           String username = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
           User user = userRepository.findByUsername(username).orElseThrow();

           Review review = reviewsService.getReviewById(reviewId);
           if (review.getUser().getId() != user.getId()) {
               return ResponseEntity.badRequest().build();
           }
           reviewsService.deleteReview(review);
           return ResponseEntity.ok().build();
       }
       catch (Exception e) {
              return ResponseEntity.badRequest().build();
       }
   }
}
