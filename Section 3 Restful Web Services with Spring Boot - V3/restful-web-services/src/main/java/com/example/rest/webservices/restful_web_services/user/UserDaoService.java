package com.example.rest.webservices.restful_web_services.user;

import com.example.rest.webservices.restful_web_services.user.JPA.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();
    static int count = 0;
    static {
        users.add(new User(++count,"Ali", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Raza", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Umar", LocalDate.now().minusYears(30)));
    }
    public List<User> findAll(){
        return users;
    }
    //public User save(User user){};
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User createUser(User user)
    {
        users.add(new User(++count,user.getName(),user.getBirthDate()));
        return findOne(count);
    }
}
