package com.example.rest.webservices.restful_web_services.user;

import com.example.rest.webservices.restful_web_services.user.JPA.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return userDaoService.findAll();
    }
    @GetMapping("/users/{id}")
    public User retriveOneUser(@PathVariable int id) {
      User  user = userDaoService.findOne(id);
      if (user == null)
      {
          throw new UserNotFoundException("User not found");
      }
       else
           return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDaoService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).build();
    }
}
