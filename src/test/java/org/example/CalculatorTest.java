package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    public void testMultiply() {
        assertEquals(40, calculator.multiply(8, 5));
    }
    @Test
    public void testDivide() {
        assertEquals(7, calculator.divide(28, 4));
    }
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(100, 0);
        }, "ArithmeticException was expected");
    }

}
