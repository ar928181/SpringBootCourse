package com.spring.learnSpringFramework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GameConsole{
    public MarioGame()
    {
        System.out.println("MarioGame Default Constructor");
    }
    public void up(){
        System.out.println("Mario UP");
    }
    public void down(){
        System.out.println("Mario DOWN");
    }
    public void left(){
        System.out.println("Mario LEFT");
    }
    public void right(){
        System.out.println("Mario RIGHT");
    }
}
