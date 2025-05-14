package com.courseIn28Mins.learn_spring.person;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonRetrieval {
    public static void main(String[] args) {

        //1. Launch a spring context
        //Putting context declaration in try block so that it gets automatically
        //closed once scope is complete, or it will exit if there is any exception.

        try (var context = new AnnotationConfigApplicationContext(PersonConfiguration.class)) {

            //2. Configure the things that we want Spring to manage
            // PersonConfiguration - @Configuration
            // name - @Bean

            //3. Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("addressLine1"));
            System.out.println(context.getBean("addressLine2"));
            System.out.println(context.getBean("phone"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2Address"));

            //One can also retrieve bean by passing class
            System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean("firstPerson"));
            System.out.println(context.getBean("secondPerson"));
            System.out.println(context.getBean("thirdPerson"));

            //List of all beans managed by Spring
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
