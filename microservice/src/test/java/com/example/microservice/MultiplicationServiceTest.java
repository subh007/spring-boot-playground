package com.example.microservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplicationTest() {

        BDDMockito.given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        Multiplication randomMultiplicatoin = multiplicationService.createRandomMultiplicatoin();

        assertEquals(randomMultiplicatoin.getFactorA(), 50);
        assertEquals(randomMultiplicatoin.getFactorB(), 30);
        assertEquals(randomMultiplicatoin.getResult(), 1500);

    }
}