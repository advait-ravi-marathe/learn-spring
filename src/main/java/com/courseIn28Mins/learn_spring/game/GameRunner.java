package com.courseIn28Mins.learn_spring.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole gamingConsole;

    //Passing qualifier to mention that ContraGame needs to be run.
    public GameRunner(@Qualifier("contraGame") GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

    public void run() {
        System.out.println("Running game: " + gamingConsole);
        gamingConsole.up();
        gamingConsole.down();
        gamingConsole.left();
        gamingConsole.right();
    }
}
