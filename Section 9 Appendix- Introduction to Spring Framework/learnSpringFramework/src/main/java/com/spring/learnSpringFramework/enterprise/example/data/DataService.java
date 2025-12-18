package com.spring.learnSpringFramework.enterprise.example.data;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DataService {
    public List<Integer> getData() {
        return Arrays.asList(10, 20, 30, 40);
    }
}
