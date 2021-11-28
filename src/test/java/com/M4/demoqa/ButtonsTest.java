package com.M4.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class ButtonsTest {

        WebDriver webDriver;
        final String targetUrl = "https://demoqa.com/buttons";

        @BeforeEach
        void setUp() {
            String dir = System.getProperty("user.dir");
            String chromeUrl = "/drivers/chromedriver.exe";
            String driverUrl = dir + chromeUrl;
            System.setProperty("webdriver.chrome.driver",driverUrl);
            webDriver = new ChromeDriver(); // Chrome/Chromium
            webDriver.get(targetUrl);
        }
        @AfterEach
        void tearDown() {webDriver.quit();}

        @Test
        void DoubleClickButton(){

            assumeTrue(0 == webDriver.findElements(By.id("doubleClickMessage")).size());

            WebElement button = webDriver.findElement(By.id("doubleClickButton"));


            Actions action = new Actions(webDriver);
            action.doubleClick(button).perform();

            WebElement buttonMessage = webDriver.findElement(By.id("doubleClickMessage"));

            assertEquals("You have done a double click",buttonMessage.getText());
        }
    @Test
    void RightClickButton(){


        assumeTrue(0 == webDriver.findElements(By.id("rightClickMessage")).size());

        WebElement button = webDriver.findElement(By.id("rightClickButton"));


        Actions action = new Actions(webDriver);
        action.contextClick(button).perform();

        WebElement buttonMessage = webDriver.findElement(By.id("rightClickMessage"));

        assertEquals("You have done a right click",buttonMessage.getText());

    }
    @Test
    void DynamicClickButton(){

        assumeTrue(0 == webDriver.findElements(By.id("dynamicClickMessage")).size());

        WebElement button = webDriver.findElement(By.xpath("//button[text() = 'Click Me']"));

            button.click();
        WebElement buttonMessage = webDriver.findElement(By.id("dynamicClickMessage"));

        assertEquals("You have done a dynamic click", buttonMessage.getText());

    }
}

