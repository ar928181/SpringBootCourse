package com.example.rest.webservices.restful_web_services.user;

import com.example.rest.webservices.restful_web_services.user.JPA.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
