package com.securitybasic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS en todas las rutas
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5200") // Aquí pones la URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("Authorization", "Content-Type", "X-Requested-With")
                .allowCredentials(true); // Si es necesario permitir cookies/autenticación
    }
}
