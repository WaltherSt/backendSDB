package sazondelbueno.web.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sazondelbueno.web.Dto.AuthResponse;
import sazondelbueno.web.Dto.LoginRequest;
import sazondelbueno.web.Model.Account;
import sazondelbueno.web.Repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AccountRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        AuthResponse response = null;
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            UserDetails user = repository.findByEmail(request.getEmail()).orElseThrow();
            String token = jwtService.getToken(user);
            response=  AuthResponse.builder()
                    .token(token)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public AuthResponse register(Account request) {

        Account user = Account.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .date_of_birth(request.getDate_of_birth())
                .email(request.getEmail())
                .build();

        repository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}