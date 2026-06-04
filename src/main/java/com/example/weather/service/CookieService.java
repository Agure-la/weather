package com.example.weather.service;


import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CookieService {
    public Cookie createCookie(String jwt) {

        Cookie cookie = new Cookie("JWT_TOKEN", jwt);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60); // 1 hour
        return cookie;
    }

    public Cookie clearCookie() {

        Cookie cookie = new Cookie("JWT_TOKEN", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        return cookie;
    }
}
