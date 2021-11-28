package com.M4.drivers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.*;

public class ChromeTest {

    WebDriver webdriver;

    @BeforeEach
    void setup() {
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        webdriver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();

    }

    @Test
    void OpenGooglePage(){
        webdriver.get("https://www.google.es/");
        String title = webdriver.getTitle();
        assertEquals("Google",title);
    }

    @Test
    void GitHubMozillaPage () {
        webdriver.get("https://github.com/mozilla");
        String title = webdriver.getTitle ();
        assertEquals("Mozilla - Github", title);
    }


}
