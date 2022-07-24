package com.lab.springlab.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    private Calculator calculator;
    String numFilepath;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = getClass()
                .getResource("/s.txt")
                .getPath();
    }

    @Test
    public void sumOfNumbersOrigin() throws IOException {
        int sum = calculator.calcSumOrigin(numFilepath);
        assertEquals(sum, 10);
    }

    @Test
    public void sumOfNumbersRefactor() throws IOException {
        int sum = calculator.calcSumRefactor(numFilepath);
        assertEquals(sum, 10);
    }

    @Test
    public void mulOfNumbersRefactor() throws IOException {
        int sum = calculator.calcMulRefactor(numFilepath);
        assertEquals(sum, 24);
    }
}
