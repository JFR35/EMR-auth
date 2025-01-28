package com.securitybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authProvider;

    public SecurityConfig(AuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF si no es necesario
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login").permitAll() // Permitir acceso al endpoint /api/login
                        .requestMatchers("/api/register").permitAll()
                        .anyRequest().authenticated() // Proteger el resto de los endpoints
                )
                .authenticationProvider(authProvider) // Agregar el AuthenticationProvider
                .build();
    }
}
