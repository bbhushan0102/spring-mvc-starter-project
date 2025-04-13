package org.studyeasy.SpringStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {
    private static final String[] WHITELIST ={
        "/",
        "/login",
        "/register",
        "/db-console/**",
        "/css/**",
        "/fonts/**",
        "/images/**",
        "/js/**",
    };

    
    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(WHITELIST).
            permitAll()
            .anyRequest()
            .authenticated()
        )
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/db-console/**")
        )
        .headers(headers -> headers
            .frameOptions().sameOrigin()
        );

    return http.build();
}

    
}
