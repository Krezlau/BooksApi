package mab.booksapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mab.booksapi.models.Requests.LoginRequest;
import mab.booksapi.models.Requests.RegisterRequest;
import mab.booksapi.models.Responses.AuthenticationResponse;
import mab.booksapi.models.exceptions.AuthException;
import mab.booksapi.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        try {
            return ResponseEntity.ok(authenticationService.register(registerRequest));
        }
        catch (AuthException e) {
            return ResponseEntity.badRequest().body(AuthenticationResponse.builder()
                                                    .errorMessage(e.getMessage())
                                                    .build());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(AuthenticationResponse.builder()
                                                    .errorMessage("Something went wrong")
                                                    .build());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(authenticationService.login(loginRequest));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(AuthenticationResponse.builder()
                                                    .errorMessage("Invalid username or password")
                                                    .build());
        }
    }
}
