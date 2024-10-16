package com.medilabo.diagnosis_notes.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static final String SECRET = "9F44D4C546D4DA5B4mldkvmdjmwdjvmqlkdvqùlvùV%kjB4D9898881F3";

    private SecretKey generateKey() {
//        byte[] decodedKey = Base64.getDecoder().decode(SECRET);
//        return Keys.hmacShaKeyFor(decodedKey);
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // Parse and validate the token
    public Claims extractClaims(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims;
    }



    public String extractUsername(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    // Check token expiration
    public boolean isTokenExpired(String token) {
        Claims claims = extractClaims(token);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }

    // creation d'un objet Authentication à partir du JWT token en renvoyant un UsernamePasswordAuthenticationToken
    public Authentication getAuthentication(String token) {
        Claims claims = extractClaims(token);
        String username = claims.getSubject();

        //recuperer roles dans token

        return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
    }

}
