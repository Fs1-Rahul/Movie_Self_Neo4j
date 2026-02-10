package com.example.MiniProject;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
 
import static org.springframework.security.config.Customizer.withDefaults;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing with Postman
            .authorizeHttpRequests(auth -> auth
                // Allow both USER and ADMIN to view movies
                .requestMatchers(HttpMethod.GET, "/movies/**").hasAnyRole("USER", "ADMIN")
                
                // Only allow ADMIN to add or delete movies
                .requestMatchers(HttpMethod.POST, "/movies/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/movies/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/movies/**").hasRole("ADMIN")
                
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); // Use Basic Auth for Postman testing
            
        return http.build();
    }
 
    @Bean
    public UserDetailsService userDetailsService() {
        // Creating in-memory users for your project
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
 
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin123")
            .roles("ADMIN")
            .build();
 
        return new InMemoryUserDetailsManager(user, admin);
    }
}