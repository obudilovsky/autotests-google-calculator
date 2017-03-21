package com.autotests.google.calculator;

/**
 * Created by o.budilovsky on 19.03.2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import static com.autotests.google.calculator.Variables.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MathOperations {

    public static WebDriver driver;

    public static void openGoogleCalculator() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(GOOGLE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 0);
        wait.until(visibilityOfElementLocated(By.xpath(GOOGLE_TITLE)));
        wait.until(visibilityOfElementLocated(By.id(GOOGLE_INPUT)));
        driver.findElement(By.id(GOOGLE_INPUT)).clear();
        driver.findElement(By.id(GOOGLE_INPUT)).sendKeys("google calculator");
    }

    public static void reset() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(CALCULATOR_PANEL))).build().perform();
        driver.findElement(By.xpath(CALCULATOR_PANEL)).click();
        driver.findElement(By.xpath(CALCULATOR_INPUT)).sendKeys(Keys.chord("0"));
    }

    public static void sum(long numbers[], String result) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(CALCULATOR_PANEL))).build().perform();
        driver.findElement(By.xpath(CALCULATOR_PANEL)).click();
        int counter = 1;
        for (long number : numbers) {
            driver.findElement(By.xpath(CALCULATOR_INPUT)).sendKeys(Keys.chord(String.valueOf(number)));
            if (counter != numbers.length) driver.findElement(By.xpath(CALCULATOR_SUM)).click();
            counter++;
        }
        driver.findElement(By.xpath(CALCULATOR_EQU)).click();
        assertEquals(result , driver.findElement(By.id(CALCULATOR_INPUT_RESULT)).getText());
    }

    public static void multiplication(long numbers[], String result) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(CALCULATOR_PANEL))).build().perform();
        driver.findElement(By.xpath(CALCULATOR_PANEL)).click();
        int counter = 1;
        for (long number : numbers) {
            driver.findElement(By.xpath(CALCULATOR_INPUT)).sendKeys(Keys.chord(String.valueOf(number)));
            if (counter != numbers.length) driver.findElement(By.xpath(CALCULATOR_MUL)).click();
            counter++;
        }
        driver.findElement(By.xpath(CALCULATOR_EQU)).click();
        assertEquals(result , driver.findElement(By.id(CALCULATOR_INPUT_RESULT)).getText());
    }

    public static void division(double numbers[], String result) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(CALCULATOR_PANEL))).build().perform();
        driver.findElement(By.xpath(CALCULATOR_PANEL)).click();
        int counter = 1;
        for (double number : numbers) {
            driver.findElement(By.xpath(CALCULATOR_INPUT)).sendKeys(Keys.chord(String.valueOf(number)));
            if (counter != numbers.length) driver.findElement(By.xpath(CALCULATOR_DIV)).click();
            counter++;
        }
        driver.findElement(By.xpath(CALCULATOR_EQU)).click();
        assertEquals(result , driver.findElement(By.id(CALCULATOR_INPUT_RESULT)).getText());
    }

    public static void squareroot(double number, String result) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(CALCULATOR_PANEL))).build().perform();
        driver.findElement(By.xpath(CALCULATOR_PANEL)).click();
        driver.findElement(By.xpath(CALCULATOR_SQRRT)).click();
        driver.findElement(By.xpath(CALCULATOR_INPUT)).sendKeys(Keys.chord(String.valueOf(number)));
        driver.findElement(By.xpath(CALCULATOR_EQU)).click();
        assertEquals(result , driver.findElement(By.id(CALCULATOR_INPUT_RESULT)).getText());
    }

}