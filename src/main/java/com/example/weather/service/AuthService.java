package com.example.weather.service;

import com.example.weather.dto.request.LoginRequest;
import com.example.weather.entity.User;
import com.example.weather.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CookieService cookieService;
    private final UserRepository userRepository;

    public Cookie login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );

        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Invalid credentials");
        }

        String username = authentication.getName();

        String jwt = jwtService.generateToken(username);

        return cookieService.createCookie(jwt);
    }

    public Cookie logout() {
        return cookieService.clearCookie();
    }
}
