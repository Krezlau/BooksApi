package mab.booksapi.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import mab.booksapi.config.JwtService;
import mab.booksapi.models.Comment;
import mab.booksapi.models.User;
import mab.booksapi.models.dtos.CommentCreateDTO;
import mab.booksapi.models.dtos.CommentDTO;
import mab.booksapi.repositories.IUserRepository;
import mab.booksapi.services.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.cert.TrustAnchor;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {
    private final CommentsService commentsService;
    private final JwtService jwtService;
    private final IUserRepository userRepository;
    
    @GetMapping("/by-review/{reviewId:uuid}")
    public ResponseEntity<List<CommentDTO>> GetCommentsForReview(@PathVariable UUID reviewId) {
        try
        {
            List<CommentDTO> comments = commentsService.fetchCommentsForReview(reviewId);
            return ResponseEntity.ok(comments);
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    } 
    
    @PostMapping("")
    public ResponseEntity<UUID> PostComment(@RequestBody CommentCreateDTO comment, HttpServletRequest request){
        try {
            String username = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            User user = userRepository.findByUsername(username).orElseThrow();
            Comment createdComment = commentsService.CreateComment(comment, user.getId());
            return ResponseEntity.created(URI.create(createdComment.getId().toString())).build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id:uuid}")
    public ResponseEntity<UUID> PostComment(@PathVariable UUID id, HttpServletRequest request){
        try {
            String username = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            commentsService.DeleteComment(id, username);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
