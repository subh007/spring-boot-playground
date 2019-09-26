package com.example.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplicatoin() {
        Multiplication multiplication = new Multiplication(randomGeneratorService.generateRandomFactor(),
                randomGeneratorService.generateRandomFactor());
        multiplication.setResult(multiplication.getFactorA() * multiplication.getFactorB());
        return multiplication;
    }
}
