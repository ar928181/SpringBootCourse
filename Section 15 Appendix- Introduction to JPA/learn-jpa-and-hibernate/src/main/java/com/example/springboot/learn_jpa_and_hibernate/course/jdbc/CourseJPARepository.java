package com.example.springboot.learn_jpa_and_hibernate.course.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepository  {
    @PersistenceContext
    private EntityManager em;
    public void insert(Course course) {
        em.merge(course);
    }

    public Course findById(long id) {
        return em.find(Course.class, id);
    }
    public void deleteById(long id) {
         em.remove(em.find(Course.class,id));
    }

}
