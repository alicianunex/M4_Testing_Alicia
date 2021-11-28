package com.M4.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    WebDriver webdriver;
    JavascriptExecutor js;

    @BeforeEach
    void setup() {

        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        webdriver = new ChromeDriver();
        js = (JavascriptExecutor) webdriver;
        webdriver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();

    }


}
