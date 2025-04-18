package org.studyeasy.SpringBlog.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
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
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @SuppressWarnings("removal")
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(WHITELIST).
            permitAll()
            .anyRequest()
            .authenticated()  
        )
        .formLogin(form -> form
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .usernameParameter("email")
        .passwordParameter("password")
        .defaultSuccessUrl("/", true)
        .failureUrl("/login?error")
        .permitAll()
        )

        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
        )

        .httpBasic(Customizer.withDefaults())

        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/db-console/**")
        )
        .headers(headers -> headers
            .frameOptions().sameOrigin()
        );

    return http.build();
}

    
}
