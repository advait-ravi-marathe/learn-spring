package com.courseIn28Mins.learn_spring.business_calculation_service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoDBDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55};
    }
}
