package com.sphere.nexus.impl;

import com.sphere.nexus.exception.DivisionByZeroException;
import com.sphere.nexus.exception.NoArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService;
    private Random random;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
        random = new Random(42);
    }

    @Test
    void sayHello() {
        String expected = "Добро пожаловать в калькулятор";
        String actual = calculatorService.sayHello();

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void sum() {
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);

        String expected = String.valueOf(a + b);
        String actual = calculatorService.sum(a, b);

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void subtraction() {
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);

        String expected = String.valueOf(a - b);
        String actual = calculatorService.subtraction(a, b);

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void multiplication() {
        int a = random.nextInt(100);
        int b = random.nextInt(100);

        String expected = String.valueOf(a * b);
        String actual = calculatorService.multiplication(a, b);

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void division() {
        int a = random.nextInt(0,1000);
        int b = random.nextInt(1,1000);

        String expected = String.valueOf(a / b);
        String actual = calculatorService.division(a, b);

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void divisionByZeroException() {
        assertThatThrownBy(() -> calculatorService.division(123, 0))
                .isInstanceOf(DivisionByZeroException.class)
                .hasMessage("Делить на ноль нельзя!");
    }
    @RepeatedTest(10)
    void exceptionWhenArgumentsAreNull() {
        assertThatThrownBy(() -> calculatorService.sum(null, 5))
                .isInstanceOf(NoArgumentException.class);
        assertThatThrownBy(() -> calculatorService.subtraction(5, null))
                .isInstanceOf(NoArgumentException.class);
        assertThatThrownBy(() -> calculatorService.multiplication(null, null))
                .isInstanceOf(NoArgumentException.class);
        assertThatThrownBy(() -> calculatorService.division(null, 1))
                .isInstanceOf(NoArgumentException.class);
    }
}