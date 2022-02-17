package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
                () -> assertEquals(1.82, coderWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(coderWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScores);
    }
}