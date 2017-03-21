package com.autotests.google.calculator;

/**
 * Created by o.budilovsky on 19.03.2017.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.autotests.google.calculator.MathOperations.*;

public class TestsCalculatorFunctionality {

    @BeforeClass
    public static void setUp() throws InterruptedException {
        openGoogleCalculator();
    }

    /**
     * Check Calculator functionality (few test for positive/negative scenarios of main operations - 10 tests will be enough)
     **/

    @Test //Positive
    public void checkCalculatorFunctionalitySumTest1() throws InterruptedException {
        long[] numbers = {1, 1, 100, 1000, 10000, 9999999};
        sum(numbers, "10011101");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalitySumTest2() throws InterruptedException {
        long[] numbers = {0, 0};
        sum(numbers, "0");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalitySumTest3() throws InterruptedException {
        long[] numbers = {-9999999, 9999999};
        sum(numbers, "0");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalityMultiplicationTest1() throws InterruptedException {
        long[] numbers = {12345679, 9};
        multiplication(numbers, "111111111");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalityMultiplicationTest2() throws InterruptedException {
        long[] numbers = {0, 0};
        multiplication(numbers, "0");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalityMultiplicationTest3() throws InterruptedException {
        long[] numbers = {111111111, 111111111};
        multiplication(numbers, "1.2345679e+16");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalityMultiplicationTest4() throws InterruptedException {
        long[] numbers = {43434, -122, 0};
        multiplication(numbers, "0");
        reset();
    }

    @Test //Positive
    public void checkCalculatorFunctionalityDivisionTest1() throws InterruptedException {
        double[] numbers = {1111111, 1, 11, -1};
        division(numbers, "-101010.090909");
        reset();
    }

    @Test //Negative
    public void checkCalculatorFunctionalityDivisionTest2() throws InterruptedException {
        double[] numbers = {1, 0};
        division(numbers, "Infinity");
        reset();
    }

    @Test //Negative
    public void checkCalculatorFunctionalitySquareRootTest1() throws InterruptedException {
        squareroot(-1, "Error");
        reset();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
    }

}