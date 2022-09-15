package com.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
    }

    @Test
    void step1EmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void step1OneNumber() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void step1AddTwoNumbers() {
        assertEquals(5, calculator.add("2,3"));
    }

}
