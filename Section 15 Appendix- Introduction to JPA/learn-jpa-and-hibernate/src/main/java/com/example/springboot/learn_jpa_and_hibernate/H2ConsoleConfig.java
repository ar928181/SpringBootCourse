package com.example.springboot.learn_jpa_and_hibernate;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.servlet.Servlet;

@Configuration
public class H2ConsoleConfig {

    @Bean
    @Profile("!prod")
    public ServletRegistrationBean<Servlet> h2ConsoleServletRegistration() {
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>();
        try {
            Class<?> webServletClass = Class.forName("org.h2.server.web.JakartaWebServlet");
            Servlet servlet = (Servlet) webServletClass.getDeclaredConstructor().newInstance();
            registration.setServlet(servlet);
        } catch (Exception e) {
            try {
                // Fallback for older H2 versions
                Class<?> webServletClass = Class.forName("org.h2.server.web.WebServlet");
                Servlet servlet = (Servlet) webServletClass.getDeclaredConstructor().newInstance();
                registration.setServlet(servlet);
            } catch (Exception ex) {
                throw new RuntimeException("Unable to load H2 console servlet", ex);
            }
        }
        registration.addUrlMappings("/h2-console/*");
        registration.setName("H2Console");
        return registration;
    }
}

