package com.courseIn28Mins.learn_spring.dependency_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    Field injection - Not using setter or constructor. Dependencies are injected
    using reflection. @Autowired tag is used to wire dependency. If it is directly
    attached to fields, it is field injection.

    Setter injection - Using setter to inject dependencies. In this case, @Autowired
    is attached to setter.

    Constructor injection - Using constructor to inject dependencies. In this case,
    @Autowired is attached to constructor. Although it is not mandatory to attach
    the tag. It automatically injects dependencies.

    Constructor injection is recommended as all initialisations happen at a go.
    This allows us to use bean readily.

*/

@Component
class MyBusiness {

    FirstDependency firstDependency;
    SecondDependency secondDependency;

    public MyBusiness(FirstDependency firstDependency, SecondDependency secondDependency) {
        System.out.println("Using constructor to inject dependencies");
        this.firstDependency = firstDependency;
        this.secondDependency = secondDependency;
    }

    /*
        Example of setter injection

        @Autowired
        public void setFirstDependency(FirstDependency firstDependency) {
            System.out.println("Setting first dependency");
            this.firstDependency = firstDependency;
        }

        @Autowired
        public void setSecondDependency(SecondDependency secondDependency) {
            System.out.println("Setting second dependency");
            this.secondDependency = secondDependency;
        }
     */


    @Override
    public String toString() {
        return "Using " + firstDependency + " and " + secondDependency;
    }
}

@Component
class FirstDependency {

}

@Component
class SecondDependency {

}

//Configure the things that we want Spring to manage
@Configuration

//Tells Spring package where it exists.
@ComponentScan
public class DILauncher {

    //Step 1: Creation of object
    //This is taken care by @Component tag added in all game classes

    public static void main(String[] args) {

        //1. Launch a spring context
        try (var context = new AnnotationConfigApplicationContext(DILauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(MyBusiness.class));
        }

    }
}
