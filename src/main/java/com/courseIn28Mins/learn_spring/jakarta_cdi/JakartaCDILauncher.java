package com.courseIn28Mins.learn_spring.jakarta_cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// Use @Named instead of @Component
@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    //Use @Inject instead of @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Data service is set");
        this.dataService = dataService;
    }
}

// Use @Named instead of @Component
@Named
class DataService {
}

@Configuration
@ComponentScan
public class JakartaCDILauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(JakartaCDILauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
