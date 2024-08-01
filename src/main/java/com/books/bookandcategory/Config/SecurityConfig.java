package com.books.bookandcategory.Config;


import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {


    @Bean
    public SecuityFilterChain secuityFilterChain(HttpSession session) {

    }
}
