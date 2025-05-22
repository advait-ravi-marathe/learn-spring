package com.courseIn28Mins.learn_spring.business_calculation_service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessCalculationService {

    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}
