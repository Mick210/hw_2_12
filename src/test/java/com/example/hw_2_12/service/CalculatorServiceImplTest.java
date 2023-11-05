package com.example.hw_2_12.service;

import com.example.hw_2_12.exeption.DivideByZeroException;
import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private CalculatorService calculatorService = new CalculatorServiceImpl();

    private static final int POSITIVE_VALUE = 11;
    private static final int NEGATIVE_VALUE = -6;
    private static final int ZERO = 0;

    public static Stream<Arguments> plusCases() {
        return Stream.of(
                Arguments.of(POSITIVE_VALUE, POSITIVE_VALUE, POSITIVE_VALUE + POSITIVE_VALUE),
                Arguments.of(NEGATIVE_VALUE, NEGATIVE_VALUE, NEGATIVE_VALUE + NEGATIVE_VALUE),
                Arguments.of(ZERO, NEGATIVE_VALUE, ZERO + NEGATIVE_VALUE)
        );
    }

    public static Stream<Arguments> minusCases() {
        return Stream.of(
                Arguments.of(POSITIVE_VALUE, POSITIVE_VALUE, POSITIVE_VALUE - POSITIVE_VALUE),
                Arguments.of(NEGATIVE_VALUE, NEGATIVE_VALUE, NEGATIVE_VALUE - NEGATIVE_VALUE),
                Arguments.of(ZERO, NEGATIVE_VALUE, ZERO - NEGATIVE_VALUE),
                Arguments.of(POSITIVE_VALUE, NEGATIVE_VALUE, POSITIVE_VALUE - NEGATIVE_VALUE)
        );
    }

    public static Stream<Arguments> multiplyCases() {
        return Stream.of(
                Arguments.of(POSITIVE_VALUE, POSITIVE_VALUE, POSITIVE_VALUE * POSITIVE_VALUE),
                Arguments.of(NEGATIVE_VALUE, NEGATIVE_VALUE, NEGATIVE_VALUE * NEGATIVE_VALUE),
                Arguments.of(ZERO, NEGATIVE_VALUE, ZERO * NEGATIVE_VALUE),
                Arguments.of(POSITIVE_VALUE, NEGATIVE_VALUE, POSITIVE_VALUE * NEGATIVE_VALUE)
        );
    }

    public static Stream<Arguments> divideCases() {
        return Stream.of(
                Arguments.of(POSITIVE_VALUE, POSITIVE_VALUE, POSITIVE_VALUE / POSITIVE_VALUE),
                Arguments.of(NEGATIVE_VALUE, NEGATIVE_VALUE, NEGATIVE_VALUE / NEGATIVE_VALUE),
                Arguments.of(ZERO, NEGATIVE_VALUE, ZERO / NEGATIVE_VALUE),
                Arguments.of(POSITIVE_VALUE, NEGATIVE_VALUE, POSITIVE_VALUE / NEGATIVE_VALUE)
        );
    }


    @Test
    void plus() {
        int result = calculatorService.plus(POSITIVE_VALUE, POSITIVE_VALUE);
        assertEquals(POSITIVE_VALUE + POSITIVE_VALUE, result);
    }

    @ParameterizedTest
    @MethodSource("plusCases")
     void plusParams(int num1, int num2, int expected) {
        int result = calculatorService.plus(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    void minus() {
        int result = calculatorService.minus(NEGATIVE_VALUE, POSITIVE_VALUE);
        assertEquals(NEGATIVE_VALUE - POSITIVE_VALUE, result);
    }

    @ParameterizedTest
    @MethodSource("minusCases")
    void minusParams(int num1, int num2, int expected) {
        int result = calculatorService.minus(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    void multiply() {
        int result = calculatorService.multiply(NEGATIVE_VALUE, POSITIVE_VALUE);
        assertEquals(NEGATIVE_VALUE * POSITIVE_VALUE, result);
    }

    @ParameterizedTest
    @MethodSource("multiplyCases")
    void multiplyParams(int num1, int num2, int expected) {
        int result = calculatorService.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    void divide() {
        int result = calculatorService.divide(NEGATIVE_VALUE, NEGATIVE_VALUE);
        assertEquals(NEGATIVE_VALUE / NEGATIVE_VALUE, result);
    }

    @ParameterizedTest
    @MethodSource("divideCases")
    void divideParams(int num1, int num2, int expected) {
        int result = calculatorService.divide(num1, num2);
        assertEquals(expected, result);
    }

    @Test
    void divideByZero() {
        assertThrows(DivideByZeroException.class, () -> calculatorService.divide(POSITIVE_VALUE, ZERO));
    }
}