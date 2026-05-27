package com.carlos.reuniones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
    
                .requestMatchers("/api/**")
                .hasRole("API_USER")

                .requestMatchers("/login")
                .permitAll()

                .anyRequest()
                .authenticated()

            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/reuniones", true)
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService( 
        PasswordEncoder passwordEncoder
    ) {
        UserDetails usuario1 = User.builder()
            .username("granJefe")
            .password(passwordEncoder.encode("ssshhh"))
            .roles("USER", "API_USER")
            .build();

        UserDetails usuario2 = User.builder()
            .username("currito")
            .password(passwordEncoder.encode("pasapasa"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(
            usuario1,
            usuario2
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}