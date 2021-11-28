package com.M4.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DatePickerTest extends BaseTest {

    private static final String URL = "https://demoqa.com/date-picker";

    @Test
    void datePicker() {
        webdriver.get(URL);
        WebElement input = webdriver.findElement(By.id("datePickerMonthYearInput"));
        String fecha_String = input.getAttribute("value");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate fecha = LocalDate.parse(fecha_String, formato);
        System.out.println(fecha.toString());
        System.out.println(LocalDate.now());

        assertEquals(fecha.toString(), LocalDate.now().toString());

        String[] dateParts = fecha_String.split("/");
        System.out.println(Arrays.toString(dateParts));

        LocalDate WebDate = LocalDate.of(
                Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[0]),
                Integer.parseInt(dateParts[1])
        );

        assertEquals(WebDate.toString(), LocalDate.now().toString());

    }

    @Test
    void dateTime() {
        webdriver.get(URL);
        WebElement input = webdriver.findElement(By.id("dateAndTimePickerInput"));
        input.click();

        input = webdriver.findElement(By.id("dateAndTimePickerInput"));
        String dateString = input.getAttribute("value");

        assertTrue(dateString.contains("5:00 AM"));

    }

}
