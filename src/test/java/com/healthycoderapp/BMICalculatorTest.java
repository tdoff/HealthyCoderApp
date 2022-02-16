package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_DietRecommended() {

        // given (arrange)
        double weight = 89.0;
        double height = 1.72;

        // when (act)
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then (assert)
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {

        // given (arrange)
        double weight = 50;
        double height = 1.92;

        // when (act)
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then (assert)
        assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {

        // given (arrange)
        double weight = 50;
        double height = 0;

        // when (act)
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then (assert)
        assertThrows(ArithmeticException.class, executable);
    }
}