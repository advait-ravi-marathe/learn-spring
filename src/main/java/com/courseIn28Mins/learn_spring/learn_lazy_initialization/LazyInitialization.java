package com.courseIn28Mins.learn_spring.learn_lazy_initialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    By default, Eager initialization is done. I.e. the class "FirstField" gets
    automatically initialized as soon as Spring context is launched.

    By adding @Lazy tag to class "Member", it only gets initialized when the
    class is consumed else where.

    Eager initialization is always recommended. That is because it helps us to
    discover errors in configuration immediately at app start-up

    One should not use lazy initialization. Lazy annotation:
        - Can be used almost everywhere @Component and @Bean are used.
        - Lazy resolution proxy will be injected instead of actual dependency.
        - It can be also used on @Configuration class. All @Bean methods will be
          lazily initialized.
 */

@Component
class FirstField {

}

@Component
@Lazy
class Member {
    private FirstField firstField;

    public Member(FirstField firstField) {
        System.out.println("Initialization of field member");
        this.firstField = firstField;
    }

    public void debugPrint() {
        System.out.println("Trying to debug print");
    }
}

@Configuration
@ComponentScan
public class LazyInitialization {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitialization.class)) {
            System.out.println("Initialization of context executed");

            //Class member gets initialized before executing this method.
            context.getBean(Member.class).debugPrint();
        }
    }
}
