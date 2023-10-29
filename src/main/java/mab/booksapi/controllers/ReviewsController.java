package mab.booksapi.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import mab.booksapi.config.JwtService;
import mab.booksapi.models.Requests.ReviewCreateRequest;
import mab.booksapi.models.Review;
import mab.booksapi.models.User;
import mab.booksapi.models.dtos.ReviewDTO;
import mab.booksapi.repositories.IUserRepository;
import mab.booksapi.services.ReviewsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ReviewsController {

   private final ReviewsService reviewsService;
   private final JwtService jwtService;
   private final IUserRepository userRepository;

    @GetMapping("/books/{bookId}/reviews")
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

   @PostMapping("/books/{bookId}/reviews")
    public ResponseEntity<ReviewDTO> postReview(@PathVariable String bookId, @RequestBody ReviewCreateRequest review, HttpServletRequest request) {
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
}
