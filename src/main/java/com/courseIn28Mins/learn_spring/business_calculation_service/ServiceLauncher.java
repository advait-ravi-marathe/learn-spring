package com.courseIn28Mins.learn_spring.business_calculation_service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ServiceLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ServiceLauncher.class)) {
            System.out.println("Maximum value of array - " + context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
