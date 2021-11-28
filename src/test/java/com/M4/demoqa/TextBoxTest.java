package com.M4.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.*;

public class TextBoxTest {

    private static final String URL = "https://demoqa.com/text-box";
    WebDriver driver;
    JavascriptExecutor js;


    @BeforeEach
    void setUp() {
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void submitEmptyForm() {
        driver.get(URL);
        assertEquals(1, driver.findElements(By.className("undefined")).size());

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        assertEquals(1, driver.findElements(By.id("submit")).size());

    }

    @Test
    void submitWrongEmail() {
        driver.get(URL);
        assertEquals(1, driver.findElements(By.className("undefined")).size());

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("prueba.com");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        assertEquals(1, driver.findElements(By.id("submit")).size());

    }

}