package com.medilabo.diagnosis_notes.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class SpringSecurityConfig {


    @Autowired
    JwtAuthenticationFilter3 jwtAuthenticationWebFilter;

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http
                //csrf desactivé car basé sur des sessions.
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        /**
                         * Regles d'authentification : accès à l'appli
                         */

                        .anyRequest().authenticated()
                )
                //                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())  // This disables session management
//                .sessionManagement(sessionManagementCustomizer -> sessionManagementCustomizer
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
                //UsernamePasswordAuthenticationFilter est le filtre par defaut de spring security pour .authenticated()
                .addFilterBefore(jwtAuthenticationWebFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
