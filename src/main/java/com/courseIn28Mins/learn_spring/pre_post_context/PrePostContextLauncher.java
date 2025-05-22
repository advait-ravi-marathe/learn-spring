package com.courseIn28Mins.learn_spring.pre_post_context;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    @PostConstruct is used to execute a bean as soon as object is constructed.

    @PreDestroy is used to execute a bean just before the object is destroyed.
 */

@Component
class DemoClass {

    private Dependency dependency;

    public DemoClass(Dependency dependency) {
        this.dependency = dependency;
        System.out.println("All dependencies are initialized");
    }

    @PostConstruct
    public void initialFunction() {
        dependency.initialFunction();
    }

    @PreDestroy
    public void closingFunction() {
        dependency.closingFunction();
    }
}

@Component
class Dependency {

    public void initialFunction() {
        System.out.println("Initial dependency function is been called");
    }

    public void closingFunction() {
        System.out.println("Dependency closure function is been called");
    }
}

@Configuration
@ComponentScan
public class PrePostContextLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostContextLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

