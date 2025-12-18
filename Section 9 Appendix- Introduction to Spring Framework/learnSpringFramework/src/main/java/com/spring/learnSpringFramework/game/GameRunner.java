package com.spring.learnSpringFramework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    @Autowired
    private GameConsole game;
//    public GameRunner() {
//        this.game = game;
//        System.out.println("Game Runner Default Constructor");
//    }
    public GameRunner(GameConsole game) {
        this.game = game;
        System.out.println("Game Runner Paramterized Constructor");
    }

    public void run() {
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
