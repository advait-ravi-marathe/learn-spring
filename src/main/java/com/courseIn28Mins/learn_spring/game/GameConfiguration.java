package com.courseIn28Mins.learn_spring.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configure the things that we want Spring to manage
@Configuration
public class GameConfiguration {

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

}
