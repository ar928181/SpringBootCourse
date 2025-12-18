package com.spring.learnSpringFramework.game;

import org.springframework.stereotype.Component;

@Component
public interface GameConsole {
   public void up();
    public void down();
    public void left();
    public void right();
}
