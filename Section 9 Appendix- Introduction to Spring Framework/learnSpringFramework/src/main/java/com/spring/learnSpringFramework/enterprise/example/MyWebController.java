package com.spring.learnSpringFramework.enterprise.example;

import com.spring.learnSpringFramework.enterprise.example.web.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    @Autowired
    private BusinessService businessService;
    public  long returnValueFromBusinessService(){
        return businessService.calculateSum();
    }
}



