package mab.booksapi.services;

import lombok.RequiredArgsConstructor;
import mab.booksapi.config.JwtService;
import mab.booksapi.models.Requests.LoginRequest;
import mab.booksapi.models.Requests.RegisterRequest;
import mab.booksapi.models.Responses.AuthenticationResponse;
import mab.booksapi.models.Role;
import mab.booksapi.models.User;
import mab.booksapi.models.exceptions.AuthException;
import mab.booksapi.repositories.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) throws AuthException {
        var user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        // check if user with that username already exists
        var userWithTheSameUsername = repository.findByUsername(user.getUsername());
        if (userWithTheSameUsername.isPresent()) {
            throw new AuthException("User with that username already exists");
        }
        // check if user with that email already exists
        var userWithTheSameEmail = repository.findByEmail(user.getEmail());
        if (userWithTheSameEmail.isPresent()) {
            throw new AuthException("User with that email already exists");
        }
        // save user
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .build();
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        var user = repository.findByUsername(loginRequest.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .build();
    }
}
