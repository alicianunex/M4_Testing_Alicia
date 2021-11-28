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

public class FormTest {


    private static final String URL = "https://demoqa.com/automation-practice-form";
    WebDriver webdriver;
    JavascriptExecutor js;


    @BeforeEach
    void setUp() {
        String dir = System.getProperty("user.dir");
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        webdriver = new ChromeDriver();
        js = (JavascriptExecutor) webdriver;
        webdriver.get(URL);
    }

    @AfterEach
    void tearDown() {
        webdriver.quit();
    }


    @Test
    void sectionFirstName() {
       webdriver.findElement(By.id("firstName")).sendKeys("FirstNameExample");
        assertEquals("FirstNameExample",webdriver.findElement(By.id("firstName")).getAttribute("value"));

    }

    @Test
    void sectionLastName() {
        webdriver.findElement(By.id("lastName")).sendKeys("LastNameExample");
        assertEquals("LastNameExample",webdriver.findElement(By.id("lastName")).getAttribute("value"));

    }

    @Test
    void sectionSubjects()  {
        String MenuCss = ".subjects-auto-complete__menu";
        webdriver.findElement(By.cssSelector("#subjectsInput")).sendKeys("M");
        WebElement menu = webdriver.findElement(By.cssSelector(MenuCss));
        System.out.println(menu.getAttribute("innerHTML"));
        js.executeScript("arguments[0].scrollIntoView();", menu);

        String mathSelector = "//div[text()='Maths' and contains(@class, 'subjects-auto-complete__option')]";
        webdriver.findElement(By.xpath(mathSelector)).click();

        String mathDiv = "//div[contains(@class,'css-12jo7m5 subjects-auto-complete__multi-value__label')]";

        assertTrue(webdriver.findElement(By.xpath(mathDiv)).isDisplayed());

    }
    @Test
    void sectionCurrentAddress()  {

        WebElement upload = webdriver.findElement(By.id("currentAddress"));

        upload.sendKeys("ExampleTest");
        assertEquals("ExampleTest",webdriver.findElement(By.id("lastName")).getAttribute("value"));

    }

    @Test
    void sectionStateCity()  {

        js.executeScript("arguments[0].scrollIntoView();", webdriver.findElement(By.id("state")));
        webdriver.findElement(By.id("state")).click();

        WebElement StateMenuBar = webdriver.findElement(By.xpath("//div[@id='stateCity-wrapper']//div[contains(@class, 'css-') and contains(@class,'-menu')]"));
        System.out.println(StateMenuBar.getAttribute("innerHTML"));

        webdriver.findElement(By.id("react-select-3-option-2")).click();
        assertTrue(webdriver.findElement(By.cssSelector("#city")).isEnabled());

    }
    @Test
    void SubmitButton(){

        webdriver.findElement(By.id("submit")).click();
        assertTrue(webdriver.findElement(By.id("closeLargeModal")).isDisplayed());


    }
}

