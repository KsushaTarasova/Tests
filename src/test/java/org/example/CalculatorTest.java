package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;
    private int a = 0x141D12;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }
    @Test
    public void testAdd() {
        assertEquals(15, calculator.add(8, Month.JULY.getNumber()));
    }
    @Test
    public void testSubtract() {
        assertEquals(18.2, calculator.subtract(20, 1.8f), 0.001);
        assertEquals(2, calculator.subtract(20, 18));
    }
    @Test
    public void testMultiply() {
        assertEquals(40, calculator.multiply(8, Integer.parseInt("5")));
    }
    @Test
    public void testDivide() {
        assertEquals(7, calculator.divide(28, a));
    }
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(100, 0),
                "ArithmeticException was expected");
    }
    @Test
    public void testModulus(){
        assertEquals(10, calculator.modulus(210, "qwerty".length()));
    }
    @AfterEach
    public void print() {
        System.out.println("Тестирование окончено");
    }

}
