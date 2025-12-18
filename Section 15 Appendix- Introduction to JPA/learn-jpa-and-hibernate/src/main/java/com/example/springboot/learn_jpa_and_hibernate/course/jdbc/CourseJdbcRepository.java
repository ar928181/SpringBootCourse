package com.example.springboot.learn_jpa_and_hibernate.course.jdbc;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY = """
            insert into course(id,name,author)
            values(?,?,?);
            """;
    private static String DELETE_QUERY = """
            delete from course
            where id = ?;
            """;
    private static String SELECT_QUERY = """
            select * from course WHERE id = ?;
    """;
    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }
    public void delete(int id) {
        jdbcTemplate.update(DELETE_QUERY,id);
    }
    public Course findById(long id) {
       return
        jdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);

        //Result set need to be mapped to bean(course in our case) and is called Row Mapper
        //2nd param in above query helps us to map the resultset to bean
    }


}
