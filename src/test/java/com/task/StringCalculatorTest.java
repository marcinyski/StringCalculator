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

    @Test
    void step2UnknownAmountOfNumbers() {
        assertEquals(6, calculator.add("2,3,1"));
        assertEquals(10, calculator.add("2,3,1,4,0"));
        assertEquals(33, calculator.add("2,3,1,2,3,4,5,6,7"));
    }

    @Test
    void step3SupportForNewLinesBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2\n3"));
        assertEquals(10, calculator.add("2\n3,1\n4,0"));
    }

    @Test
    void step4SupportForDifferentDelimiters() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void step5NegativeNumberWillThrowException() {
        try {
            calculator.add("//;\n-1;2;-3");
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: -1,-3", e.getMessage());
        }
    }

    @Test
    void step6IgnoreNumbersGreaterThan1000() {
        assertEquals(6, calculator.add("1\n2\n3\n1003"));
        assertEquals(10, calculator.add("2\n3,1\n4,1001"));
        assertEquals(3, calculator.add("//;\n1;2;1001"));
    }

    @Test
    void step7AnyLengthDelimiter() {
        assertEquals(6, calculator.add("//[,,,]\n1,,,2,,,3"));
        assertEquals(8, calculator.add("//[***]\n1***2***5"));
        assertEquals(7, calculator.add("//[*,*,,]\n1*,*,,2*,*,,4"));
    }

}
