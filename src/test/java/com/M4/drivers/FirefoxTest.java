package com.M4.drivers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirefoxTest {

    WebDriver webdriver;

    @BeforeEach
    void setup() {
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/geckodriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.gecko.driver", url);
        webdriver = new FirefoxDriver();
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
