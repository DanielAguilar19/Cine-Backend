package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*"); // Permitir cualquier origen
        config.addAllowedHeader("*"); // Permitir cualquier encabezado
        config.addAllowedMethod("*"); // Permitir cualquier método (GET, POST, etc.)
        config.setAllowCredentials(true); // Permitir el uso de credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}