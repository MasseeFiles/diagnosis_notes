package com.medilabo.diagnosis_notes.configuration;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter3 extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    //a mettre dans application.propoerties ou une variable d'environnement
    private final String jwtSecret = "9F44D4C546D4DA5B4mldkvmdjmwdjvmqlkdvqùlvùV%kjB4D9898881F3"; // Replace with your actual secret

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Get JWT from Authorization header
        String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);

        //pas de token trouvé dans la requete
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // token trouvé dans la requete
        String jwt = authHeader.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        if (jwtUtil.isTokenExpired(jwt)) {
            Authentication authentication = jwtUtil.getAuthentication(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

}
