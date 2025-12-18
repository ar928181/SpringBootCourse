package com.spring.learnSpringFramework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class PackmanGame implements GameConsole{
    public void up(){
        System.out.println("Packman UP");
    }
    public void down(){
        System.out.println("Packman DOWN");
    }
    public void left(){
        System.out.println("Packman LEFT");
    }
    public void right(){
        System.out.println("Packman RIGHT");
    }
}
