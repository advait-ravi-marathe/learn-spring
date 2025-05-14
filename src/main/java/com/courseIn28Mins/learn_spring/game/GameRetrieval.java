package com.courseIn28Mins.learn_spring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configure the things that we want Spring to manage
@Configuration
public class GameRetrieval {

    //Step 1: Creation of object
    @Bean
    public GamingConsole game() {
        return new PacManGame();
    }

    //Retrieves bean named game and passes that as a parameter
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

    public static void main(String[] args) {

        //1. Launch a spring context
        try (var context = new AnnotationConfigApplicationContext(GameRetrieval.class)) {

            //2. Retrieving bean's up method
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }

    }
}
