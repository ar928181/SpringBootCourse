package com.example.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Steps to define here

        //        1- All requests should be authenticated
        http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests.anyRequest().authenticated());
        //       2-if a request is not authenticated, a web page is shown
        http.httpBasic(withDefaults());
        //       3- CSRF -> POST, PUT, DELETE
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
