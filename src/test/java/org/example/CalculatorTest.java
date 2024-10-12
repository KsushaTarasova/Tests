package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }
    @Test
    public void testAdd() {
        assertEquals(15, calculator.add(8, 7));
    }
    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(20, 18));
    }
}
