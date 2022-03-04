package org.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity2 {
    WebDriver driver;
    @Test
    public void verifyPageTitle()  {
        WebElement headerURL = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        System.out.println("Orange HRM header link url is: "+ headerURL.getAttribute("src"));
        System.out.println("Activity 2 executed successfully");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @AfterMethod
    public void afterMethod() {
        driver.close();

    }
}