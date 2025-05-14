package com.courseIn28Mins.learn_spring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Configure the things that we want Spring to manage
@Configuration

//Tells Spring package where it exists.
@ComponentScan("com.courseIn28Mins.learn_spring.game")
public class GameLauncher {

    //Step 1: Creation of object
    //This is taken care by @Component tag added in all game classes

    public static void main(String[] args) {

        //1. Launch a spring context
        try (var context = new AnnotationConfigApplicationContext(GameLauncher.class)) {

            //2. Retrieving bean's run method
            context.getBean(GameRunner.class).run();

        }

    }
}
