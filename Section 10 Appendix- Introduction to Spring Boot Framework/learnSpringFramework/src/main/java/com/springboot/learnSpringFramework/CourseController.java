package com.springboot.learnSpringFramework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCourses(){
        return Arrays.asList(
                new Course(1,"Learn Spring","Ali Raza"),
                new Course(2,"Learn Spring Boot","Ali Raza"),
                new Course(3,"Learn Docker","Ali Raza")
        );
    }
}
