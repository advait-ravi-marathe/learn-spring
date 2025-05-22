package com.courseIn28Mins.learn_spring.bean_scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
    Types of scopes -

        - Singleton - One object instance per Spring IoC container.

        - Prototype - Possibly many instances per Spring IoC container.

        - Scopes applicable only for web aware SpringApplicationContext
            * Request - An object instance per single HTTP request
            * Session - An object instance per user HTTP session
            * Application - An object instance per web app runtime
            * Web Socket - An object instance per web socket instance.

    Java Singleton (GOF) VS Spring Singleton -

        - Spring Singleton - An object instance per Spring IoC container.

        - Java Singleton (GOF) - One object instance per JVM
 */

@Component
class NormalClass {

}

@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopeLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopeLauncher.class)) {
            //Returns same instance of bean after bean is initialized.
            //It can be also said that the underlying class is simpleton
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            //Returns new instance of bean every time getBean is called
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
