package com.oficinamecanica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF (Cross-Site Request Forgery) para endpoints específicos
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF globalmente (opcional, apenas para desenvolvimento)
                .authorizeHttpRequests(auth -> auth
                        // Libera acesso público ao H2 Console e ao Swagger
                        .requestMatchers("/h2-console/**").permitAll() // H2 Console
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll() // Swagger
                        .requestMatchers("/api/public/**").permitAll() // Endpoints públicos (se houver)

                        // Exige autenticação para todos os outros endpoints
                        .anyRequest().authenticated()
                )
                // Configurações específicas para o H2 Console
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // Permite frames (necessário para o H2 Console)
                )
                // Configurações de autenticação básica (opcional)
                .httpBasic(httpBasic -> {}) // Habilita autenticação básica (usuário/senha)
                .formLogin(formLogin -> {}); // Habilita login por formulário (opcional)

        return http.build();
    }
}