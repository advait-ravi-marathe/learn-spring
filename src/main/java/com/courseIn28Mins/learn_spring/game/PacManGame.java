package com.courseIn28Mins.learn_spring.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//Spring will start creating objects itself.

//Tells Spring framework that it will manage this class
@Component
public class PacManGame implements GamingConsole {
    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Down");
    }

    public void left() {
        System.out.println("Left");
    }

    public void right() {
        System.out.println("Right");
    }
}
