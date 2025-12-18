package com.spring.learnSpringFramework.enterprise.example.web;

import com.spring.learnSpringFramework.enterprise.example.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService{
    @Autowired
    private DataService dataService;
    public long calculateSum()
    {
        return dataService.getData().stream().reduce(Integer::sum).get();
    }
}