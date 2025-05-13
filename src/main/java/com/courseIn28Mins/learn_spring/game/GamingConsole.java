package com.courseIn28Mins.learn_spring.game;

/*
    Introduced loose coupling by implementing interface.
    This interface implements common methods of all games.

    In this manner all the game functions can be maintained
    independently, and we will be able to run all games which
    implement the given interface without making changes in
    main runner class
 */

public interface GamingConsole {
    void up();
    void down();
    void left();
    void right();
}
