package com.courseIn28Mins.learn_spring.person;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String addressLine1, String addressLine2) {
};

//Passing Address record as object to Person record.
record Person(String name, int age, long phone, Address address) {
};

//Configure the things that we want Spring to manage
@Configuration
public class PersonConfiguration {

    @Bean
    public String name() {
        return "Advait";
    }

    @Bean
    public int age() {
        return 24;
    }

    @Bean
    public String addressLine1() {
        return "UGF007, P7, Prateek Grand City - Paeonia";
    }

    @Bean
    public String addressLine2() {
        return "Siddharth Vihar, Indirapuram";
    }

    @Bean
    public long phone() {
        return 9158787016L;
    }

    @Bean
    public Person person() {
        return new Person("Akshat", 29, 9158987016L, address2());
    }

    //By passing name attribute, one can give custom name to its bean.
    //Making bean primary avoids any discrepancy if there are multiple candidates.
    @Bean(name = "person1Address")
    @Primary
    public Address address1() {
        return new Address("UGF007, P7, Prateek Grand City - Paeonia", "Siddharth Vihar, Indirapuram");
    }

    //Other way to resolve the problem is by using qualifiers
    @Bean(name = "person2Address")
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("A-1002, Oxy Eterno", "Dhanori");
    }


    //Creating person by using existing beans.
    //1. By method call
    @Bean
    public Person secondPerson() {
        return new Person(name(), age(), phone(), address2());
    }

    //2. By passing parameters, it looks for beans with same name as parameters passed in constructor
    @Bean
    public Person firstPerson(String name, int age, long phone, Address person1Address) {
        return new Person(name, age, phone, person1Address);
    }

    // Throws error. Says no matching candidate found for address.
    @Bean
    public Person thirdPerson(String name, int age, long phone, @Qualifier("address2Qualifier") Address address) {
        return new Person(name, age, phone, address);
    }
}
