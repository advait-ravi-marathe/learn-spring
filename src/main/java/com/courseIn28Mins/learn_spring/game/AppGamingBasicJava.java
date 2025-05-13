package com.courseIn28Mins.learn_spring.game;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        //Step 1: Creation of object
        //var game = new MarioGame();
        //var  game = new ContraGame();
        var game = new PacManGame();

        //Step 2: Wiring of dependencies
        //Here, game is a dependency for the GameRunner class
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}

/*
    Coupling: Effort involved in changing something.

    - If more effort required, code is tightly coupled
      For instance, engine is tightly coupled to the car.

    - If lesser effort required, code is loosely coupled
      For instance, wheel is loosely coupled to the car.

 */
