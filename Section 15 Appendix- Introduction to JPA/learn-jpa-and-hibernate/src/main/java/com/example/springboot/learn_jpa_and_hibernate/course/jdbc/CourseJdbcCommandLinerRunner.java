package com.example.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLinerRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository courseJdbcRepository;
   @Autowired
    private CourseJPARepository courseJPARepository;
    @Autowired
    private CourseSpringDataJPARepository courseSpringDataJPARepository;
    @Override
    public void run(String... args) throws Exception {

        //***********Using Spring JDBC******///
//    courseJdbcRepository.insert(new Course(1,"Learning AWS","Ali"));
//    courseJdbcRepository.insert(new Course(2,"Learning AWS","Ali"));
//    courseJdbcRepository.insert(new Course(3,"Learning AWS","Ali"));
//    courseJdbcRepository.insert(new Course(4,"Learning AWS","Ali"));
//    courseJdbcRepository.delete(4);
//    System.out.println(courseJdbcRepository.findById(2))


        // ***********Using Spring JPA******///
//        courseJPARepository.insert(new Course(1,"Learning AWS JPA","Ali"));
//        courseJPARepository.insert(new Course(2,"Learning AWS JPA","Ali"));
//        courseJPARepository.insert(new Course(3,"Learning AWS JPA","Ali"));
//        courseJPARepository.insert(new Course(4,"Learning AWS JPA","Ali"));
//        courseJPARepository.deleteById(4);
//        System.out.println(courseJPARepository.findById(2));
//
        // ***********Using Spring JPA******///


        courseSpringDataJPARepository.save(new Course(1,"Learning AWS JPA","Ali"));
        courseSpringDataJPARepository.save(new Course(2,"Learning AWS JPA","Ali"));
        courseSpringDataJPARepository.save(new Course(3,"Learning AWS JPA","Ali"));
        courseSpringDataJPARepository.save(new Course(4,"Learning AWS JPA","Ali"));
        courseSpringDataJPARepository.deleteById(4l);
        System.out.println(courseSpringDataJPARepository.findById(2l));
        System.out.println("ALL COURSES \n"+ courseSpringDataJPARepository.findAll());

    }
}
