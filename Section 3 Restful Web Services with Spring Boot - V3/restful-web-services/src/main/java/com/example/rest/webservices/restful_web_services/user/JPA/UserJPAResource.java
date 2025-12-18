package com.example.rest.webservices.restful_web_services.user.JPA;

import com.example.rest.webservices.restful_web_services.user.UserDaoService;
import com.example.rest.webservices.restful_web_services.user.UserNotFoundException;
import com.example.rest.webservices.restful_web_services.user.UserRepository;
import com.example.rest.webservices.restful_web_services.user.post.Post;
import com.example.rest.webservices.restful_web_services.user.post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/jpa")
public class UserJPAResource {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public UserJPAResource(UserRepository userRepository,PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User retriveOneUser(@PathVariable int id) {
      User  user = userRepository.findById(id).orElse(null);
      if (user == null)
      {
          throw new UserNotFoundException("User not found");
      }
       else
           return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPostOfUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            throw new UserNotFoundException("User not found");
        }
        Logger.getLogger(UserJPAResource.class.getName()).log(Level.INFO, "getAllPostOfUser : \n",user.get().getPosts());
            return user.get().getPosts();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).build();
    }
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createUserPost(@Valid @RequestBody Post post, @PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            throw new UserNotFoundException("User not found");
        }
        post.setUser(user.get());
        Post savedPost=postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(null).build();
    }
}
