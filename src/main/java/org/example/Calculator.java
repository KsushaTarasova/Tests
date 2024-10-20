package org.example;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    public float subtract(int a, float b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        return a % b;
    }
}
