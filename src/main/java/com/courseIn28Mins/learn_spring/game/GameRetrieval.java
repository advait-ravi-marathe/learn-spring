package com.courseIn28Mins.learn_spring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameRetrieval {

    public static void main(String[] args) {

        //1. Launch a spring context
        try (var context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {

            //2. Retrieving bean's up method
            context.getBean(GamingConsole.class).up();

        }

    }
}
