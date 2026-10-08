package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("add returns the sum of two numbers")
    void add() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void subtract() {
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "2, 3, 6",
            "-4, 5, -20",
            "0, 9, 0"
    })
    void multiply(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @Test
    void divideByZeroThrows() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("Division by zero", ex.getMessage());
    }
}
