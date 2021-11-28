package com.M4.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class SendTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        String driverURL = "D:\\Nueva carpeta\\Curriculum\\Adecco\\Curso Testing Java\\Temario\\Modulo_4_Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverURL);
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void GoogleSearch(){
        // https://www.selenium.dev/es/documentation/getting_started/installing_browser_drivers/

        driver.get("https://google.es");
        WebElement acceptButton = driver.findElement(By.xpath("//div[text() = 'Acepto']"));
        acceptButton.click();
        assertEquals("jyfHyd", acceptButton.getAttribute("class"));
        WebElement input2 = driver.findElement(By.name("q"));

        input2.sendKeys("Selenium Java Docs");
        input2.submit();

        sleep();

    }
    @Test
    void Dropdown(){
        // https://www.selenium.dev/es/documentation/getting_started/installing_browser_drivers/

        driver.get("https://seleniumbase.io/demo_page");
        WebElement options = driver.findElement(By.cssSelector("@mySelect option"));
        assertEquals(4,options.getSize());
        sleep();
    }
     static void sleep() {
        try{
            Thread.sleep(10000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
