package com.autotests.google.calculator;

/**
 * Created by o.budilovsky on 19.03.2017.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import static com.autotests.google.calculator.Variables.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestsSearchResults {

    @BeforeClass
    public static void setUp() throws InterruptedException {
        MathOperations.openGoogleCalculator();
    }

    /**
     * Check Search results (few verifications that page opened successfully - 2-3 tests will be enough)
     **/

    @Test
    public void checkPageTitle() {
        WebDriverWait wait = new WebDriverWait(MathOperations.driver, 0);
        wait.until(visibilityOfElementLocated(By.xpath(GOOGLE_CALCULATOR)));
        assertEquals("google calculator - Google Search" , MathOperations.driver.getTitle());
    }

    @Test
    public void checkStatusCode() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(MathOperations.driver.getCurrentUrl());
        try {
            HttpResponse response = client.execute(request);
            assertEquals(200,response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkUrl() throws InterruptedException {
        assertEquals(true, MathOperations.driver.getCurrentUrl().contains("www.google.com"));
    }

    @Test
    public void checkTextOnPage() throws InterruptedException {
        assertEquals(true, MathOperations.driver.findElement(By.xpath(GOOGLE_NUMBER_RESULTS)).isDisplayed());
    }

    @Test
    public void checkCalculatorElementOnPage() throws InterruptedException {
        assertEquals(true, MathOperations.driver.findElement(By.xpath(CALCULATOR_PANEL)).isEnabled());
    }

    @AfterClass
    public static void tearDown() {
        if (MathOperations.driver != null) MathOperations.driver.quit();
    }

}