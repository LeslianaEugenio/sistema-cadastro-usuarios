package com.example.backend.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//configurções gerais do projecto
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa proteção CSRF (não necessária para testes com Postman)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Libera acesso a todos os endpoints
                );
        return http.build();
    }
}


