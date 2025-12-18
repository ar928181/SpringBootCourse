package com.example.springboot.learn_jpa_and_hibernate.course.jdbc;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseSpringDataJPARepository extends JpaRepository<Course,Long> {


}
